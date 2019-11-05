package me.yohom.fluttify.tmpl.java.platform_view_factory

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.java.common.handler.handler_method.HandlerMethodTmpl

//package #__package_name__#;
//
//import android.content.Context;
//import android.view.View;
//import android.util.Log;
//import io.flutter.plugin.common.MethodChannel;
//import io.flutter.plugin.common.PluginRegistry.Registrar;
//import io.flutter.plugin.common.StandardMessageCodec;
//import io.flutter.plugin.platform.PlatformView;
//import io.flutter.plugin.platform.PlatformViewFactory;
//import static me.yohom.foundation_fluttify.FoundationFluttifyPluginKt.getHEAP;;
//import java.util.Map;
//
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
//        return new PlatformView() {
//
//            // add to HEAP
//            @Override
//            public View getView() {
//                #__native_view__# view = new #__native_view__#(registrar.activity());
//                getHEAP().put(id, view);
//                return view;
//            }
//
//            @Override
//            public void dispose() {}
//        };
//    }
//}
class PlatformViewFactoryTmpl(private val viewType: Type) {
    private val tmpl =
        this::class.java.getResource("/tmpl/java/platform_view_factory.java.tmpl").readText()

    fun javaPlatformViewFactory(): String {
        val packageName = "${ext.outputOrg}.${ext.outputProjectName}"
        val factoryName= viewType.name.simpleName()
        val pluginClass= "${ext.outputProjectName.underscore2Camel()}Plugin"
        val handlers = viewType.methods.filterMethod().joinToString("\n") { HandlerMethodTmpl(it).kotlinHandlerMethod() }
        val nativeView = viewType.name
        val methodChannel = "${ext.methodChannelName}/${viewType.name.toUnderscore()}"

        return tmpl
            .replace("#__package_name__#", packageName)
            .replace("#__factory_name__#", factoryName)
            .replace("#__plugin_class__#", pluginClass)
            .replaceParagraph("#__handlers__#", handlers)
            .replace("#__native_view__#", nativeView)
            .replace("#__method_channel__#", methodChannel)

    }
}