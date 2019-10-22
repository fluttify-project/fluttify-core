package me.yohom.fluttify.tmpl.kotlin.common.handler.common.log

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.underscore2Camel
import me.yohom.fluttify.model.Method

//val refId = args["refId"] as Int
//val ref = HEAP[refId] as #__class_name__#
// todo
internal class LogStaticTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("val refId = args[\"refId\"] as Int\nval ref = HEAP[refId] as #__class_name__#")
            .readText()

    fun kotlinTypeCast(): String {
        return if (method.isStatic)
            ""
        else
            tmpl.replace("#__class_name__#", method.className)

    }
}