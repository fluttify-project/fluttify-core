package me.yohom.fluttify.common.tmpl.kotlin

import me.yohom.fluttify.common.model.Variable

//val refId = args["refId"] as Int
//val ref = REF_MAP[refId] as #__class_name__#
class RefTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/ref.stmt.kt.tmpl").readText()

    fun kotlinRef(): String {
        return tmpl
            .replace("#__class_name__#", variable.typeName)
    }
}