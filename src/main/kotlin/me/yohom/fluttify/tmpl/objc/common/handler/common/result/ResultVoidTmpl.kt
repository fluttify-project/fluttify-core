package me.yohom.fluttify.tmpl.objc.common.handler.common.result

import me.yohom.fluttify.extensions.getResource

//methodResult(@"success");
private val tmpl = getResource("/tmpl/objc/result_void.stmt.m.tmpl").readText()

fun ResultVoidTmpl(): String {
    return tmpl
}