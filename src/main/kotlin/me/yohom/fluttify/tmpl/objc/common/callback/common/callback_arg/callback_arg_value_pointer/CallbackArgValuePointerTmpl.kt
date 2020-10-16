package me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_value_pointer

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//// value pointer callback arg
//NSValue* arg#__arg_name__# = [NSValue valueWithPointer:#__arg_name__#];
private val tmpl by lazy { getResource("/tmpl/objc/callback_arg_value_pointer.stmt.m.tmpl").readText() }

fun CallbackArgValuePointerTmpl(variable: Variable): String {
    return tmpl
        .replace("#__arg_name__#", variable.name.depointer())
        .replace("#__type_name__#", variable.trueType)
}