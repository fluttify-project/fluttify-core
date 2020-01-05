package me.yohom.fluttify.tmpl.java.common.handler.handler_type_cast

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Method

// todo 先实现objc的
//val refId = args["refId"] as Int
//val ref = HEAP[refId] as #__class_name__#
private val tmpl = getResource("/tmpl/java/handler_type_cast.stmt.java.tmpl").readText()

fun HandlerTypeCastTmpl(method: Method): String {
    return if (method.isStatic)
        ""
    else
        tmpl.replace("#__class_name__#", method.className.replace("$", "."))
}