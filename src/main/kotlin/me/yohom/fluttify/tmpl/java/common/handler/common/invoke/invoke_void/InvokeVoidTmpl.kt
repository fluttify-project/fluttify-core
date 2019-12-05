package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.invoke_void

import me.yohom.fluttify.model.Method

//#__invoke_target__#.#__method_name__#(#__actual_params__#);
class InvokeVoidTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/java/invoke_void.stmt.java.tmpl").readText()

    fun javaInvokeVoid(): String {
        return tmpl
            .replace("#__invoke_target__#", if (method.isStatic) method.className.replace("$", ".") else "ref")
            .replace("#__method_name__#", method.name)
            .replace("#__actual_params__#", method.formalParams.joinToString { it.variable.var2Args(method) })
    }
}