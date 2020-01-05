package me.yohom.fluttify.tmpl.objc.common.handler.common.result

import me.yohom.fluttify.extensions.getResource

//methodResult(result);
private val tmpl = getResource("/tmpl/objc/result_jsonable.stmt.m.tmpl").readText()
fun ResultJsonableTmpl(): String {
    return tmpl
}