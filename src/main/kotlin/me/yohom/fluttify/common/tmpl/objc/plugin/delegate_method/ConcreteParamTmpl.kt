package me.yohom.fluttify.common.tmpl.objc.plugin.delegate_method

import me.yohom.fluttify.common.model.Method

//[channel invokeMethod:@"#__callback_method__#" arguments:@{#__args__#}];
internal class ConcreteParamTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/concrete_param.stmt.m.tmpl").readText()

    fun objcConcreteParam(): String {
        return tmpl
            .replace(
                "#__callback_method__#",
                "Callback_${method.name}:${method.formalParams.joinToString(":") { it.variable.typeName }}"
            )
            .replace("#__args__#", method.formalParams.joinToString { it.variable.name })
    }
}