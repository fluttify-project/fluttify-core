package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.invoke_void

import me.yohom.fluttify.extensions.dearray
import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.isArray
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Variable
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.CallbackTmpl

//#__invoke_target__#.#__method_name__#(#__actual_params__#);
class InvokeVoidTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/java/invoke_void.stmt.java.tmpl").readText()

    fun javaInvokeVoid(): String {
        return tmpl
            .replace("#__invoke_target__#", if (method.isStatic) method.className else "ref")
            .replace("#__method_name__#", method.name)
            .replace("#__actual_params__#", method.formalParams.joinToString { var2formalParam(it.variable) })
    }

    // todo 和InvokeReturnTmpl合并一下
    private fun var2formalParam(variable: Variable): String {
        return variable.run {
            if (typeName.findType().isCallback()) {
                CallbackTmpl(method, typeName.findType()).javaCallback()
            } else {
                when {
                    isList -> if (typeName.isArray()) "$name.toArray(new ${typeName.dearray()}[$name.size()])" else "new ArrayList($name)"
                    typeName.toLowerCase() == "float" -> "$name.floatValue()"
                    else -> name
                }
            }
        }
    }
}