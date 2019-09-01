package me.yohom.fluttify.common.tmpl.objc.plugin.delegate_method

import me.yohom.fluttify.common.extensions.findType
import me.yohom.fluttify.common.model.Method

//- (#__return_type__#)#__method_name__##__formal_params__#
//{
//  FlutterMethodChannel *channel = [FlutterMethodChannel
//      methodChannelWithName:@"#__method_channel__#"
//            binaryMessenger:[_registrar messenger]];
//
//  #__delegate__#
//}
internal class DelegateMethodTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/delegate_method.stmt.m.tmpl").readText()

    fun objcDelegateMethod(): String {
        return tmpl
            .replace("#__return_type__#", method.returnType)
            .replace(
                "#__method_name__#",
                "${method.name} ${if (method.formalParams.isEmpty()) "" else ":"}"
            )
            .replace(
                "#__formal_params__#",
                " ${method.formalParams.joinToString(" ") { "${it.named}: (${it.variable.typeName})${it.variable.name}" }}"
            )
            .replace(
                "#__delegate__#",
                if (method.formalParams.all { !it.variable.typeName.findType().isAbstract })
                    ConcreteParamTmpl(method).objcConcreteParam()
                else
                    AbstractParamTmpl(method).objcAbstractParam()
            )
    }
}