package me.yohom.fluttify.tmpl.kotlin.plugin

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Lib
import me.yohom.fluttify.tmpl.kotlin.common.handler.handler_getter.HandlerGetterTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.handler_method.HandlerMethodTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.handler_object_factory.HandlerObjectFactoryTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.handler_setter.HandlerSetterTmpl
import me.yohom.fluttify.tmpl.kotlin.plugin.register_platform_view.RegisterPlatformViewTmpl

//package #__package_name__#
//
//import android.os.Bundle
//import android.util.Log
//import io.flutter.plugin.common.MethodCall
//import io.flutter.plugin.common.MethodChannel
//import io.flutter.plugin.common.PluginRegistry.Registrar
//import me.yohom.foundation_fluttify.HEAP
//
//@Suppress("FunctionName", "UsePropertyAccessSyntax", "RedundantUnitReturnType", "UNUSED_PARAMETER", "SpellCheckingInspection", "ConvertToStringTemplate", "DEPRECATION", "UNUSED_VARIABLE")
//class #__plugin_name__#Plugin(private val registrar: Registrar): MethodChannel.MethodCallHandler {
//
//    companion object {
//        @JvmStatic
//        fun registerWith(registrar: Registrar) {
//            val channel = MethodChannel(registrar.messenger(), "#__method_channel__#")
//            channel.setMethodCallHandler(#__plugin_name__#Plugin(registrar))
//
//            // register platform view
//            #__register_platform_views__#
//        }
//    }
//
//    private val handlerMap = mapOf<String, (Registrar, Map<String, Any>, MethodChannel.Result) -> Unit>(
//        #__handlers__#
//    )
//
//    override fun onMethodCall(methodCall: MethodCall, methodResult: MethodChannel.Result) {
//        val args = methodCall.arguments as? Map<String, Any> ?: mapOf()
//        handlerMap[methodCall.method]?.invoke(registrar, args, methodResult) ?: methodResult.notImplemented()
//    }
//}
class KotlinPluginTmpl(private val lib: Lib) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/plugin.kt.tmpl").readText()

    fun kotlinPlugin(): String {
        // 包名
        val packageName = "${ext.outputOrg}.${ext.outputProjectName}"

        // 插件名称
        val pluginClassName = ext.outputProjectName.underscore2Camel(true)

        // method channel
        val methodChannel = "${ext.outputOrg}/${ext.outputProjectName}"

        // 注册PlatformView
        val registerPlatformViews = lib
            .types
            .filter { it.isView() && !it.isObfuscated() }
            .joinToString("\n") { RegisterPlatformViewTmpl(it, ext).kotlinRegisterPlatformView() }

        val getterHandlers = lib.types
            .filterType()
            .flatMap { it.fields }
            .filterGetters()
            .map { HandlerGetterTmpl(it).kotlinGetter() }

        val setterHandlers = lib.types
            .filterType()
            .flatMap { it.fields }
            .filterSetters()
            .map { HandlerSetterTmpl(it).kotlinSetter() }

        val methodHandlers = lib.types
            .filterType()
            .flatMap { it.methods }
            .filterMethod()
            .map { HandlerMethodTmpl(it).kotlinHandlerMethod() }

        val objectFactoryHandlers = lib.types
            .filterConstructable()
            .flatMap { HandlerObjectFactoryTmpl(it).kotlinObjectFactory() }

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