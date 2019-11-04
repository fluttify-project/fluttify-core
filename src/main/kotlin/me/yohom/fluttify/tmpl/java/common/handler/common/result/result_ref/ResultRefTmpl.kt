package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_ref

//val returnRefId = result.hashCode()
//HEAP[returnRefId] = result
//
//methodResult.success(returnRefId)
internal class ResultRefTmpl {

    private val tmpl = this::class.java.getResource("/tmpl/kotlin/result_ref.stmt.kt.tmpl").readText()

    fun kotlinRefResult(): String {
        return tmpl
    }

}