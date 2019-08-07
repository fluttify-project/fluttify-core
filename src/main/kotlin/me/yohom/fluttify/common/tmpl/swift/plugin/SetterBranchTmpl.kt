package me.yohom.fluttify.common.tmpl.swift.plugin

import me.yohom.fluttify.common.model.Field

//"#__class_name__#::#__method_name__#" : #__handler__#
class SetterBranchTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/branch.stmt.swift.tmpl").readText()

    fun swiftSetterBranch(): String {
        val className = field.className
        val methodName = "set${field.variable.name.capitalize()}"
        val handler = field.nativeHandleSetterMethod()

        return tmpl.replace("#__class_name__#", className)
            .replace("#__method_name__#", methodName)
            .replace("#__handler__#", handler)
    }
}