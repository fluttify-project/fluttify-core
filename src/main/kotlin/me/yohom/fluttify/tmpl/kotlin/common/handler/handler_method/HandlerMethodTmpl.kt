package me.yohom.fluttify.tmpl.kotlin.common.handler.handler_method

import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.isCollection
import me.yohom.fluttify.extensions.jsonable
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.kotlin.common.handler.common.arg.ArgEnumTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.common.arg.ArgJsonableTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.common.arg.ArgListTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.common.arg.ArgRefTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.common.invoke.invoke_return.InvokeReturnTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.common.invoke.invoke_void.InvokeVoidTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.common.log.LogInstanceTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.common.log.LogStaticTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.common.ref.RefTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.common.result.result_jsonable.ResultJsonableTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.common.result.result_list.ResultListTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.common.result.result_ref.ResultRefTmpl
import me.yohom.fluttify.tmpl.kotlin.common.handler.common.result.result_void.ResultVoidTmpl

//"#__method_name__#" to { registrar, args, methodResult ->
//    // args
//    #__args__#
//
//    // ref
//    #__ref__#
//
//    // print log
//    if (enableLog) {
//        #__log__#
//    }
//
//    // invoke native method
//    #__invoke__#
//
//    // result
//    #__result__#
//}
internal class HandlerMethodTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/handler_method.stmt.kt.tmpl").readText()

    fun kotlinHandlerMethod(): String {
        val methodName = method.nameWithClass()
        val args = method.formalParams
            .filter { !it.variable.typeName.findType().isCallback() }
            .joinToString("\n") {
                when {
                    it.variable.jsonable() -> ArgJsonableTmpl(it.variable).kotlinArgJsonable()
                    it.variable.isEnum() -> ArgEnumTmpl(it.variable).kotlinArgEnum()
                    it.variable.isList -> ArgListTmpl(it.variable).kotlinArgList()
                    else -> ArgRefTmpl(it.variable).kotlinArgRef()
                }
            }
        val log = if (method.isStatic) {
            LogStaticTmpl(method).kotlinLogStatic()
        } else {
            LogInstanceTmpl(method).kotlinLogInstance()
        }

        // 获取当前调用方法的对象引用
        val ref = RefTmpl(method).kotlinRef()

        // 调用kotlin端对应的方法
        val invoke = if (method.returnType == "void")
            InvokeVoidTmpl(method).kotlinInvokeVoid()
        else
            InvokeReturnTmpl(method).kotlinInvokeReturn()

        // 调用结果 分为void, (jsonable, ref)两种情况 void时返回"success", jsonable返回本身, ref返回refId
        val result = when {
            method.returnType.jsonable() -> ResultJsonableTmpl().kotlinJsonableResult()
            method.returnType.isCollection() -> ResultListTmpl().kotlinListResult()
            method.returnType == "void" -> ResultVoidTmpl().kotlinVoidResult()
            else -> ResultRefTmpl().kotlinRefResult()
        }
        return tmpl
            .replace("#__method_name__#", methodName)
            .replaceParagraph("#__args__#", args)
            .replaceParagraph("#__ref__#", ref)
            .replaceParagraph("#__log__#", log)
            .replaceParagraph("#__invoke__#", invoke)
            .replaceParagraph("#__result__#", result)
    }
}