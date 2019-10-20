package me.yohom.fluttify.tmpl.kotlin.common.handler.handler_type_cast

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.underscore2Camel
import me.yohom.fluttify.model.Method

// todo 先实现objc的
//val refId = args["refId"] as Int
//val ref = HEAP_#__plugin_name__#[refId] as #__class_name__#
internal class HandlerTypeCastTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/handler_type_cast.stmt.kt.tmpl").readText()

    fun kotlinTypeCast(): String {
        return if (method.isStatic)
            ""
        else
            tmpl.replace("#__class_name__#", method.className)
                .replace("#__plugin_name__#", ext.outputProjectName.underscore2Camel(true))
    }
}