package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_jsonable

//methodResult.success(result)
internal class ResultJsonableTmpl() {

    private val tmpl = this::class.java.getResource("/tmpl/kotlin/result_jsonable.stmt.kt.tmpl").readText()

    fun kotlinJsonableResult(): String {
        return tmpl
    }

}