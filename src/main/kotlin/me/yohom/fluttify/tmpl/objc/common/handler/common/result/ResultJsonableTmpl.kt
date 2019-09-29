package me.yohom.fluttify.tmpl.objc.common.handler.common.result

//methodResult(result);
internal class ResultJsonableTmpl {
    private val tmpl = this::class.java.getResource("/tmpl/objc/result_jsonable.stmt.m.tmpl").readText()

    fun objcResultJsonable() = tmpl
}