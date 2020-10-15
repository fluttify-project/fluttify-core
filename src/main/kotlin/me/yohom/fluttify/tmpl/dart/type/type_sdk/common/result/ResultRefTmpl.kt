package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.extensions.*

//__result__
private val tmpl by lazy { getResource("/tmpl/dart/result_ref.stmt.dart.tmpl").readText() }

fun ResultRefTmpl(): String {
    return tmpl
}