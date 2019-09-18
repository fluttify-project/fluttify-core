package me.yohom.fluttify.common.tmpl.objc.common.delegate_method

import me.yohom.fluttify.common.extensions.isList
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.model.Method
import me.yohom.fluttify.common.tmpl.objc.common.delegate_method.callback_return.CallbackReturnTmpl

//- (#__return_type__#)#__method_name__##__formal_params__#
//{
//  FlutterMethodChannel *channel = [FlutterMethodChannel
//      methodChannelWithName:@"#__method_channel__#"
//            binaryMessenger:[_registrar messenger]];
//
//  #__delegate__#
//}
internal class DelegateMethodTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/plugin/delegate_method/delegate_method.stmt.m.tmpl").readText()

    fun objcDelegateMethod(): String {
        return tmpl
            .replace("#__return_type__#", method.returnType)
            .replace("#__method_name__#", method.name)
            .replace("#__method_channel__#", "${method.className}::Callback")
            .replace(
                "#__formal_params__#",
                " ${method.formalParams.joinToString(" ") { "${it.named}: (${it.variable.typeName})${it.variable.name}" }}"
            )
            .replaceParagraph(
                "#__delegate__#",
                when {
                    method.formalParams.any { it.variable.typeName.isList() } -> "// 暂不支持含有数组的方法"
                    method.returnType == "void" -> CallbackVoidTmpl(method).objcCallbackVoid()
                    else -> CallbackReturnTmpl(method).objcCallbackReturn()
                }
            )
    }
}