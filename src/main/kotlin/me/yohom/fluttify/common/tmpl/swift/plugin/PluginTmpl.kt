package me.yohom.fluttify.common.tmpl.swift.plugin

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.*
import me.yohom.fluttify.common.model.Lib
import me.yohom.fluttify.common.tmpl.swift.plugin.handlemethod.GetterMethodTmpl
import me.yohom.fluttify.common.tmpl.swift.plugin.handlemethod.HandleMethodTmpl
import me.yohom.fluttify.common.tmpl.swift.plugin.handlemethod.SetterMethodTmpl

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
//        private val handlerMap = mapOf<String, Function3<Registrar, Map<String, Any>, MethodChannel.Result, Unit>>(
//                #__branches__#
//        )
//
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
//		// 与branch对应的方法们
//		#__handlers__#
//    }
//}
class PluginTmpl(
    private val lib: Lib,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/plugin.swift.tmpl").readText()

    fun kotlinPlugin(): String {
        // 包名
        val packageName = "${ext.outputOrg}.${ext.outputProjectName}"

        // 插件名称
        val pluginClassName = ext.outputProjectName.underscore2Camel(true)

        // method channel
        val methodChannel = "${ext.outputOrg}/${ext.outputProjectName}"

        // 分支们 分为三种
        // 1. 普通方法
        // 2. getter
        // 3. setter
        val gettersBranches = lib.types
            .filterType()
            .flatMap { it.fields }
            .filterGetters()
            .map { GetterBranchTmpl(it).kotlinGetterBranch() }

        val settersBranches = lib.types
            .filterType()
            .flatMap { it.fields }
            .filterSetters()
            .map { SetterBranchTmpl(it).kotlinSetterBranch() }

        val methodBranches = lib.types
            .filterType()
            .flatMap { it.methods }
            .filterMethod()
            .map { MethodBranchTmpl(it).kotlinMethodBranch() }

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
            .map { GetterMethodTmpl(it).kotlinGetter() }

        val setterHandlers = lib.types
            .filterType()
            .flatMap { it.fields }
            .filterSetters()
            .map { SetterMethodTmpl(it).kotlinSetter() }

        val methodHandlers = lib.types
            .filterType()
            .flatMap { it.methods }
            .filterMethod()
            .map { HandleMethodTmpl(it).kotlinHandlerMethod() }

        return tmpl
            .replace("#__package_name__#", packageName)
            .replace("#__plugin_name__#", pluginClassName)
            .replace("#__method_channel__#", methodChannel)
            .replaceParagraph("#__getter_branches__#", "")
            .replaceParagraph("#__setter_branches__#", "")
            .replaceParagraph(
                "#__branches__#",
                methodBranches.union(gettersBranches).union(settersBranches).joinToString(",\n")
            )
            .replaceParagraph("#__register_platform_views__#", registerPlatformViews)
            .replaceParagraph(
                "#__handlers__#",
                getterHandlers.union(setterHandlers).union(methodHandlers).joinToString("\n")
            )
    }
}