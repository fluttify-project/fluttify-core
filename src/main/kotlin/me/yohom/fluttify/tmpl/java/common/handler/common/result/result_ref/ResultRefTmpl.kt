package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_ref

//val returnRefId = result.hashCode()
//HEAP[returnRefId] = result
//
//methodResult.success(returnRefId)
internal class ResultRefTmpl {

    private val tmpl = this::class.java.getResource("/tmpl/java/result_ref.stmt.java.tmpl").readText()

    fun kotlinRefResult(): String {
        return tmpl
    }

}