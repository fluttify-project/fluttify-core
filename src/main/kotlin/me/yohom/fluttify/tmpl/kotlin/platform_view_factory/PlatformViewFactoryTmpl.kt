package me.yohom.fluttify.tmpl.kotlin.platform_view_factory

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.kotlin.common.handler.handler_method.HandlerMethodTmpl

//package #__package_name__#
//
//import android.content.Context
//import android.view.View
//import io.flutter.plugin.common.MethodChannel
//import io.flutter.plugin.common.PluginRegistry.Registrar
//import io.flutter.plugin.common.StandardMessageCodec
//import io.flutter.plugin.platform.PlatformView
//import io.flutter.plugin.platform.PlatformViewFactory
//
//class #__factory_name__#Factory(private val registrar: Registrar) : PlatformViewFactory(StandardMessageCodec.INSTANCE) {
//
//    private val handlerMap = mapOf<String, (Registrar, Map<String, Any>, MethodChannel.Result) -> Unit>(
//        #__handlers__#
//    )
//
//    init {
//        MethodChannel(registrar.messenger(), "#__method_channel__#").setMethodCallHandler { methodCall, methodResult ->
//            val args = methodCall.arguments as? Map<String, Any> ?: mapOf()
//            handlerMap[methodCall.method]?.invoke(registrar, args, methodResult)
//                    ?: methodResult.notImplemented()
//        }
//    }
//
//    override fun create(context: Context, id: Int, params: Any?): PlatformView {
//        return object : PlatformView {
//            private val view = #__native_view__#(registrar.activity())
//
//            // 构造完成后马上加入HEAP
//            override fun getView(): View = view.apply { HEAP[id] = this }
//
//            // dispose后从HEAP中删除
//            override fun dispose() {
//                HEAP.remove(id)
//            }
//        }
//    }
//}
class PlatformViewFactoryTmpl(private val viewType: Type) {
    private val tmpl =
        this::class.java.getResource("/tmpl/kotlin/platform_view_factory.kt.tmpl").readText()

    fun kotlinPlatformViewFactory(): String {
        val packageName = "${ext.org}.${ext.projectName}"
        val factoryName= viewType.name.simpleName()
        val handlers = viewType.methods.filterMethod().joinToString("\n,") { HandlerMethodTmpl(it).kotlinHandlerMethod() }
        val nativeView = viewType.name
        val methodChannel = "${ext.methodChannelName}/${viewType.name.toUnderscore()}"

        return tmpl
            .replace("#__package_name__#", packageName)
            .replace("#__factory_name__#", factoryName)
            .replaceParagraph("#__handlers__#", handlers)
            .replace("#__native_view__#", nativeView)
            .replace("#__method_channel__#", methodChannel)

    }
}