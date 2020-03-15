package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.extensions.getResource

//result
private val tmpl = getResource("/tmpl/dart/result_void.stmt.dart.tmpl").readText()

fun ResultVoidTmpl(): String {
    return tmpl
}