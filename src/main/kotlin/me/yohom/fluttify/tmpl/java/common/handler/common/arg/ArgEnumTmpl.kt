package me.yohom.fluttify.tmpl.java.common.handler.common.arg

import me.yohom.fluttify.model.Variable

//// enum arg
//#__type_name__# #__arg_name__# = #__type_name__#.values()[(int) args.get("#__arg_name__#")];
internal class ArgEnumTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/java/arg_enum.stmt.java.tmpl").readText()

    fun kotlinArgEnum(): String {
        return tmpl
            .replace("#__type_name__#", variable.typeName)
            .replace("#__arg_name__#", variable.name)
    }
}