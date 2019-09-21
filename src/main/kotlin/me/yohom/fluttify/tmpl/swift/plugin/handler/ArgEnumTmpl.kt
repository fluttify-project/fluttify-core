package me.yohom.fluttify.tmpl.swift.plugin.handler

import me.yohom.fluttify.model.Variable

//// 枚举参数
//let #__arg_name__# = #__type_name__#.values()[args["#__arg_name__#"] as Int]
internal class ArgEnumTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/arg_enum.stmt.swift.tmpl").readText()

    fun swiftArgEnum(): String {
        return tmpl
            .replace("#__type_name__#", variable.typeName)
            .replace("#__arg_name__#", variable.name)
    }
}