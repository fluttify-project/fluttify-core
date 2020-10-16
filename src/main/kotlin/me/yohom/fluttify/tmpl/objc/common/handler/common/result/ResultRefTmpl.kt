package me.yohom.fluttify.tmpl.objc.common.handler.common.result

import me.yohom.fluttify.extensions.getResource

//// return a ref
//NSObject* __result__ = result;
private val tmpl by lazy { getResource("/tmpl/objc/result_ref.stmt.m.tmpl").readText() }

fun ResultRefTmpl(): String {
    return tmpl
}