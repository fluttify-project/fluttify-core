package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_ref

import me.yohom.fluttify.extensions.getResource

//Integer jsonableResult = null;
//if (result != null) {
//    jsonableResult = result.hashCode();
//    getHEAP().put(returnRefId, result);
//}
private val tmpl by lazy { getResource("/tmpl/java/result_ref.stmt.java.tmpl").readText() }

fun ResultRefTmpl(): String {
    return tmpl
}