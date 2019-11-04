package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_arg.callback_arg_enum

import me.yohom.fluttify.model.Parameter

//val arg#__arg_name__# = #__arg_name__#.ordinal
internal class CallbackArgEnumTmpl(private val param: Parameter) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/callback_arg_enum.stmt.kt.tmpl").readText()

    fun kotlinCallbackArgEnum(): String {
        return tmpl
            .replace("#__arg_name__#", param.variable.name)
    }
}