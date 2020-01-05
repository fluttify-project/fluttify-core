package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_ref

import me.yohom.fluttify.extensions.getResource

//if (result != null) {
//    int returnRefId = result.hashCode();
//    getHEAP().put(returnRefId, result);
//
//    methodResult.success(returnRefId);
//} else {
//    methodResult.success(null);
//}
private val tmpl = getResource("/tmpl/java/result_ref.stmt.java.tmpl").readText()

fun ResultRefTmpl(): String {
    return tmpl
}