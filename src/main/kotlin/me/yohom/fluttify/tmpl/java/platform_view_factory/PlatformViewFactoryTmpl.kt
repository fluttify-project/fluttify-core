package me.yohom.fluttify.tmpl.java.platform_view_factory

import me.yohom.fluttify.SYSTEM_TYPE
import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgEnumTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgRefTmpl
import me.yohom.fluttify.tmpl.java.common.handler.handler_method.HandlerMethodTmpl

//@SuppressWarnings("ALL")
//class #__factory_name__#Factory extends PlatformViewFactory {
//
//    #__factory_name__#Factory(BinaryMessenger messenger, Activity activity) {
//        super(StandardMessageCodec.INSTANCE);
//
//        this.messenger = messenger;
//        this.activity = activity;
//
//        new MethodChannel(messenger, "#__method_channel__#", new StandardMethodCodec(new FluttifyMessageCodec())).setMethodCallHandler((methodCall, methodResult) -> {
//            Map<String, Object> args = (Map<String, Object>) methodCall.arguments;
//            #__plugin_class__#.Handler handler = handlerMap.get(methodCall.method);
//            if (handler != null) {
//                try {
//                    handler.call(args, methodResult);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    methodResult.error(e.getMessage(), null, null);
//                }
//            } else {
//                methodResult.notImplemented();
//            }
//        });
//    }
//
//    private BinaryMessenger messenger;
//    private Activity activity;
//
//    private final Map<String, #__plugin_class__#.Handler> handlerMap = new HashMap<String, #__plugin_class__#.Handler>() {{
//        #__handlers__#
//    }};
//
//    @Override
//    public PlatformView create(Context context, int id, Object params) {
//        Map<String, Object> __args__ = (Map<String, Object>) params;
//
//        ////////////////////////////////初始化AndroidView////////////////////////////////////////
//
//        ////////////////////////////////初始化AndroidView////////////////////////////////////////
//
//        #__native_view__# view = new #__native_view__#(activity);
//
//        // 同时存放viewId和refId的对象, 供后续viewId转refId使用
//        getHEAP().put(String.valueOf(Integer.MAX_VALUE - id), view);
//        getHEAP().put("#__native_view__#:" + String.valueOf(System.identityHashCode(view)), view);
//        return new PlatformView() {
//
//            // add to HEAP
//            @Override
//            public View getView() {
//                return view;
//            }
//
//            @Override
//            public void dispose() {}
//        };
//    }
//}
private val tmpl by lazy { getResource("/tmpl/java/platform_view_factory.java.tmpl").readText() }

fun PlatformViewFactoryTmpl(viewType: Type): String {
    val packageName = "${ext.org}.${ext.projectName}"
    val factoryName = viewType.name.simpleName()
    val pluginClass = "${ext.projectName.underscore2Camel()}Plugin"
    val nativeView = viewType.name

    // 找出是否存在非Context, AttributeSet和int类型参数的构造器
    // 如果存在, 那么以这个构造器进行初始化
    val customConstructorList = viewType
        .constructors
        .filter {
            it.formalParams.any { param ->
                param.variable.trueType !in listOf("android.content.Context", "android.util.AttributeSet", "int")
                        &&
                        param.variable.trueType.findType().isKnownType
                        &&
                        param.variable.trueType !in SYSTEM_TYPE.map { it.name }
            }
        }

    return if (customConstructorList.isNotEmpty()) {
        val constructor = customConstructorList[0]
        // 去掉Context的参数列表, 不需要Context
        val formalParamsExcludeContext = constructor
            .formalParams
            .filter { it.variable.trueType != "android.content.Context" }
            .filter { it.variable.trueType != "android.app.Activity" }

        // 反序列化参数
        val args = formalParamsExcludeContext
            .joinToString("\n") {
                when {
                    it.variable.isEnum() -> ArgEnumTmpl(it.variable)
                    else -> ArgRefTmpl(it.variable)
                }
            }
        // 传入参数
        val creationArgs = constructor.formalParams.joinToString {
            // 如果是Context或者Activity直接传入activity变量
            if (it.variable.trueType.run { this == "android.content.Context" || this == "android.app.Activity" }) {
                "activity"
            } else {
                it.variable.name
            }
        }
        tmpl.replaceParagraph("#__args__#", args)
            .replace("#__creation_args__#", creationArgs)
    } else {
        tmpl.replace("#__args__#", "")
            .replace("#__creation_args__#", "activity")
    }.replace("#__package_name__#", packageName)
        .replace("#__factory_name__#", factoryName)
        .replace("#__plugin_class__#", pluginClass)
        .replace("#__native_view__#", nativeView)
}