package me.yohom.fluttify.common.tmpl.kotlin.plugin.handlermethod

import me.yohom.fluttify.common.extensions.findType
import me.yohom.fluttify.common.extensions.jsonable
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.extensions.toDartType
import me.yohom.fluttify.common.model.Method
import me.yohom.fluttify.common.tmpl.kotlin.plugin.handlermethod.invoke.InvokeTmpl

//private fun #__method_name__#(registrar: Registrar, args: Map<String, Any>, methodResult: MethodChannel.Result) {
//    #__args__#
//
//    #__log__#
//
//    #__ref__#
//
//    #__invoke__#
//
//    #__result__#
//}
class HandlerMethodTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/handler_method.mtd.kt.tmpl").readText()

    fun kotlinHandlerMethod(): String {
        val methodName = "handle${method.className.toDartType()}_${method.name}"
        // 参数分为三种, 分情况分别构造以下三种模板
        // 1. 枚举
        // 2. jsonable
        // 3. 引用
        val args = method.formalParams
            .filter { !it.typeName.findType().isCallback() }
            .joinToString("\n") {
                when {
                    it.typeName.jsonable() -> ArgJsonableTmpl(it).kotlinArgJsonable()
                    it.typeName.findType().isEnum() -> ArgEnumTmpl(it).kotlinArgEnum()
                    else -> ArgRefTmpl(it).kotlinArgRef()
                }
            }
        // 获取当前调用方法的对象引用
        val ref = RefTmpl(method).kotlinRef()

        // 调用kotlin端对应的方法
        val invoke = InvokeTmpl(method).kotlinInvoke()

        // 调用结果 分为void, (jsonable, ref)两种情况 void时返回"success", jsonable返回本身, ref返回refId
        val result = RefResultTmpl(method.returnType).kotlinRefResult()
        return tmpl
            .replace("#__method_name__#", methodName)
            .replaceParagraph("#__args__#", args)
            .replaceParagraph("#__ref__#", ref)
            .replaceParagraph("#__log__#", "") // todo
            .replaceParagraph("#__invoke__#", invoke)
            .replaceParagraph("#__result__#", result)
    }
}