package me.yohom.fluttify.tmpl.objc.common.callback.common.callback_invoke.callback_void

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Method

//[channel invokeMethod:@"#__callback_method__#" arguments:@{#__callback_args__#}];
private val tmpl = getResource("/tmpl/objc/callback_void.stmt.m.tmpl").readText()

fun CallbackVoidTmpl(method: Method): String {
    val callbackMethod = "Callback::${method.nameWithClass()}"

    val callbackArgs = method
        .formalParams
        .joinToString { "@\"${it.variable.name.depointer()}\": arg${it.variable.name.depointer()}" }

    return tmpl
        .replace("#__callback_method__#", callbackMethod)
        .replace("#__callback_args__#", callbackArgs)
}