package me.yohom.fluttify.tmpl.java.common.handler.handler_method_batch

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgEnumTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgJsonableTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgListTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgRefTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.invoke_return.InvokeReturnTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.invoke_void.InvokeVoidTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.ref.RefTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_jsonable.ResultJsonableTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_list.ResultListTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_ref.ResultRefTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.result.result_void.ResultVoidTmpl

//// method
//put("#__method_name__#_batch", (argsBatch, methodResult) -> {
//    List<#__result_type__#> resultList = new ArrayList<>();
//
//    for (int i = 0; i < (List<(Map<String, Object>>) argsBatch.size(); i++) {
//        Map<String, Object> args = ((List<Map<String, Object>>) argsBatch).get(i);
//
//        // args
//        #__args__#
//
//        // ref
//        #__ref__#
//
//        // invoke native method
//        #__invoke__#
//
//        // convert result to jsonable result
//        #__result__#
//
//        resultList.add(jsonableResult);
//    }
//
//    methodResult.success(resultList);
//});
private val tmpl by lazy { getResource("/tmpl/java/handler_method_batch.stmt.java.tmpl").readText() }

fun HandlerMethodBatchTmpl(method: Method): String {
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

    // 获取当前调用方法的对象引用
    val ref = RefTmpl(method)

    // 调用java端对应的方法
    val invoke = if (method.returnType.isVoid())
        InvokeVoidTmpl(method)
    else
        InvokeReturnTmpl(method)

    return tmpl
        .replace("#__method_name__#", methodName)
        .replace("#__result_type__#", resultType)
        .replaceParagraph("#__args__#", args)
        .replaceParagraph("#__ref__#", ref)
        .replaceParagraph("#__invoke__#", invoke)
}