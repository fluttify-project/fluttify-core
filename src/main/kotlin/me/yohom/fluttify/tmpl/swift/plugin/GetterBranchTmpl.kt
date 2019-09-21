package me.yohom.fluttify.tmpl.swift.plugin

import me.yohom.fluttify.model.Field

//"#__method_name__#" : #__handler__#
internal class GetterBranchTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/branch.stmt.swift.tmpl").readText()

    fun swiftGetterBranch(): String {
        return tmpl
            .replace("#__method_name__#", field.getterMethodName())
            .replace("#__handler__#", field.nativeHandleGetterMethodName())
    }
}