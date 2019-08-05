package me.yohom.fluttify.common.tmpl.kotlin.plugin.handlemethod

import me.yohom.fluttify.common.model.Method

//val refId = args["refId"] as Int
//val ref = REF_MAP[refId] as #__class_name__#
class RefTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/ref.stmt.kt.tmpl").readText()

    fun kotlinRef(): String {
        return if (method.isStatic)
            ""
        else
            tmpl.replace("#__class_name__#", method.className)
    }
}