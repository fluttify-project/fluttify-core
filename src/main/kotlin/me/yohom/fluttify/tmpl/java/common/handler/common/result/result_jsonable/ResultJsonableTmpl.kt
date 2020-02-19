package me.yohom.fluttify.tmpl.java.common.handler.common.result.result_jsonable

import me.yohom.fluttify.extensions.dearray
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.isStringArray

//#__type_name__# jsonableResult = #__result__#;
private val tmpl = getResource("/tmpl/java/result_jsonable.stmt.java.tmpl").readText()

fun ResultJsonableTmpl(returnType: String): String {
    val typeName = if (returnType.isStringArray()) {
        "List<String>"
    } else {
        returnType
    }
    val result = if (returnType.isStringArray()) {
        "new ArrayList<${returnType.dearray()}>(java.util.Arrays.asList(result))"
    } else {
        "result"
    }
    return tmpl
        .replace("#__type_name__#", typeName)
        .replace("#__result__#", result)
}