package me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_struct

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//// struct callback arg
//NSValue* arg#__arg_name__# = [NSValue value:&#__arg_name__# withObjCType:@encode(#__type_name__#)];
private val tmpl by lazy { getResource("/tmpl/objc/callback_arg_struct.stmt.m.tmpl").readText() }

fun CallbackArgStructTmpl(variable: Variable): String {
    return tmpl
        .replace("#__arg_name__#", variable.name.depointer())
        .replace("#__type_name__#", variable.trueType)
}