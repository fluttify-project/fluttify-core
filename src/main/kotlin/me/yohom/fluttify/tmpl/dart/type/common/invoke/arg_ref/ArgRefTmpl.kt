package me.yohom.fluttify.tmpl.dart.type.common.invoke.arg_ref

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//#__arg_name__# is Ref ? (${it.name} as Ref)?.refId : #__arg_name__#
private val tmpl by lazy { getResource("/tmpl/dart/arg_ref.stmt.dart.tmpl").readText() }

fun ArgRefTmpl(variable: Variable): String {
    return tmpl.replace("#__arg_name__#", variable.name)
}