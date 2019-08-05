package me.yohom.fluttify.common.tmpl.swift.plugin

import me.yohom.fluttify.common.model.Field

//"#__class_name__#::#__method_name__#" : #__handler__#
class GetterBranchTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/branch.stmt.swift.tmpl").readText()

    fun swiftGetterBranch(): String {
        val className = field.className
        val methodName = "get_${field.variable!!.name}"
        val handler = field.nativeHandleGetterMethod()

        return tmpl.replace("#__class_name__#", className)
            .replace("#__method_name__#", methodName)
            .replace("#__handler__#", handler)
    }
}