package me.yohom.fluttify.tmpl.swift.plugin.handler

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.underscore2Camel
import me.yohom.fluttify.model.Variable

//// 引用参数
//val #__arg_name__# = HEAP_#__plugin_name__#[args["#__arg_name__#"] as Int] as #__type_name__#
internal class ArgRefTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/arg_ref.stmt.swift.tmpl").readText()

    fun swiftArgRef(): String {
        return tmpl
            .replace("#__type_name__#", if (variable.isList) "List<${variable.typeName}>" else variable.typeName)
            .replace("#__arg_name__#", variable.name)
            .replace("#__plugin_name__#", ext.outputProjectName.underscore2Camel(true))
    }
}