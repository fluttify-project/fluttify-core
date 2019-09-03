package me.yohom.fluttify.common.tmpl.kotlin.plugin.handler

import me.yohom.fluttify.common.model.Method

// todo 先实现objc的
//val refId = args["refId"] as Int
//val ref = REF_MAP[refId] as #__class_name__#
internal class HandlerTypeCheckTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/plugin/handler/handler_type_check.stmt.kt.tmpl").readText()

    fun kotlinTypeCheck(): String {
        return if (method.isStatic)
            ""
        else
            tmpl.replace("#__class_name__#", method.className)
    }
}