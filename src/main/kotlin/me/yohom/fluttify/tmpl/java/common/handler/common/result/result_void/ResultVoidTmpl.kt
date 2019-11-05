package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_void

//methodResult.success("success")
internal class ResultVoidTmpl {

    private val tmpl = this::class.java.getResource("/tmpl/java/result_void.stmt.java.tmpl").readText()

    fun javaVoidResult(): String {
        return tmpl
    }

}