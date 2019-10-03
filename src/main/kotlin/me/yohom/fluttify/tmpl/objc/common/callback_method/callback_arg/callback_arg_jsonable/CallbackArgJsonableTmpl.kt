package me.yohom.fluttify.tmpl.objc.common.callback_method.callback_arg.callback_arg_jsonable

import me.yohom.fluttify.model.Parameter

//NSNumber* arg#__arg_name__# = @(#__arg_name__#.hash);
internal class CallbackArgJsonableTmpl(private val param: Parameter) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/callback_arg_jsonable.stmt.m.tmpl").readText()

    fun kotlinCallbackArgJsonable(): String {
        return tmpl
            .replace("#__arg_name__#", param.variable.name)
    }
}