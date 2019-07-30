package me.yohom.fluttify.common.tmpl.kotlin

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.simpleName
import me.yohom.fluttify.common.model.Type

//package #__package_name__#
//
//import android.content.Context
//import android.view.View
//
//import io.flutter.plugin.common.EventChannel
//import io.flutter.plugin.common.MethodChannel
//import io.flutter.plugin.common.StandardMessageCodec
//import io.flutter.plugin.platform.PlatformView
//import io.flutter.plugin.platform.PlatformViewFactory
//import io.flutter.plugin.common.PluginRegistry.Registrar
//
//class #__factory_name__#Factory(private val registrar: Registrar) : PlatformViewFactory(StandardMessageCodec.INSTANCE) {
//
//    override fun create(context: Context, id: Int, params: Any?): PlatformView {
//        return object : PlatformView {
//            private val view = #__native_view__#(registrar.activity())
//
//            override fun getView(): View = view.apply { REF_MAP[id] = this }
//
//            override fun dispose() {
//                REF_MAP.remove(id)
//            }
//        }
//    }
//}
class PlatformViewFactoryTmpl(
    private val viewType: Type,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/platform_view_factory.kt.tmpl").readText()

    fun kotlinPlatformViewFactory(): String {
        return tmpl
            .replace("#__package_name__#", "${ext.outputOrg}.${ext.outputProjectName}")
            .replace("#__factory_name__#", viewType.name.simpleName())
            .replace("#__native_view__#", viewType.name)
    }
}