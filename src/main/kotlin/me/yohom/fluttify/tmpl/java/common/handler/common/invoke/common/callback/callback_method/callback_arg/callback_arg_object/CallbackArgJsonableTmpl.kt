package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_arg.callback_arg_object

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Parameter

//// object arg
//java.lang.Object arg#__arg_name__# = null;
//if (#__arg_name__# instanceof Number || #__arg_name__# instanceof String) {
//    arg#__arg_name__# = #__arg_name__#;
//} else {
//    arg#__arg_name__# = #__arg_name__#.hashCode();
//}
private val tmpl by lazy { getResource("/tmpl/java/callback_arg_object.stmt.java.tmpl").readText() }

fun CallbackArgObjectTmpl(param: Parameter): String {
    return tmpl
        .replace("#__type_name__#", param.variable.trueType.replace("$", "."))
        .replace("#__arg_name__#", param.variable.name)
}