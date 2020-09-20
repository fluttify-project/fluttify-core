package me.yohom.fluttify.tmpl.objc.common.callback.callback_method.view_callback_method

import me.yohom.fluttify.extensions.deprotocol
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.isMultiPointer
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_ctype.CallbackArgValueTypeTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_enum.CallbackArgEnumTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_ref.CallbackArgRefTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_struct.CallbackArgStructTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_invoke.callback_return.CallbackReturnTmpl
import me.yohom.fluttify.tmpl.objc.common.callback.common.callback_invoke.callback_void.CallbackVoidTmpl

//- (#__return_type__#)#__method_name__##__formal_params__#
//{
//  FlutterMethodChannel *channel = [FlutterMethodChannel
//        methodChannelWithName:#__method_channel__#
//              binaryMessenger:[_registrar messenger]
//                        codec:[FlutterStandardMethodCodec codecWithReaderWriter:[[FluttifyReaderWriter alloc] init]]];
//  // print log
//  if (enableLog) {
//    NSLog(@"#__log__#");
//  }
//
//  // convert to jsonable arg
//  #__local_args__#
//
//  #__callback__#
//}
private val tmpl by lazy { getResource("/tmpl/objc/callback_method.stmt.m.tmpl").readText() }

/**
 * View类型的回调方法, 需要给回调Method Channel加上viewId
 */
fun ViewCallbackMethodTmpl(method: Method): String {
    val returnType = method.returnType
    val methodName = method.name
    val log = method.nameWithClass()
    val methodChannel = "[NSString stringWithFormat:@\"${method.className.deprotocol()}::Callback@%@\", @(_view.hash)]"
    val formalParams =
        " ${method.formalParams.joinToString(" ") { "${it.named}: (${it.variable.objcType()})${it.variable.name}" }}"
    val localArgs = if (method.formalParams.none { it.variable.trueType.isMultiPointer() }) {
        method
            .formalParams
            .map { it.variable }
            .joinToString("\n") {
                when {
                    // !顺序很重要
                    it.isEnum() -> CallbackArgEnumTmpl(it)
                    it.isValueType() or it.isAliasType() -> CallbackArgValueTypeTmpl(it)
                    it.isStruct() -> CallbackArgStructTmpl(it)
                    else -> CallbackArgRefTmpl(it)
                }
            }
    } else {
        ""
    }
    val callback = if (method.returnType == "void") {
        CallbackVoidTmpl(method)
    } else {
        CallbackReturnTmpl(method)
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