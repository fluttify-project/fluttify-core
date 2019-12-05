package me.yohom.fluttify.tmpl.java.common.handler.handler_type_check

import me.yohom.fluttify.model.Method

// todo 先实现objc的
//val refId = args["refId"] as Int
//val ref = HEAP[refId] as #__class_name__#
internal class HandlerTypeCheckTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/java/handler_type_check.stmt.java.tmpl").readText()

    fun javaTypeCheck(): String {
        return if (method.isStatic)
            ""
        else
            tmpl.replace("#__class_name__#", method.className.replace("$", "."))

    }
}