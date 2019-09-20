package me.yohom.fluttify.common.tmpl.kotlin.common.handler.invoke

import me.yohom.fluttify.common.extensions.findType
import me.yohom.fluttify.common.model.Method
import me.yohom.fluttify.common.model.Variable

internal class InvokeTmpl(private val method: Method) {
    fun kotlinInvoke(): String {
        // 在引用上调用方法 先分是否是静态方法, 再分返回类型是否是void
        return if (method.isStatic) {
            if (method.returnType == "void") {
                "${method.className}.${method.name}(${method.formalParams.joinToString { var2formalParam(it.variable) }})"
            } else {
                "val result = ${method.className}.${method.name}(${method.formalParams.joinToString { var2formalParam(it.variable) }})"
            }
        } else {
            if (method.returnType == "void") {
                "ref.${method.name}(${method.formalParams.joinToString { var2formalParam(it.variable) }})"
            } else {
                "val result = ref.${method.name}(${method.formalParams.joinToString { var2formalParam(it.variable) }})"
            }
        }
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