package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method

import me.yohom.fluttify.extensions.enlist
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_arg.callback_arg_enum.CallbackArgEnumTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_arg.callback_arg_jsonable.CallbackArgJsonableTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_arg.callback_arg_list.CallbackArgListTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_arg.callback_arg_ref.CallbackArgRefTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_return.CallbackReturnTmpl

//@Override
//public #__return_type__# #__callback_method__#(#__formal_params__#) {
//    // print log
//    #__log__#
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
internal class CallbackMethodTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/java/callback_method.mtd.java.tmpl").readText()

    fun kotlinCallbackMethod(): String {
        val callbackMethod = method.name
        val callbackMethodName = method.nameWithClass()
        val methodChannel = "${method.className}::Callback"
        val formalParams = method
            .formalParams
            .joinToString { "${if (it.variable.isList) it.variable.typeName.enlist() else it.variable.typeName} ${it.variable.name}" }
        val returnType = method.returnType
        val localArgs = method
            .formalParams
            .joinToString("\n") {
                when {
                    it.variable.jsonable() -> CallbackArgJsonableTmpl(it).javaCallbackArgJsonable()
                    it.variable.isEnum() -> CallbackArgEnumTmpl(it).javaCallbackArgEnum()
                    it.variable.isList -> CallbackArgListTmpl(it).javaCallbackArgList()
                    else -> CallbackArgRefTmpl(it).javaCallbackArgRef()
                }
            }
        val callbackArgs = method
            .formalParams
            .joinToString("\n") {
                "put(\"${it.variable.name}\", arg${it.variable.name});"
            }
        val log =
            "Log.d(\"kotlin-callback\", \"fluttify-kotlin-callback: ${method.name}(${method.formalParams.map { "\\\"${it.variable.name}\\\":$${it.variable.name}" }})\");"
        val returnStmt = CallbackReturnTmpl(method).kotlinCallbackReturn()

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
}