package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_jsonable

//methodResult.success(result)
internal class ResultJsonableTmpl() {

    private val tmpl = this::class.java.getResource("/tmpl/java/result_jsonable.stmt.java.tmpl").readText()

    fun kotlinJsonableResult(): String {
        return tmpl
    }

}