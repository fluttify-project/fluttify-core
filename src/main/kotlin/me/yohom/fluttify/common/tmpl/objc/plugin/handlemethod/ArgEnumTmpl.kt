package me.yohom.fluttify.common.tmpl.objc.plugin.handlemethod

import me.yohom.fluttify.common.model.Variable

//// 枚举参数
//let #__arg_name__# = #__type_name__#.values()[args["#__arg_name__#"] as Int]
internal class ArgEnumTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/arg_enum.stmt.m.tmpl").readText()

    fun objcArgEnum(): String {
        return tmpl
            .replace("#__type_name__#", variable.typeName)
            .replace("#__arg_name__#", variable.name)
    }
}