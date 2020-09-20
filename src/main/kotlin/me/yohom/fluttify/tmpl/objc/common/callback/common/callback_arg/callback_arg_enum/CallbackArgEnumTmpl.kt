package me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_enum

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//// enum callback arg
//NSNumber* arg#__arg_name__# = @((NSInteger) #__arg_name__#);
private val tmpl by lazy { getResource("/tmpl/objc/callback_arg_enum.stmt.m.tmpl").readText() }

fun CallbackArgEnumTmpl(variable: Variable): String {
    return tmpl
        .replace("#__arg_name__#", variable.name.depointer())
}