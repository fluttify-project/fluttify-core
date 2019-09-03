package me.yohom.fluttify.common.tmpl.objc.plugin.delegate_method

import me.yohom.fluttify.common.model.Method

//[channel invokeMethod:@"#__callback_method__#" arguments:#__callback_args__#];
internal class CallbackVoidTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/plugin/delegate_method/callback_void.stmt.m.tmpl").readText()

    fun objcCallbackVoid(): String {
        return tmpl
            .replace(
                "#__callback_method__#",
                "${method.name}:${method.formalParams.joinToString(":") { it.variable.typeName }}"
            )
            .replace(
                "#__callback_args__#",
                method.formalParams.joinToString { "@\"${it.variable.name}\": @(${it.variable.name}.hash)" }
            )
    }
}