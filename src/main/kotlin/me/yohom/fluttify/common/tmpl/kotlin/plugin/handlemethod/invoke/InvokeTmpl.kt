package me.yohom.fluttify.common.tmpl.kotlin.plugin.handlemethod.invoke

import me.yohom.fluttify.common.extensions.findType
import me.yohom.fluttify.common.model.Method
import me.yohom.fluttify.common.model.Variable

class InvokeTmpl(private val method: Method) {
    fun kotlinInvoke(): String {
        // 在引用上调用方法 先分是否是静态方法, 再分返回类型是否是void
        return if (method.isStatic) {
            if (method.returnType == "void") {
                "${method.className}.${method.name}(${method.formalParams.joinToString { var2formalParam(it) }})"
            } else {
                "val result = ${method.className}.${method.name}(${method.formalParams.joinToString { var2formalParam(it) }})"
            }
        } else {
            if (method.returnType == "void") {
                "ref.${method.name}(${method.formalParams.joinToString { var2formalParam(it) }})"
            } else {
                "val result = ref.${method.name}(${method.formalParams.joinToString { var2formalParam(it) }})"
            }
        }
    }

    private fun var2formalParam(it: Variable): String {
        return if (it.typeName.findType().isCallback()) {
            CallbackTmpl(method, it.typeName.findType()).kotlinCallback()
        } else {
            if (it.isList) "ArrayList(${it.name})" else it.name
        }
    }
}