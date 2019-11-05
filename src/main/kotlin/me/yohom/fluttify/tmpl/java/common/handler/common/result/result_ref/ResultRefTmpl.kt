package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_ref

//if (result != null) {
//    int returnRefId = result.hashCode();
//    getHEAP().put(returnRefId, result);
//
//    methodResult.success(returnRefId);
//} else {
//    methodResult.success(null);
//}
internal class ResultRefTmpl {

    private val tmpl = this::class.java.getResource("/tmpl/java/result_ref.stmt.java.tmpl").readText()

    fun kotlinRefResult(): String {
        return tmpl
    }

}