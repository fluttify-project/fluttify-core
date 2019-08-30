package me.yohom.fluttify.common.tmpl.kotlin.plugin

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.*
import me.yohom.fluttify.common.model.Lib
import me.yohom.fluttify.common.tmpl.kotlin.plugin.handler.GetterHandlerTmpl
import me.yohom.fluttify.common.tmpl.kotlin.plugin.handler.HandleMethodTmpl
import me.yohom.fluttify.common.tmpl.kotlin.plugin.handler.ObjectFactoryTmpl
import me.yohom.fluttify.common.tmpl.kotlin.plugin.handler.SetterHandlerTmpl

//package #__package_name__#
//
//import android.os.Bundle
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
//                    // 获取Application对象
//                    "SystemRef::getandroid_app_Application" -> {
//                        methodResult.success(registrar.activity().application.apply { REF_MAP[hashCode()] = this }.hashCode())
//                    }
//                    // 获取FlutterActivity对象
//                    "SystemRef::getandroid_app_Activity" -> {
//                        methodResult.success(registrar.activity().apply { REF_MAP[hashCode()] = this }.hashCode())
//                    }
//                    // 创建android.os.Bundle对象
//                    "SystemRef::createandroid_os_Bundle" -> {
//                        methodResult.success(Bundle().apply { REF_MAP[hashCode()] = this }.hashCode())
//                    }
//                    // 释放一个对象
//                    "SystemRef::release" -> {
//                        REF_MAP.remove(args["refId"] as Int)
//                        methodResult.success("success")
//                    }
//                    // 清空REF_MAP中所有对象
//                    "SystemRef::clearRefMap" -> {
//                        REF_MAP.clear()
//                        methodResult.success("success")
//                    }
//                    else -> {
//                        handlerMap[methodCall.method]?.invoke(registrar, args, methodResult) ?: methodResult.notImplemented()
//                    }
//                }
//            }
//
//            // 注册View
//            #__register_platform_views__#
//		}
//
//        private val handlerMap = mapOf<String, (Registrar, Map<String, Any>, MethodChannel.Result) -> Unit>>(
//                #__handlers__#
//        )
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

        // 注册PlatformView
        val registerPlatformViews = lib.types
            .filter { it.isView() }
            .joinToString("\n") { RegisterPlatformViewTmpl(it, ext).kotlinRegisterPlatformView() }

        // 处理方法们 分三种
        // 1. getter handler
        // 2. setter handler
        // 3. 普通方法 handler
        val getterHandlers = lib.types
            .filterType()
            .flatMap { it.fields }
            .filterGetters()
            .map { GetterHandlerTmpl(it).kotlinGetter() }

        val setterHandlers = lib.types
            .filterType()
            .flatMap { it.fields }
            .filterSetters()
            .map { SetterHandlerTmpl(it).kotlinSetter() }

        val methodHandlers = lib.types
            .filterType()
            .flatMap { it.methods }
            .filterMethod()
            .map { HandleMethodTmpl(it).kotlinHandlerMethod() }

        val objectFactoryHandlers = lib.types
            .filterConstructable()
            .flatMap { ObjectFactoryTmpl(it).kotlinObjectFactory() }

        return tmpl
            .replace("#__package_name__#", packageName)
            .replace("#__plugin_name__#", pluginClassName)
            .replace("#__method_channel__#", methodChannel)
            .replaceParagraph("#__getter_branches__#", "")
            .replaceParagraph("#__setter_branches__#", "")
            .replaceParagraph("#__register_platform_views__#", registerPlatformViews)
            .replaceParagraph(
                "#__handlers__#",
                getterHandlers.union(setterHandlers).union(methodHandlers).union(objectFactoryHandlers).joinToString(",\n")
            )
    }
}