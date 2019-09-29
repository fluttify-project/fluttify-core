package me.yohom.fluttify.tmpl.objc.common.callback_method

import me.yohom.fluttify.extensions.isList
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.objc.common.callback_method.callback.callback_return.CallbackReturnTmpl
import me.yohom.fluttify.tmpl.objc.common.callback_method.callback.callback_void.CallbackVoidTmpl

//- (#__return_type__#)#__method_name__##__formal_params__#
//{
//  FlutterMethodChannel *channel = [FlutterMethodChannel
//      methodChannelWithName:@"#__method_channel__#"
//            binaryMessenger:[_registrar messenger]];
//
//  NSLog(@"#__log__#");
//
//  #__add_to_heap__#
//
//  #__delegate__#
//}
internal class CallbackMethodTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/delegate_method.stmt.m.tmpl").readText()

    fun objcDelegateMethod(): String {
        val returnType = method.returnType
        val methodName = method.name
        val log = method.nameWithClass()
        val methodChannel = "${method.className}::Callback"
        val formalParams =
            " ${method.formalParams.joinToString(" ") { "${it.named}: (${it.variable.typeName})${it.variable.name}" }}"
        val addToHeap = method.formalParams.filter { it.variable.isRefType() }.joinToString("\n") { "HEAP[@(${it.variable.name}.hash)] = ${it.variable.name};" }
        val delegate = when {
            method.returnType != "void" -> "// 由于flutter无法同步调用method channel, 所以暂不支持有返回值的回调方法\n// 相关issue https://github.com/flutter/flutter/issues/28310\nNSLog(@\"暂不支持有返回值的回调方法\");\nreturn nil;"
            method.formalParams.any { it.variable.typeName.isList() } -> "// 暂不支持含有数组的方法"
            method.returnType == "void" -> CallbackVoidTmpl(method).objcCallbackVoid()
            else -> CallbackReturnTmpl(method).objcCallbackReturn() // 因为上面两个分支已经覆盖了void和非void情况, 所以这里不会走到
        }

        return tmpl
            .replace("#__return_type__#", returnType)
            .replace("#__method_name__#", methodName)
            .replace("#__log__#", log)
            .replace("#__method_channel__#", methodChannel)
            .replace("#__formal_params__#", formalParams)
            .replaceParagraph("#__add_to_heap__#", addToHeap)
            .replaceParagraph("#__delegate__#", delegate)
    }
}