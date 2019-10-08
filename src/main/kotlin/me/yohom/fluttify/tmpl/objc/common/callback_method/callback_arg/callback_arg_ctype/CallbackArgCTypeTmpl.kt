package me.yohom.fluttify.tmpl.objc.common.callback_method.callback_arg.callback_arg_ctype

import me.yohom.fluttify.model.Parameter

//// primitive回调参数
//NSNumber* arg#__arg_name__# = @(#__arg_name__#);
internal class CallbackArgCTypeTmpl(private val param: Parameter) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/callback_arg_ctype.stmt.m.tmpl").readText()

    fun objcCallbackArgCType(): String {
        return tmpl
            .replace("#__arg_name__#", param.variable.name)
    }
}