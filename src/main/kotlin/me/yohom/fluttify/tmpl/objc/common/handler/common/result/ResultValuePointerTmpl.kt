package me.yohom.fluttify.tmpl.objc.common.handler.common.result

import me.yohom.fluttify.extensions.getResource

//// return a (value)*
//NSValue* __result__ = [NSValue valueWithPointer:result];
private val tmpl by lazy { getResource("/tmpl/objc/result_value_pointer.stmt.m.tmpl").readText() }

fun ResultValuePointerTmpl(): String {
    return tmpl
}