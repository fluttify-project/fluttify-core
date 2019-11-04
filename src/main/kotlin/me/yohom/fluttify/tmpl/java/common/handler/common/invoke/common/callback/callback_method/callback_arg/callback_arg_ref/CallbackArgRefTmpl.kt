package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_arg.callback_arg_ref

import me.yohom.fluttify.model.Parameter

//val arg#__arg_name__# = #__arg_name__#.apply { HEAP[hashCode()] = this }.hashCode()
internal class CallbackArgRefTmpl(private val param: Parameter) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/callback_arg_ref.stmt.kt.tmpl").readText()

    fun kotlinCallbackArgRef(): String {
        return tmpl
            .replace("#__arg_name__#", param.variable.name)

    }
}