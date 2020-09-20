package me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_list

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.enpointer
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//// list callback arg
//NSArray<NSObject*>* arg#__arg_name__# = #__arg_name__#;
private val tmpl by lazy { getResource("/tmpl/objc/callback_arg_list.stmt.m.tmpl").readText() }

fun CallbackArgListTmpl(variable: Variable): String {
    return tmpl
        .replace("#__type_name__#", variable.trueType.enpointer())
        .replace("#__arg_name__#", variable.name.depointer())
}