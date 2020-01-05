package me.yohom.fluttify.tmpl.objc.common.handler.common.result

import me.yohom.fluttify.extensions.getResource

//methodResult(@(result));
private val tmpl = getResource("/tmpl/objc/result_value.stmt.m.tmpl").readText()

fun ResultValueTmpl(): String {
    return tmpl
}