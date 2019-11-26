package me.yohom.fluttify.tmpl.java.common.handler.handler_method

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgEnumTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgJsonableTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgListTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgRefTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.invoke_return.InvokeReturnTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.invoke_void.InvokeVoidTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.log.LogInstanceTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.log.LogStaticTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.ref.RefTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_jsonable.ResultJsonableTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_list.ResultListTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_ref.ResultRefTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_void.ResultVoidTmpl

//"#__method_name__#" to { registrar, args, methodResult ->
//    // args
//    #__args__#
//
//    // ref
//    #__ref__#
//
//    // print log
//    if (getEnableLog()) {
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
    private val tmpl = this::class.java.getResource("/tmpl/java/handler_method.stmt.java.tmpl").readText()

    fun javaHandlerMethod(): String {
        val methodName = method.nameWithClass()
        val args = method.formalParams
            .filter { !it.variable.typeName.findType().isCallback() }
            .joinToString("\n") {
                when {
                    it.variable.jsonable() -> ArgJsonableTmpl(it.variable).javaArgJsonable()
                    it.variable.isEnum() -> ArgEnumTmpl(it.variable).javaArgEnum()
                    it.variable.isList -> ArgListTmpl(it.variable).javaArgList()
                    else -> ArgRefTmpl(it.variable).javaArgRef()
                }
            }
        val log = if (method.isStatic) {
            LogStaticTmpl(method).javaLogStatic()
        } else {
            LogInstanceTmpl(method).javaLogInstance()
        }

        // 获取当前调用方法的对象引用
        val ref = RefTmpl(method).javaRef()

        // 调用java端对应的方法
        val invoke = if (method.returnType.isVoid())
            InvokeVoidTmpl(method).javaInvokeVoid()
        else
            InvokeReturnTmpl(method).javaInvokeReturn()

        // 调用结果 分为void, (jsonable, ref)两种情况 void时返回"success", jsonable返回本身, ref返回refId
        val result = when {
            method.returnType.jsonable() -> ResultJsonableTmpl(method.returnType).javaJsonableResult()
            method.returnType.isList() -> {
                // 多维列表不处理
                if (method.returnType.genericLevel() > 1) {
                    "methodResult.success(new ArrayList());"
                } else {
                    ResultListTmpl(method.returnType).javaListResult()
                }
            }
            method.returnType == "void" -> ResultVoidTmpl().javaVoidResult()
            else -> ResultRefTmpl().javaRefResult()
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