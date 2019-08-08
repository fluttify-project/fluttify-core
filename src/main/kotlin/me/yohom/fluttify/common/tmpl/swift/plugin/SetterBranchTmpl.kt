package me.yohom.fluttify.common.tmpl.swift.plugin

import me.yohom.fluttify.common.model.Field

//"#__class_name__#::#__method_name__#" : #__handler__#
class SetterBranchTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/branch.stmt.swift.tmpl").readText()

    fun swiftSetterBranch(): String {
        return tmpl.replace("#__class_name__#", field.className)
            .replace("#__method_name__#", field.setterMethodName())
            .replace("#__handler__#", field.nativeHandleSetterMethodName())
    }
}