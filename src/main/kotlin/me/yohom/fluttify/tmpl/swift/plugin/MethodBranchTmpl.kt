package me.yohom.fluttify.tmpl.swift.plugin

import me.yohom.fluttify.model.Method

//"#__method_name__#" : #__handler__#
internal class MethodBranchTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/swift/branch.stmt.swift.tmpl").readText()

    fun swiftMethodBranch(): String {
        return tmpl
            .replace("#__method_name__#", method.methodName())
            .replace("#__handler__#", method.handleMethodName())
    }
}