package me.yohom.fluttify.tmpl.java.platform_view_factory

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgEnumTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgJsonableTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgListTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgRefTmpl
import me.yohom.fluttify.tmpl.java.common.handler.handler_method.HandlerMethodTmpl

//package #__package_name__#;
//
//import android.content.Context;
//import android.view.View;
//import android.util.Log;
//
//import java.util.Map;
//import java.util.HashMap;
//
//import io.flutter.plugin.common.MethodChannel;
//import io.flutter.plugin.common.PluginRegistry.Registrar;
//import io.flutter.plugin.common.StandardMessageCodec;
//import io.flutter.plugin.platform.PlatformView;
//import io.flutter.plugin.platform.PlatformViewFactory;
//
//import static me.yohom.foundation_fluttify.FoundationFluttifyPluginKt.getHEAP;
//import static me.yohom.foundation_fluttify.FoundationFluttifyPluginKt.getEnableLog;
//
//@SuppressWarnings("ALL")
//class #__factory_name__#Factory extends PlatformViewFactory {
//
//    #__factory_name__#Factory(Registrar registrar) {
//        super(StandardMessageCodec.INSTANCE);
//
//        this.registrar = registrar;
//
//        new MethodChannel(registrar.messenger(), "#__method_channel__#").setMethodCallHandler((methodCall, methodResult) -> {
//                    Map<String, Object> args = (Map<String, Object>) methodCall.arguments;
//                    #__plugin_class__#.Handler handler = handlerMap.get(methodCall.method);
//                    if (handler != null) {
//                        try {
//                            handler.call(args, methodResult);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                            methodResult.error(e.getMessage(), null, null);
//                        }
//                    } else {
//                        methodResult.notImplemented();
//                    }
//                });
//    }
//
//    private Registrar registrar;
//
//    private final Map<String, #__plugin_class__#.Handler> handlerMap = new HashMap<String, #__plugin_class__#.Handler>() {{
//        #__handlers__#
//    }};
//
//    @Override
//    public PlatformView create(Context context, int id, Object params) {
//        Map<String, Object> args = (Map<String, Object>) params;
//        #__args__#
//
//        #__native_view__# view = new #__native_view__#(registrar.activity()#__creation_args__#);
//        getHEAP().put(id, view);
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
private val tmpl = getResource("/tmpl/java/platform_view_factory.java.tmpl").readText()

fun PlatformViewFactoryTmpl(viewType: Type): String {
    val packageName = "${ext.org}.${ext.projectName}"
    val factoryName = viewType.name.simpleName()
    val pluginClass = "${ext.projectName.underscore2Camel()}Plugin"
    val handlers =
        viewType.methods.filterMethod().joinToString("\n") { HandlerMethodTmpl(it) }
    val nativeView = viewType.name
    val methodChannel = "${ext.methodChannelName}/${viewType.name.toUnderscore()}"

    // 找出是否存在非Context, AttributeSet和int类型参数的构造器
    // 如果存在, 那么以这个构造器进行初始化
    val customConstructorList = viewType
        .constructors
        .filter {
            it.formalParams.any { param ->
                param.variable.trueType !in listOf("android.content.Context", "android.util.AttributeSet", "int")
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
                    it.variable.jsonable() -> ArgJsonableTmpl(it.variable)
                    it.variable.isEnum() -> ArgEnumTmpl(it.variable)
                    it.variable.isIterable -> ArgListTmpl(it.variable)
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
        .replaceParagraph("#__handlers__#", handlers)
        .replace("#__native_view__#", nativeView)
        .replace("#__method_channel__#", methodChannel)
}