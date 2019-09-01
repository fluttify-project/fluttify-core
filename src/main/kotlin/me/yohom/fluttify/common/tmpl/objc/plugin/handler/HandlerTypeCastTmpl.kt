package me.yohom.fluttify.common.tmpl.objc.plugin.handler

import me.yohom.fluttify.common.model.Method

//val refId = args["refId"] as Int
//val ref = REF_MAP[refId] as #__class_name__#
internal class HandlerTypeCastTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/plugin/handler/handler_type_cast.stmt.m.tmpl").readText()

    fun objcTypeCast(): String {
        return if (method.isStatic)
            ""
        else
            tmpl.replace("#__class_name__#", method.className)
    }
}