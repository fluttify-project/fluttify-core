package me.yohom.fluttify.tmpl.kotlin.common.handler.common.ref

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.underscore2Camel
import me.yohom.fluttify.model.Method

//val refId = args["refId"] as Int
//val ref = HEAP_#__plugin_name__#[refId] as #__class_name__#
internal class RefTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/ref.stmt.kt.tmpl").readText()

    fun kotlinRef(): String {
        return if (method.isStatic)
            ""
        else
            tmpl.replace("#__class_name__#", method.className)
                .replace("#__plugin_name__#", ext.outputProjectName.underscore2Camel(true))
    }
}