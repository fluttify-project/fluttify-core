package me.yohom.fluttify.tmpl.dart.type.common.invoke.arg_jsonable

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//#__arg_name__#
private val tmpl by lazy { getResource("/tmpl/dart/arg_jsonable.stmt.dart.tmpl").readText() }

fun ArgJsonableTmpl(variable: Variable): String {
    return tmpl.replace("#__arg_name__#", variable.name)
}