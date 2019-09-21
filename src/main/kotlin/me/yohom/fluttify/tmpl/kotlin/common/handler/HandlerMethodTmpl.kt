package me.yohom.fluttify.tmpl.kotlin.common.handler

import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.jsonable
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.kotlin.common.handler.arg.ArgEnumTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.arg.ArgJsonableTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.arg.ArgRefTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.invoke.InvokeTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.ref.RefTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.result.ResultRefTmpl

//"#__method_name__#" to { registrar, args, methodResult ->
//    // 参数
//    #__args__#
//
//    // 调用对象引用
//    #__ref__#
//
//    // 日志打印
//    #__log__#
//
//    // 开始调用
//    #__invoke__#
//
//    // 调用结果
//    #__result__#
//}
internal class HandlerMethodTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/handler_method.stmt.kt.tmpl").readText()

    fun kotlinHandlerMethod(): String {
        val methodName = method.methodName()
        // 参数分为三种, 分情况分别构造以下三种模板
        // 1. 枚举
        // 2. jsonable
        // 3. 引用
        val args = method.formalParams
            .filter { !it.variable.typeName.findType().isCallback() }
            .joinToString("\n") {
                when {
                    it.variable.typeName.jsonable() -> ArgJsonableTmpl(
                        it.variable
                    ).kotlinArgJsonable()
                    it.variable.typeName.findType().isEnum() -> ArgEnumTmpl(
                        it.variable
                    ).kotlinArgEnum()
                    else -> ArgRefTmpl(it.variable).kotlinArgRef()
                }
            }
        val log = if (method.isStatic) {
            "println(\"fluttify-kotlin: ${method.className}::${method.name}(${method.formalParams.filter { it.variable.typeName.jsonable() }.map { "\\\"${it.variable.name}\\\":$${it.variable.name}" }})\")"
        } else {
            "println(\"fluttify-kotlin: ${method.className}@\$refId::${method.name}(${method.formalParams.filter { it.variable.typeName.jsonable() }.map { "\\\"${it.variable.name}\\\":$${it.variable.name}" }})\")"
        }

        // 获取当前调用方法的对象引用
        val ref = RefTmpl(method).kotlinRef()

        // 调用kotlin端对应的方法
        val invoke = InvokeTmpl(method).kotlinInvoke()

        // 调用结果 分为void, (jsonable, ref)两种情况 void时返回"success", jsonable返回本身, ref返回refId
        val result = ResultRefTmpl(method.returnType).kotlinRefResult()
        return tmpl
            .replace("#__method_name__#", methodName)
            .replaceParagraph("#__args__#", args)
            .replaceParagraph("#__ref__#", ref)
            .replaceParagraph("#__log__#", log)
            .replaceParagraph("#__invoke__#", invoke)
            .replaceParagraph("#__result__#", result)
    }
}