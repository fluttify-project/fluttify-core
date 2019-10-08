package me.yohom.fluttify.tmpl.objc.common.callback_method

import me.yohom.fluttify.extensions.enprotocol
import me.yohom.fluttify.extensions.isList
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Variable
import me.yohom.fluttify.tmpl.objc.common.callback_method.callback.callback_return.CallbackReturnTmpl
import me.yohom.fluttify.tmpl.objc.common.callback_method.callback.callback_void.CallbackVoidTmpl
import me.yohom.fluttify.tmpl.objc.common.callback_method.callback_arg.callback_arg_enum.CallbackArgEnumTmpl
import me.yohom.fluttify.tmpl.objc.common.callback_method.callback_arg.callback_arg_jsonable.CallbackArgJsonableTmpl
import me.yohom.fluttify.tmpl.objc.common.callback_method.callback_arg.callback_arg_list.CallbackArgListTmpl
import me.yohom.fluttify.tmpl.objc.common.callback_method.callback_arg.callback_arg_ref.CallbackArgRefTmpl
import me.yohom.fluttify.tmpl.objc.common.callback_method.callback_arg.callback_arg_struct.CallbackArgStructTmpl

//- (#__return_type__#)#__method_name__##__formal_params__#
//{
//  FlutterMethodChannel *channel = [FlutterMethodChannel
//      methodChannelWithName:@"#__method_channel__#"
//            binaryMessenger:[_registrar messenger]];
//
//  NSLog(@"#__log__#");
//
//  #__local_args__#
//
//  #__callback__#
//}
internal class CallbackMethodTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/callback_method.stmt.m.tmpl").readText()

    fun objcDelegateMethod(): String {
        val returnType = method.returnType
        val methodName = method.name
        val log = method.nameWithClass()
        val methodChannel = "${method.className}::Callback"
        val formalParams =
            " ${method.formalParams.joinToString(" ") { "${it.named}: (${it.variable.paramType()})${it.variable.name}" }}"
        val localArgs = method
            .formalParams
            .joinToString("\n") {
                when {
                    it.variable.jsonable() -> CallbackArgJsonableTmpl(it).objcCallbackArgJsonable()
                    it.variable.isEnum() -> CallbackArgEnumTmpl(it).objcCallbackArgEnum()
                    it.variable.isList -> CallbackArgListTmpl(it).objcCallbackArgList()
                    it.variable.isStruct() -> CallbackArgStructTmpl(it).objcCallbackArgStruct()
                    else -> CallbackArgRefTmpl(it).objcCallbackArgRef()
                }
            }
        val callback = when {
            method.formalParams.any { it.variable.typeName.isList() } -> "// 暂不支持含有数组的方法"
            method.returnType == "void" -> CallbackVoidTmpl(method).objcCallbackVoid()
            else -> CallbackReturnTmpl(method).objcCallbackReturn()
        }

        return tmpl
            .replace("#__return_type__#", returnType)
            .replace("#__method_name__#", methodName)
            .replace("#__log__#", log)
            .replace("#__method_channel__#", methodChannel)
            .replace("#__formal_params__#", formalParams)
            .replaceParagraph("#__local_args__#", localArgs)
            .replaceParagraph("#__callback__#", callback)
    }

    private fun Variable.paramType(): String {
        return when {
            isInterface() -> typeName.enprotocol()
            isList && genericLevel > 0 -> "NSArray<$typeName>*"
            else -> typeName
        }
    }
}