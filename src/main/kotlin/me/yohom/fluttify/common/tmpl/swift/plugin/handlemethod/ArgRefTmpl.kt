package me.yohom.fluttify.common.tmpl.swift.plugin.handlemethod

import me.yohom.fluttify.common.model.Variable

//// 引用参数
//val #__arg_name__# = REF_MAP[args["#__arg_name__#"] as Int] as #__type_name__#
class ArgRefTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/arg_ref.stmt.swift.tmpl").readText()

    fun swiftArgRef(): String {
        return tmpl
            .replace("#__type_name__#", if (variable.isList) "List<${variable.typeName}>" else variable.typeName)
            .replace("#__arg_name__#", variable.name)
    }
}