package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_void

//methodResult.success("success")
internal class ResultVoidTmpl {

    private val tmpl = this::class.java.getResource("/tmpl/kotlin/result_void.stmt.kt.tmpl").readText()

    fun kotlinVoidResult(): String {
        return tmpl
    }

}