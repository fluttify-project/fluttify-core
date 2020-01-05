package me.yohom.fluttify.tmpl.java.common.handler.common.arg

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//// enum arg
//#__type_name__# #__arg_name__# = #__type_name__#.values()[(int) args.get("#__arg_name__#")];
private val tmpl = getResource("/tmpl/java/arg_enum.stmt.java.tmpl").readText()

fun ArgEnumTmpl(variable: Variable): String {
    return tmpl
        .replace("#__type_name__#", variable.typeName.replace("$", "."))
        .replace("#__arg_name__#", variable.name)
}