package me.yohom.fluttify.tmpl.objc.common.handler.common.result

//methodResult(@"success");
internal class ResultVoidTmpl {
    private val tmpl = this::class.java.getResource("/tmpl/objc/result_void.stmt.m.tmpl").readText()

    fun objcResultVoid() = tmpl

}