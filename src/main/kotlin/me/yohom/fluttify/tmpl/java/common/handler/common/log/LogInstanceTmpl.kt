package me.yohom.fluttify.tmpl.java.common.handler.common.log

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Method

//println("fluttify-kotlin: #__class_name__#@$refId::#__method_name__#(#__args__#)")
private val tmpl by lazy { getResource("/tmpl/java/log_instance.stmt.java.tmpl").readText() }

fun LogInstanceTmpl(method: Method): String {
    val className = method.className.replace("$", ".")
    val methodName = method.name
    val args = method
        .formalParams
        .filterNot { it.variable.isCallback() }
        .filterNot { it.variable.isLambda() }
        .joinToString(" + ") { it.variable.name }
    return tmpl
        .replace("#__class_name__#", className)
        .replace("#__method_name__#", methodName)
        .replace("#__args__#", if (args.isEmpty()) "\"\"" else args)
}