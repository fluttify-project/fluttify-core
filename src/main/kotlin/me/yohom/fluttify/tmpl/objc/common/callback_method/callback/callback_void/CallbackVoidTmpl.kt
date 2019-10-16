package me.yohom.fluttify.tmpl.objc.common.callback_method.callback.callback_void

import me.yohom.fluttify.model.Method

//[channel invokeMethod:@"#__callback_method__#" arguments:@{#__callback_args__#}];
internal class CallbackVoidTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/callback_void.stmt.m.tmpl").readText()

    fun objcCallbackVoid(): String {
        val callbackMethod =
            "Callback::${method.className}::${method.name}${method.formalParams.joinToString("") { it.named }.capitalize()}"
        val callbackArgs = method
            .formalParams
            .joinToString { "@\"${it.variable.name}\": arg${it.variable.name}" }

        return tmpl
            .replace("#__callback_method__#", callbackMethod)
            .replace("#__callback_args__#", callbackArgs)
    }
}