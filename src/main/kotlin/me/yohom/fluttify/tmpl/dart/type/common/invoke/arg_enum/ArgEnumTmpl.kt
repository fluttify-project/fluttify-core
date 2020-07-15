package me.yohom.fluttify.tmpl.dart.type.common.invoke.arg_enum

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.removeObjcSpecifier
import me.yohom.fluttify.model.Variable

//#__arg_name__#.toValue()
private val tmpl by lazy { getResource("/tmpl/dart/arg_enum.stmt.dart.tmpl").readText() }

fun ArgEnumTmpl(variable: Variable): String {
    return tmpl.replace("#__arg_name__#", variable.name.removeObjcSpecifier())
}