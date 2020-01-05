package me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_ctype

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//// primitive回调参数
//NSNumber* arg#__arg_name__# = @(#__arg_name__#);
private val tmpl = getResource("/tmpl/objc/callback_arg_value_type.stmt.m.tmpl").readText()

fun CallbackArgValueTypeTmpl(variable: Variable): String {
    return tmpl
        .replace("#__arg_name__#", variable.name.depointer())
}