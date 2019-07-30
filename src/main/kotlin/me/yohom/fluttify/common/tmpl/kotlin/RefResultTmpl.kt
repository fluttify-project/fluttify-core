package me.yohom.fluttify.common.tmpl.kotlin

import me.yohom.fluttify.common.TYPE_NAME

class RefResultTmpl(val returnType: TYPE_NAME) {

    private val tmpl = this::class.java.getResource("/tmpl/kotlin/ref_result.stmt.kt.tmpl").readText()

    fun kotlinRefResult(): String {
        return if (returnType == "void") "methodResult.success(\"success\")" else tmpl
    }

}