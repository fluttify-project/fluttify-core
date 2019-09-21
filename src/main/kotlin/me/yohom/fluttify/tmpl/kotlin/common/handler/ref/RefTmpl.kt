package me.yohom.fluttify.tmpl.kotlin.common.handler.ref

import me.yohom.fluttify.model.Method

//val refId = args["refId"] as Int
//val ref = REF_MAP[refId] as #__class_name__#
internal class RefTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/ref.stmt.kt.tmpl").readText()

    fun kotlinRef(): String {
        return if (method.isStatic)
            ""
        else
            tmpl.replace("#__class_name__#", method.className)
    }
}