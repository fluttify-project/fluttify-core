package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_enum

import me.yohom.fluttify.extensions.*

//Integer jsonableResult = null;
//if (__result__ != null) {
//    jsonableResult = __result__.ordinal();
//}
private val tmpl by lazy { getResource("/tmpl/java/result_enum.stmt.java.tmpl").readText() }

fun ResultEnumTmpl(): String {
    return tmpl
}