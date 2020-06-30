package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_jsonable

import me.yohom.fluttify.extensions.*

//#__type_name__# jsonableResult = #__result__#;
private val tmpl by lazy { getResource("/tmpl/java/result_jsonable.stmt.java.tmpl").readText() }

fun ResultJsonableTmpl(returnType: String): String {
    val typeName = when {
        returnType.isStringArray() -> "List<String>"
        else -> returnType
    }
    val result = if (returnType.isStringArray()) {
        "new ArrayList<${returnType.dearray()}>(java.util.Arrays.asList(__result__))"
    } else {
        "__result__"
    }
    return tmpl
        .replace("#__type_name__#", typeName)
        .replace("#__result__#", result)
}