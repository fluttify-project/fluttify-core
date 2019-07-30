package me.yohom.fluttify.common.tmpl.kotlin

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.extensions.underscore2Camel
import me.yohom.fluttify.common.model.Lib

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
//            #__register_platform_views__#
//		}
//
//		#__handlers__#
//    }
//}
class PluginTmpl(
    private val lib: Lib,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/plugin.kt.tmpl").readText()

    fun kotlinPlugin(): String {
        val packageName = "${ext.outputOrg}.${ext.outputProjectName}"
        val pluginClassName = ext.outputProjectName.underscore2Camel(true)
        val methodChannel = "${ext.outputOrg}/${ext.outputProjectName}"
        val branches = lib.types
            .flatMap { it.methods }
            .joinToString("\n") { BranchTmpl(it).kotlinBranch() }
        val registerPlatformViews = lib.types
            .filter { it.isView() }
            .joinToString("\n") { RegisterPlatformViewTmpl(it, ext).kotlinRegisterPlatformView() }

        return tmpl
            .replace("#__package_name__#", packageName)
            .replace("#__plugin_name__#", pluginClassName)
            .replace("#__method_channel__#", methodChannel)
            .replaceParagraph("#__branches__#", branches)
            .replaceParagraph("#__register_platform_views__#", registerPlatformViews)
    }
}