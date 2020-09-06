package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.invoke_void

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Method

//#__invoke_target__#.#__method_name__#(#__actual_params__#);
private val tmpl by lazy { getResource("/tmpl/java/invoke_void.stmt.java.tmpl").readText() }

fun InvokeVoidTmpl(method: Method): String {
    return tmpl
        .replace("#__invoke_target__#", if (method.isStatic) method.className.replace("$", ".") else "__this__")
        .replace("#__method_name__#", method.name)
        .replace("#__actual_params__#", method.formalParams.joinToString { it.variable.var2Args(method) })
}