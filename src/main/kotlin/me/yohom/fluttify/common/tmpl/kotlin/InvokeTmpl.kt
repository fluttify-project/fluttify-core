package me.yohom.fluttify.common.tmpl.kotlin

import me.yohom.fluttify.common.model.Method

class InvokeTmpl(private val method: Method) {
    fun kotlinInvoke(): String {
        // 在引用上调用方法 先分是否是静态方法, 再分返回类型是否是void
        return if (method.isStatic) {
            if (method.returnType == "void") {
                "${method.className}.${method.name}(${method.formalParams.joinToString { it.name }})"
            } else {
                "val result = ${method.className}.${method.name}(${method.formalParams.joinToString { it.name }})"
            }
        } else {
            if (method.returnType == "void") {
                "ref.${method.name}(${method.formalParams.joinToString { it.name }})"
            } else {
                "val result = ref.${method.name}(${method.formalParams.joinToString { it.name }})"
            }
        }
    }
}