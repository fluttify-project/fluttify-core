package me.yohom.fluttify.tmpl.kotlin.common.handler.common.invoke.common.callback.callback_method.callback_arg.callback_arg_jsonable

import me.yohom.fluttify.model.Parameter

//val arg#__arg_name__# = #__arg_name__#
internal class CallbackArgJsonableTmpl(private val param: Parameter) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/callback_arg_jsonable.stmt.kt.tmpl").readText()

    fun kotlinCallbackArgJsonable(): String {
        return tmpl
            .replace("#__arg_name__#", param.variable.name)
    }
}