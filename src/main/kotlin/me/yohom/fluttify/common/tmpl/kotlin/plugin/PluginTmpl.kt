package me.yohom.fluttify.common.tmpl.kotlin.plugin

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.filterMethod
import me.yohom.fluttify.common.extensions.filterType
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.extensions.underscore2Camel
import me.yohom.fluttify.common.model.Lib
import me.yohom.fluttify.common.tmpl.kotlin.plugin.handlermethod.HandlerMethodTmpl

//package #__package_name__#
//
//import io.flutter.plugin.common.MethodChannel
//import io.flutter.plugin.common.PluginRegistry.Registrar
//
//val REF_MAP = mutableMapOf<Int, Any>()
//
//@Suppress("FunctionName", "UsePropertyAccessSyntax", "RedundantUnitReturnType", "UNUSED_PARAMETER", "SpellCheckingInspection", "ConvertToStringTemplate", "DEPRECATION", "UNUSED_VARIABLE")
//class #__plugin_name__#Plugin {
//    companion object {
//        @JvmStatic
//        fun registerWith(registrar: Registrar) {
//            val channel = MethodChannel(registrar.messenger(), "#__method_channel__#")
//
//            channel.setMethodCallHandler { methodCall, methodResult ->
//                val args = methodCall.arguments as? Map<String, Any> ?: mapOf()
//                when (methodCall.method) {
//                    // 生成系统对象的引用
//                    "SystemRef::getandroid_app_Application" -> {
//                        methodResult.success(registrar.activity().application.apply { REF_MAP[hashCode()] = this }.hashCode())
//                    }
//                    "SystemRef::getandroid_app_Activity" -> {
//                        methodResult.success(registrar.activity().apply { REF_MAP[hashCode()] = this }.hashCode())
//                    }
//                    #__branches__#
//                    else -> methodResult.notImplemented()
//                    }
//                }
//
//            // 注册View
//            #__register_platform_views__#
//		}
//
//		// 与branch对应的方法们
//		#__handlers__#
//    }
//}
class PluginTmpl(
    private val lib: Lib,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/plugin.kt.tmpl").readText()

    fun kotlinPlugin(): String {
        // 包名
        val packageName = "${ext.outputOrg}.${ext.outputProjectName}"

        // 插件名称
        val pluginClassName = ext.outputProjectName.underscore2Camel(true)

        // method channel
        val methodChannel = "${ext.outputOrg}/${ext.outputProjectName}"

        // 处理分支们 由于方法内代码太多, 会导致编译失败, 所以会为每个处理方法单独开一个私有方法
        val branches = lib.types
            .filterType()
            .flatMap { it.methods }
            .filterMethod()
            .joinToString("\n") { BranchTmpl(it).kotlinBranch() }

        // 注册PlatformView
        val registerPlatformViews = lib.types
            .filter { it.isView() }
            .joinToString("\n") { RegisterPlatformViewTmpl(it, ext).kotlinRegisterPlatformView() }

        // 为每个分支单独开的方法
        val handlers = lib.types
            .filterType()
            .flatMap { it.methods }
            .filterMethod()
            .joinToString("\n") { HandlerMethodTmpl(it).kotlinHandlerMethod() }

        return tmpl
            .replace("#__package_name__#", packageName)
            .replace("#__plugin_name__#", pluginClassName)
            .replace("#__method_channel__#", methodChannel)
            .replaceParagraph("#__branches__#", branches)
            .replaceParagraph("#__register_platform_views__#", registerPlatformViews)
            .replaceParagraph("#__handlers__#", handlers)
    }
}