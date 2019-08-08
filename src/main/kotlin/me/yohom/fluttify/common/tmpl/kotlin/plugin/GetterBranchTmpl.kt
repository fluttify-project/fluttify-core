package me.yohom.fluttify.common.tmpl.kotlin.plugin

import me.yohom.fluttify.common.model.Field

//"#__class_name__#::#__method_name__#" to ::#__handler__#
class GetterBranchTmpl(private val field: Field) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/branch.stmt.kt.tmpl").readText()

    fun kotlinGetterBranch(): String {
        return tmpl.replace("#__class_name__#", field.className)
            .replace("#__method_name__#", field.getterMethodName())
            .replace("#__handler__#", field.nativeHandleGetterMethodName())
    }
}