package me.yohom.fluttify.tmpl.java.common.handler.handler_method

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.*
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.invoke_return.InvokeReturnTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.invoke_void.InvokeVoidTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.log.LogInstanceTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.log.LogStaticTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.ref.RefTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_enum.ResultEnumTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_jsonable.ResultJsonableTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_list.ResultListTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_ref.ResultRefTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_void.ResultVoidTmpl

//// method
//put("#__method_name__#", (__args__, __methodResult__) -> {
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
//    #__result_type__# __result__ = null;
//    #__invoke__#
//
//    __methodResult__.success(__result__);
//});
private val tmpl by lazy { getResource("/tmpl/java/handler_method.stmt.java.tmpl").readText() }

fun HandlerMethodTmpl(method: Method): String {
    val methodName = method.nameWithClass()
    val resultType = method.returnType.replace("$", ".").boxedType()
    val args = method.formalParams
        .filter { !it.variable.trueType.findType().isCallback }
        .joinToString("\n") {
            when {
                it.variable.isEnum() -> ArgEnumTmpl(it.variable)
                else -> ArgRefTmpl(it.variable)
            }
        }
    val log = if (method.isStatic) {
        LogStaticTmpl(method)
    } else {
        LogInstanceTmpl(method)
    }

    // 获取当前调用方法的对象引用
    val ref = RefTmpl(method)

    // 调用java端对应的方法
    val invoke = if (method.returnType.isVoid())
        InvokeVoidTmpl(method)
    else
        InvokeReturnTmpl(method)

    return tmpl
        .replace("#__method_name__#", methodName)
        .replaceParagraph("#__args__#", args)
        .replace("#__result_type__#", resultType)
        .replaceParagraph("#__ref__#", ref)
        .replaceParagraph("#__log__#", log)
        .replaceParagraph("#__invoke__#", invoke)
}