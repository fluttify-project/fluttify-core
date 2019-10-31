package me.yohom.fluttify.tmpl.kotlin.common.handler.common.log

import me.yohom.fluttify.model.Method

//println("fluttify-kotlin: #__class_name__#@$refId::#__method_name__#(#__args__#)")
internal class LogInstanceTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/log_instance.stmt.kt.tmpl").readText()

    fun kotlinLogInstance(): String {
        val className = method.className
        val methodName = method.name
        val args = method
            .formalParams
            .filter { it.variable.jsonable() }
            .joinToString { "\\\"${it.variable.name}\\\":$${it.variable.name}" }
        return tmpl
            .replace("#__class_name__#", className)
            .replace("#__method_name__#", methodName)
            .replace("#__args__#", args)
    }
}