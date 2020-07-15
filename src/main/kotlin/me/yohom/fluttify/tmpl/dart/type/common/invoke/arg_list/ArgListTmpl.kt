package me.yohom.fluttify.tmpl.dart.type.common.invoke.arg_list

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.removeObjcSpecifier
import me.yohom.fluttify.model.Variable

//#__arg_name__#.map((__it__) => __it__?.refId).toList()
private val tmpl by lazy { getResource("/tmpl/dart/arg_list.stmt.dart.tmpl").readText() }

fun ArgListTmpl(variable: Variable): String {
    return tmpl.replace("#__arg_name__#", variable.name.removeObjcSpecifier())
}