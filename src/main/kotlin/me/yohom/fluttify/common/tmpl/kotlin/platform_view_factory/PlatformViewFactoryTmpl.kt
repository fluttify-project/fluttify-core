package me.yohom.fluttify.common.tmpl.kotlin.platform_view_factory

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.filterMethod
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.extensions.simpleName
import me.yohom.fluttify.common.extensions.toUnderscore
import me.yohom.fluttify.common.model.Lib
import me.yohom.fluttify.common.model.Type
import me.yohom.fluttify.common.tmpl.kotlin.common.handler.HandlerMethodTmpl

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
//            // 构造完成后马上加入REF_MAP
//            override fun getView(): View = view.apply { REF_MAP[id] = this }
//
//            // dispose后从REF_MAP中删除
//            override fun dispose() {
//                REF_MAP.remove(id)
//            }
//        }
//    }
//}
class PlatformViewFactoryTmpl(
    private val viewType: Type,
    private val lib: Lib,
    private val ext: FluttifyExtension
) {
    private val tmpl =
        this::class.java.getResource("/tmpl/kotlin/platform_view_factory/platform_view_factory.kt.tmpl").readText()

    fun kotlinPlatformViewFactory(): String {
        return tmpl
            .replace("#__package_name__#", "${ext.outputOrg}.${ext.outputProjectName}")
            .replace("#__factory_name__#", viewType.name.simpleName())
            .replaceParagraph(
                "#__handlers__#",
                viewType.methods.filterMethod().joinToString("\n,") { HandlerMethodTmpl(it).kotlinHandlerMethod() }
            )
            .replace("#__native_view__#", viewType.name)
            .replace(
                "#__method_channel__#",
                "${ext.outputOrg}/${ext.outputProjectName}/${viewType.name.toUnderscore()}"
            )
    }
}