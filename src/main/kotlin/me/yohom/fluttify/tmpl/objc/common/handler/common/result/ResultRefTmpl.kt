package me.yohom.fluttify.tmpl.objc.common.handler.common.result

//HEAP[@(result.hash)] = result;
//methodResult(@(result.hash));
internal class ResultRefTmpl {
    private val tmpl = this::class.java.getResource("/tmpl/objc/result_ref.stmt.m.tmpl").readText()

    fun objcResultRef() = tmpl
}