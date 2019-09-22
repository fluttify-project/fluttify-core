package me.yohom.fluttify.tmpl.kotlin.common.handler.common.log

import me.yohom.fluttify.model.Method

//val refId = args["refId"] as Int
//val ref = REF_MAP[refId] as #__class_name__#
// todo
internal class LogInstanceTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("val refId = args[\"refId\"] as Int\nval ref = REF_MAP[refId] as #__class_name__#").readText()

    fun kotlinTypeCast(): String {
        return if (method.isStatic)
            ""
        else
            tmpl.replace("#__class_name__#", method.className)
    }
}