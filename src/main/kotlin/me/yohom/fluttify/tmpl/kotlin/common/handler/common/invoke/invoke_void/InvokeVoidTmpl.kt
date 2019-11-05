package me.yohom.fluttify.tmpl.kotlin.common.handler.common.invoke.invoke_void

import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Variable
import me.yohom.fluttify.tmpl.kotlin.common.handler.common.invoke.common.callback.CallbackTmpl

//#__invoke_target__#.#__method_name__#(#__actual_params__#)
class InvokeVoidTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/invoke_void.stmt.kt.tmpl").readText()

    fun kotlinInvokeVoid(): String {
        return tmpl
            .replace("#__invoke_target__#", if (method.isStatic) method.className else "ref")
            .replace("#__method_name__#", method.name)
            .replace("#__actual_params__#", method.formalParams.joinToString { var2formalParam(it.variable) })
    }

    private fun var2formalParam(variable: Variable): String {
        return if (variable.typeName.findType().isCallback()) {
            CallbackTmpl(method, variable.typeName.findType()).kotlinCallback()
        } else {
            when {
                variable.isList -> "new ArrayList(${variable.run {
                    if (typeName.contains("float", true)) "$name.map { it.toFloat() }" else name
                }})"
                // 由于dart端的double到kotlin这边都是double, 如果方法参数是float的话, 需要转一手
                variable.typeName.toLowerCase() == "float" -> "${variable.name}.toFloat()"
                else -> variable.name
            }
        }
    }
}