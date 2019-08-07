package me.yohom.fluttify.common.tmpl.kotlin.plugin

import me.yohom.fluttify.common.model.Field

//"#__class_name__#::#__method_name__#" to ::#__handler__#
class SetterBranchTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/branch.stmt.kt.tmpl").readText()

    fun kotlinSetterBranch(): String {
        val className = field.className
        val methodName = "set${field.variable.name.capitalize()}"
        val handler = field.nativeHandleSetterMethod()

        return tmpl.replace("#__class_name__#", className)
            .replace("#__method_name__#", methodName)
            .replace("#__handler__#", handler)
    }
}