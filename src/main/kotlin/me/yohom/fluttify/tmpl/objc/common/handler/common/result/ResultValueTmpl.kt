package me.yohom.fluttify.tmpl.objc.common.handler.common.result

//methodResult(@(result));
internal class ResultValueTmpl {
    private val tmpl = this::class.java.getResource("/tmpl/objc/result_value.stmt.m.tmpl").readText()

    fun objcResultValue() = tmpl

}