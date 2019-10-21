package me.yohom.fluttify.tmpl.objc.common.callback.callback_method

import me.yohom.fluttify.extensions.enprotocol
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Variable
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_ctype.CallbackArgCTypeTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_enum.CallbackArgEnumTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_jsonable.CallbackArgJsonableTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_list.CallbackArgListTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_ref.CallbackArgRefTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_struct.CallbackArgStructTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_invoke.callback_return.CallbackReturnTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_invoke.callback_void.CallbackVoidTmpl

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
        val localArgs = if (method.returnType == "void") {
            // 只有没有返回值的方法需要设置, 不然的话会把不需要的对象放到HEAP中去, dart端又无法释放, 造成泄露
            method
                .formalParams
                .map { it.variable }
                .joinToString("\n") {
                    when {
                        it.isCType() -> CallbackArgCTypeTmpl(it).objcCallbackArgCType()
                        it.jsonable() -> CallbackArgJsonableTmpl(it).objcCallbackArgJsonable()
                        it.isEnum() -> CallbackArgEnumTmpl(it).objcCallbackArgEnum()
                        it.isList -> CallbackArgListTmpl(it).objcCallbackArgList()
                        it.isStruct() -> CallbackArgStructTmpl(it).objcCallbackArgStruct()
                        else -> CallbackArgRefTmpl(it).objcCallbackArgRef()
                    }
                }
        } else {
            ""
        }
        val callback = when {
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