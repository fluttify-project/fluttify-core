package me.yohom.fluttify.tmpl.java.common.handler.common.arg

import me.yohom.fluttify.extensions.boxedType
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.ifIsGenericTypeConvertToObject
import me.yohom.fluttify.model.Variable

//// ref arg
//#__type_name__# #__arg_name__# = (#__type_name__#) ((Map<String, Object>) __args__).get("#__arg_name__#");
private val tmpl by lazy { getResource("/tmpl/java/arg_ref.stmt.java.tmpl").readText() }

fun ArgRefTmpl(variable: Variable): String {
    val typeName = variable.trueType
        .replace("$", ".")
        .ifIsGenericTypeConvertToObject()
        .run {
            when(toLowerCase()) {
                "float" -> "Double"
                "long" -> "Integer" // 先统一使用Integer
                else -> this
            }
        }
    return tmpl
        .replace("#__type_name__#", typeName)
        .replace("#__arg_name__#", variable.name)
}