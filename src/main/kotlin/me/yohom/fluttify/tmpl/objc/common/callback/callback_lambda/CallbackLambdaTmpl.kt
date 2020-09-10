package me.yohom.fluttify.tmpl.objc.common.callback.callback_lambda

import me.yohom.fluttify.extensions.deprotocol
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_ctype.CallbackArgValueTypeTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_enum.CallbackArgEnumTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_jsonable.CallbackArgJsonableTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_list.CallbackArgListTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_ref.CallbackArgRefTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_struct.CallbackArgStructTmpl
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
    val callbackChannel = if(callerMethod.isStatic){
        "@\"${callbackType.name.deprotocol()}::Callback\""
    } else {
        "[NSString stringWithFormat:@\"${callbackType.name.deprotocol()}::Callback@%@\", @(ref.hash)]"
    }
    val formalParams = callbackType
        .formalParams
        .joinToString { "${it.variable.objcType()} ${it.variable.name}" }
    val localArgs = if (callbackType.returnType == "void") {
        // 只有没有返回值的方法需要设置, 因为目前有返回值的回调方法是不实现的, 不然的话会把不需要的对象放到HEAP中去, dart端又无法释放, 造成泄露
        callbackType
            .formalParams
            .map { it.variable }
            .joinToString("\n") {
                when {
                    // !顺序很重要
                    it.isEnum() -> CallbackArgEnumTmpl(it)
                    it.isValueType() or it.isAliasType() -> CallbackArgValueTypeTmpl(it)
                    it.jsonable() -> CallbackArgJsonableTmpl(it)
                    it.isIterable -> CallbackArgListTmpl(it)
                    it.isStruct() -> CallbackArgStructTmpl(it)
                    else -> CallbackArgRefTmpl(it)
                }
            }
    } else {
        ""
    }
    val callback = when {
        callbackType.returnType == "void" -> CallbackVoidTmpl(callbackType.asMethod())
        else -> CallbackReturnTmpl(callbackType.asMethod())
    }

    return tmpl
        .replace("#__log__#", "")
        .replace("#__method_channel__#", callbackChannel)
        .replace("#__formal_params__#", formalParams)
        .replaceParagraph("#__local_args__#", localArgs)
        .replaceParagraph("#__callback__#", callback)
}