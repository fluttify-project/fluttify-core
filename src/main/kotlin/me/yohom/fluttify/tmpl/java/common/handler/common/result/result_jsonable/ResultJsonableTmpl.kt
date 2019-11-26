package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_jsonable

import me.yohom.fluttify.extensions.dearray
import me.yohom.fluttify.extensions.isStringArray

//methodResult.success(#__result__#);
internal class ResultJsonableTmpl(val returnType: String) {
    private val tmpl = this::class.java.getResource("/tmpl/java/result_jsonable.stmt.java.tmpl").readText()

    fun javaJsonableResult(): String {
        val result = if (returnType.isStringArray())
            "new ArrayList<${returnType.dearray()}>(java.util.Arrays.asList(result))"
        else
            "result"
        return tmpl
            .replace("#__result__#", result)
    }
}