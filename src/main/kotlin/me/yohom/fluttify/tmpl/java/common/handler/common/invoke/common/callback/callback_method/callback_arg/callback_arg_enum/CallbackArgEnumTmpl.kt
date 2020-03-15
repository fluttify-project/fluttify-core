package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_arg.callback_arg_enum

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Parameter

//int arg#__arg_name__# = #__arg_name__#.ordinal();
private val tmpl = getResource("/tmpl/java/callback_arg_enum.stmt.java.tmpl").readText()

fun CallbackArgEnumTmpl(param: Parameter): String {
    return tmpl
        .replace("#__arg_name__#", param.variable.name)
}