package me.yohom.fluttify.tmpl.objc.common.handler.common.result

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.underscore2Camel

//HEAP[@(result.hash)] = result;
//methodResult(@(result.hash));
internal class ResultRefTmpl {
    private val tmpl = this::class.java.getResource("/tmpl/objc/result_ref.stmt.m.tmpl").readText()

    fun objcResultRef() = tmpl
}