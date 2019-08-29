package me.yohom.fluttify.common.tmpl.swift.plugin.handler.invoke

import me.yohom.fluttify.common.extensions.findType
import me.yohom.fluttify.common.extensions.toSwiftMethod
import me.yohom.fluttify.common.model.Method
import me.yohom.fluttify.common.model.Parameter

internal class InvokeTmpl(private val method: Method) {
    fun swiftInvoke(): String {
        // 在引用上调用方法 先分是否是静态方法, 再分返回类型是否是void
        return if (method.isStatic) {
            val invoke = "${method.className}.${method.name.toSwiftMethod()}${method.formalParams.joinToString { var2formalParam(it) }})"
            if (method.returnType == "void") {
                invoke
            } else {
                "let result = $invoke"
            }
        } else {
            val invoke = "ref.${method.name.toSwiftMethod()}${method.formalParams.joinToString { var2formalParam(it) }})"
            if (method.returnType == "void") {
                invoke
            } else {
                "let result = $invoke"
            }
        }
    }

    private fun var2formalParam(it: Parameter): String {
        return if (it.variable.typeName.findType().isCallback()) {
            LambdaCallbackTmpl(method, it.variable.typeName.findType()).swiftCallback()
        } else {
            when {
                it.named.isNotEmpty() -> "${it.named}: ${it.variable.name}"
                else -> it.variable.name
            }
        }
    }
}