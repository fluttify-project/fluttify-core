package me.yohom.fluttify.common.tmpl.kotlin.plugin

import me.yohom.fluttify.common.model.Field

//"#__method_name__#" to ::#__handler__#
internal class SetterBranchTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/branch.stmt.kt.tmpl").readText()

    fun kotlinSetterBranch(): String {
        return tmpl
            .replace("#__method_name__#", field.setterMethodName())
            .replace("#__handler__#", field.nativeHandleSetterMethodName())
    }
}