package me.yohom.fluttify.common.tmpl.swift.plugin

import me.yohom.fluttify.common.extensions.toDartType
import me.yohom.fluttify.common.model.Method

//"#__class_name__#::#__method_name__#" : #__handler__#
class MethodBranchTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/branch.stmt.swift.tmpl").readText()

    fun swiftMethodBranch(): String {
        val className = method.className
        val methodName = method.name
        val handler = "handle${method.className.toDartType()}_${method.name}"

        return tmpl.replace("#__class_name__#", className)
            .replace("#__method_name__#", methodName)
            .replace("#__handler__#", handler)
    }
}