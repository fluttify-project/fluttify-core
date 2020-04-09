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

//// method
//put("#__method_name__#", (args, methodResult) -> {
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
//    // convert result to jsonable result
//    #__result__#
//
//    methodResult.success(jsonableResult);
//});
private val tmpl = getResource("/tmpl/java/handler_method.stmt.java.tmpl").readText()

fun HandlerMethodTmpl(method: Method): String {
    val methodName = method.nameWithClass()
    val args = method.formalParams
        .filter { !it.variable.typeName.findType().isCallback() }
        .joinToString("\n") {
            when {
                it.variable.jsonable() -> ArgJsonableTmpl(it.variable)
                it.variable.isEnum() -> ArgEnumTmpl(it.variable)
                it.variable.isIterable -> ArgListTmpl(it.variable)
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

    // 把方法调用返回的对象result转化成可以在channel中传输的对象
    // 调用结果 分为void, (jsonable, ref)两种情况 void时返回"success", jsonable返回本身, ref返回refId
    // 这里的语句会产生一个叫jsonableResult的对象, 这个对象是最终返回给dart的对象
    val result = when {
        method.returnType.jsonable() -> ResultJsonableTmpl(method.returnType)
        // jsonable已经把List<String>类似的类型挡掉了, 所以到这里的肯定是List<? extends Object>类型
        method.returnType.isIterable() -> ResultListTmpl(method)
        method.returnType.isVoid() -> ResultVoidTmpl()
        else -> ResultRefTmpl()
    }
    return tmpl
        .replace("#__method_name__#", methodName)
        .replaceParagraph("#__args__#", args)
        .replaceParagraph("#__ref__#", ref)
        .replaceParagraph("#__log__#", log)
        .replaceParagraph("#__invoke__#", invoke)
        .replaceParagraph("#__result__#", result)
}