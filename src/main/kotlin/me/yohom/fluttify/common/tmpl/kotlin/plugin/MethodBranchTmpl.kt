package me.yohom.fluttify.common.tmpl.kotlin.plugin

import me.yohom.fluttify.common.model.Method

//"#__method_name__#" to ::#__handler__#
class MethodBranchTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/branch.stmt.kt.tmpl").readText()

    fun kotlinMethodBranch(): String {
        return tmpl
            .replace("#__method_name__#", method.methodName())
            .replace("#__handler__#", method.handleMethodName())
    }
}