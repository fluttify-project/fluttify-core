package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_void

import me.yohom.fluttify.extensions.getResource

//String jsonableResult = "success";
private val tmpl = getResource("/tmpl/java/result_void.stmt.java.tmpl").readText()

fun ResultVoidTmpl(): String {
    return tmpl
}