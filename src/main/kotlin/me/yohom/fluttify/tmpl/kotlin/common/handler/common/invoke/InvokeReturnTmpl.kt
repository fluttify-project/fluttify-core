package me.yohom.fluttify.tmpl.kotlin.common.handler.common.invoke

import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Variable
import me.yohom.fluttify.tmpl.kotlin.common.handler.common.invoke.callback.CallbackTmpl

//val result = #__invoke_target__#.#__method_name__#(#__actual_params__#)
class InvokeReturnTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/invoke_return.stmt.kt.tmpl").readText()

    fun kotlinInvokeReturn(): String {
        // 在引用上调用方法 先分是否是静态方法, 再分返回类型是否是void
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
                variable.isList -> "ArrayList(${variable.run { if (typeName.contains("float", true)) "$name.map { it.toFloat() }" else name }})"
                // 由于dart端的double到kotlin这边都是double, 如果方法参数是float的话, 需要转一手
                variable.typeName.toLowerCase() == "float" -> "${variable.name}.toFloat()"
                else -> variable.name
            }
        }
    }
}