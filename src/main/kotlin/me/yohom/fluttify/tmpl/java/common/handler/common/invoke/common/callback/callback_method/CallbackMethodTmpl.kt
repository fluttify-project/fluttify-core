package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.ifIsGenericTypeConvertToObject
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_arg.callback_arg_enum.CallbackArgEnumTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_arg.callback_arg_jsonable.CallbackArgJsonableTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_arg.callback_arg_list.CallbackArgListTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_arg.callback_arg_object.CallbackArgObjectTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_arg.callback_arg_ref.CallbackArgRefTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_return.CallbackReturnTmpl

//@Override
//public #__return_type__# #__callback_method__#(#__formal_params__#) {
//    // print log
//    if (getEnableLog()) {
//        #__log__#
//    }
//
//    // convert to jsonable data
//    #__local_args__#
//
//    // call dart method
//    callbackChannel.invokeMethod(
//            "Callback::#__callback_method_name__#",
//            new HashMap<String, Object>() {{
//                #__callback_args__#
//            }}
//    );
//
//    // method result
//    #__return_stmt__#
//}
private val tmpl by lazy { getResource("/tmpl/java/callback_method.mtd.java.tmpl").readText() }

fun CallbackMethodTmpl(method: Method): String {
    val callbackMethod = method.name
    val callbackMethodName = method.nameWithClass()
    val methodChannel = "${method.className.replace("$", ".")}::Callback"
    val formalParams = method
        .formalParams
        .map { it.variable }
        .joinToString {
            "${it.trueType.replace("$", ".").ifIsGenericTypeConvertToObject()} ${it.name}"
        }
    val returnType = method.returnType.replace("$", ".")
    val localArgs = method
        .formalParams
        .joinToString("\n") {
            when {
                it.variable.trueType.ifIsGenericTypeConvertToObject() == "java.lang.Object" -> CallbackArgObjectTmpl(it)
                it.variable.jsonable() -> CallbackArgJsonableTmpl(it)
                it.variable.isEnum() -> CallbackArgEnumTmpl(it)
                it.variable.isIterable -> CallbackArgListTmpl(it)
                else -> CallbackArgRefTmpl(it)
            }
        }
    val callbackArgs = method
        .formalParams
        .joinToString("\n") {
            "put(\"${it.variable.name}\", arg${it.variable.name});"
        }
    // 打印日志
    val logArgs = method
        .formalParams
        .filterNot { it.variable.isCallback() }
        .filterNot { it.variable.isLambda() }
        .joinToString(" + ") { it.variable.name }
    val log =
        """Log.d("java-callback", "fluttify-java-callback: ${method.name}(" + ${if (logArgs.isEmpty()) "\"\"" else logArgs} + ")");"""
    // 返回语句
    val returnStmt = CallbackReturnTmpl(method)

    return tmpl
        .replace("#__callback_method__#", callbackMethod)
        .replace("#__callback_method_name__#", callbackMethodName)
        .replace("#__method_channel__#", methodChannel)
        .replace("#__formal_params__#", formalParams)
        .replace("#__return_type__#", returnType)
        .replaceParagraph("#__local_args__#", localArgs)
        .replaceParagraph("#__callback_args__#", callbackArgs)
        .replaceParagraph("#__log__#", log)
        .replaceParagraph("#__return_stmt__#", returnStmt)
}