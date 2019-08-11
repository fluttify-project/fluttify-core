package me.yohom.fluttify.common.tmpl.objc.plugin.handlemethod

import me.yohom.fluttify.common.extensions.toSwiftType
import me.yohom.fluttify.common.model.Variable

//// jsonable参数
//let #__arg_name__# = args["#__arg_name__#"] as #__type_name__#
internal class ArgJsonableTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/arg_jsonable.stmt.swift.tmpl").readText()

    fun swiftArgJsonable(): String {
        return tmpl
            .replace(
                "#__type_name__#",
                if (variable.isList) "List<${variable.typeName.toSwiftType()}>" else variable.typeName.toSwiftType()
            )
            .replace("#__arg_name__#", variable.name)
    }
}