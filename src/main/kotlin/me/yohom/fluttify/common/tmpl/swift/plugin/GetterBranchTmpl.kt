package me.yohom.fluttify.common.tmpl.swift.plugin

import me.yohom.fluttify.common.model.Field

//"#__method_name__#" : #__handler__#
class GetterBranchTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/branch.stmt.swift.tmpl").readText()

    fun swiftGetterBranch(): String {
        return tmpl
            .replace("#__method_name__#", field.getterMethodName())
            .replace("#__handler__#", field.nativeHandleGetterMethodName())
    }
}