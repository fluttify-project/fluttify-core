package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_arg.callback_arg_jsonable

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Parameter

//#__type_name__# arg#__arg_name__# = #__arg_name__#;
private val tmpl = getResource("/tmpl/java/callback_arg_jsonable.stmt.java.tmpl").readText()

fun CallbackArgJsonableTmpl(param: Parameter): String {
    return tmpl
        .replace("#__type_name__#", param.variable.trueType.replace("$", "."))
        .replace("#__arg_name__#", param.variable.name)
}