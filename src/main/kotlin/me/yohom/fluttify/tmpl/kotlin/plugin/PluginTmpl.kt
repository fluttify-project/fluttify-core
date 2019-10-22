package me.yohom.fluttify.tmpl.kotlin.plugin

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Lib
import me.yohom.fluttify.tmpl.kotlin.common.handler.handler_getter.HandlerGetterTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.handler_method.HandlerMethodTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.handler_object_factory.HandlerObjectFactoryTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.handler_setter.HandlerSetterTmpl
import me.yohom.fluttify.tmpl.kotlin.plugin.register_platform_view.RegisterPlatformViewTmpl

////////////////////////////////////////////////////////////
//// GENERATED BY FLUTTIFY. DO NOT EDIT IT.
////////////////////////////////////////////////////////////
//
//package #__package_name__#
//
//import android.os.Bundle
//import android.util.Log
//import io.flutter.plugin.common.MethodCall
//import io.flutter.plugin.common.MethodChannel
//import io.flutter.plugin.common.PluginRegistry.Registrar
//
//// Dart端一次方法调用所存在的栈, 只有当MethodChannel传递参数受限时, 再启用这个容器
//val STACK = mutableMapOf<String, Int>()
//// Dart端随机存取对象的容器
//val HEAP = mutableMapOf<Int, Any>()
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
//            // 注册View
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
//        when (methodCall.method) {
//            // 获取Application对象
//            "ObjectFactory::getandroid_app_Application" -> {
//                methodResult.success(registrar.activity().application.apply { HEAP[hashCode()] = this }.hashCode())
//            }
//            // 获取FlutterActivity对象
//            "ObjectFactory::getandroid_app_Activity" -> {
//                methodResult.success(registrar.activity().apply { HEAP[hashCode()] = this }.hashCode())
//            }
//            // 创建android.os.Bundle对象
//            "ObjectFactory::createandroid_os_Bundle" -> {
//                methodResult.success(Bundle().apply { HEAP[hashCode()] = this }.hashCode())
//            }
//            // 创建bitmap对象
//            "ObjectFactory::createandroid_graphics_Bitmap" -> {
//                val bitmapBytes = args["bitmapBytes"] as ByteArray
//                val bitmap = android.graphics.BitmapFactory.decodeByteArray(bitmapBytes, 0, bitmapBytes.size)
//
//                HEAP[bitmap.hashCode()] = bitmap
//
//                methodResult.success(bitmap.hashCode())
//            }
//            // 释放一个对象
//            "ObjectFactory::release" -> {
//                Log.d("ObjectFactory", "释放对象: ${HEAP[args["refId"] as Int]?.javaClass}@${args["refId"]}")
//
//                HEAP.remove(args["refId"] as Int)
//
//                methodResult.success("success")
//
//                // 打印当前HEAP
//                Log.d("ObjectFactory", "HEAP: $HEAP")
//            }
//            // 清空HEAP中所有对象
//            "ObjectFactory::clearHeap" -> {
//                Log.d("ObjectFactory", "清空堆")
//
//                HEAP.clear()
//                methodResult.success("success")
//
//                // 打印当前HEAP
//                Log.d("ObjectFactory", "HEAP: $HEAP")
//            }
//            // 压入栈
//            "ObjectFactory::pushStack" -> {
//                val name = args["name"] as String
//                val refId = args["refId"] as Int
//
//                Log.d("ObjectFactory", "压入对象: ${HEAP[refId]?.javaClass}@${refId}")
//
//                STACK[name] = refId
//
//                methodResult.success("success")
//
//                // 打印当前STACK
//                Log.d("ObjectFactory", "STACK: $STACK")
//            }
//            // 清空栈
//            "ObjectFactory::clearStack" -> {
//                STACK.clear()
//
//                methodResult.success("success")
//
//                // 打印当前STACK
//                Log.d("ObjectFactory", "STACK: $STACK")
//            }
//            else -> {
//                handlerMap[methodCall.method]?.invoke(registrar, args, methodResult) ?: methodResult.notImplemented()
//            }
//        }
//    }
//}
class PluginTmpl(private val lib: Lib) {
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