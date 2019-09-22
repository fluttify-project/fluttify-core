package me.yohom.fluttify.tmpl.objc.common.delegate_method

import me.yohom.fluttify.extensions.isList
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.objc.common.delegate_method.delegate.callback_return.CallbackReturnTmpl
import me.yohom.fluttify.tmpl.objc.common.delegate_method.delegate.callback_void.CallbackVoidTmpl

//- (#__return_type__#)#__method_name__##__formal_params__#
//{
//  FlutterMethodChannel *channel = [FlutterMethodChannel
//      methodChannelWithName:@"#__method_channel__#"
//            binaryMessenger:[_registrar messenger]];
//
//  NSLog(@"#__log__#");
//
//  #__delegate__#
//}
internal class DelegateMethodTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/delegate_method.stmt.m.tmpl").readText()

    fun objcDelegateMethod(): String {
        return tmpl
            .replace("#__return_type__#", method.returnType)
            .replace("#__method_name__#", method.name)
            .replace("#__log__#", method.nameWithClass())
            .replace("#__method_channel__#", "${method.className}::Callback")
            .replace(
                "#__formal_params__#",
                " ${method.formalParams.joinToString(" ") { "${it.named}: (${it.variable.typeName})${it.variable.name}" }}"
            )
            .replaceParagraph(
                "#__delegate__#",
                when {
                    method.returnType != "void" -> "// 由于flutter无法同步调用method channel, 所以暂不支持有返回值的回调方法\n// 相关issue https://github.com/flutter/flutter/issues/28310\nNSLog(@\"暂不支持有返回值的回调方法\");\nreturn nil;"
                    method.formalParams.any { it.variable.typeName.isList() } -> "// 暂不支持含有数组的方法"
                    method.returnType == "void" -> CallbackVoidTmpl(method).objcCallbackVoid()
                    else -> CallbackReturnTmpl(method).objcCallbackReturn() // 因为上面两个分支已经覆盖了void和非void情况, 所以这里不会走到
                }
            )
    }
}