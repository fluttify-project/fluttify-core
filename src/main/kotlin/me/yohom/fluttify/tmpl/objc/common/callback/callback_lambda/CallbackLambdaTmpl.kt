package me.yohom.fluttify.tmpl.objc.common.callback.callback_lambda

import me.yohom.fluttify.extensions.deprotocol
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_ctype.CallbackArgValueTypeTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_enum.CallbackArgEnumTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_ref.CallbackArgRefTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_struct.CallbackArgStructTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_value_pointer.CallbackArgValuePointerTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_invoke.callback_return.CallbackReturnTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_invoke.callback_void.CallbackVoidTmpl

//^(#__formal_params__#) {
//    FlutterMethodChannel *channel = [FlutterMethodChannel
//          methodChannelWithName:#__method_channel__#
//                binaryMessenger:[[weakSelf registrar] messenger]
//                          codec:[FlutterStandardMethodCodec codecWithReaderWriter:[[FluttifyReaderWriter alloc] init]]];
//
//    // print log
//    if (enableLog) {
//        NSLog(@"#__log__#");
//    }
//
//    // 构造可以直接传输的参数
//    #__local_args__#
//
//    #__callback__#
//}
private val tmpl by lazy { getResource("/tmpl/objc/lambda_callback.stmt.m.tmpl").readText() }

fun CallbackLambdaTmpl(callerMethod: Method, callbackType: Type): String {
    val callbackChannel = if (callerMethod.isStatic) {
        "@\"${callbackType.name.deprotocol()}::Callback\""
    } else {
        "[NSString stringWithFormat:@\"${callbackType.name.deprotocol()}::Callback@%@:%@\", NSStringFromClass([ref class]), @(ref.hash)]"
    }
    val formalParams = callbackType
        .formalParams
        .joinToString { "${it.variable.objcType()} ${it.variable.name}" }
    val localArgs = callbackType
        .formalParams
        .map { it.variable }
        .joinToString("\n") {
            when {
                // !顺序很重要
                it.isEnum() -> CallbackArgEnumTmpl(it)
                it.isValueType() or it.isAliasType() -> CallbackArgValueTypeTmpl(it)
                it.isValuePointerType() -> CallbackArgValuePointerTmpl(it)
                it.isStruct() -> CallbackArgStructTmpl(it)
                else -> CallbackArgRefTmpl(it)
            }
        }
    val callback = when (callbackType.returnType) {
        "void" -> CallbackVoidTmpl(callbackType.asMethod())
        else -> CallbackReturnTmpl(callbackType.asMethod())
    }

    return tmpl
        .replace("#__log__#", "")
        .replace("#__method_channel__#", callbackChannel)
        .replace("#__formal_params__#", formalParams)
        .replaceParagraph("#__local_args__#", localArgs)
        .replaceParagraph("#__callback__#", callback)
}