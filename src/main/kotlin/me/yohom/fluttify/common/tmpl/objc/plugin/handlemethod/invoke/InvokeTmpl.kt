package me.yohom.fluttify.common.tmpl.objc.plugin.handlemethod.invoke

import me.yohom.fluttify.common.extensions.findType
import me.yohom.fluttify.common.model.Method
import me.yohom.fluttify.common.model.Parameter

internal class InvokeTmpl(private val method: Method) {
    fun objcInvoke(): String {
        // 在引用上调用方法 先分是否是静态方法, 再分返回类型是否是void
        return if (method.isStatic) {
            if (method.returnType == "void") {
                "[${method.className} ${method.name} ${method.formalParams.joinToString(" ") { var2formalParam(it) }}];"
            } else {
                "${method.returnType} result = [${method.className} ${method.name}${method.formalParams.joinToString(" ") { var2formalParam(it) }}];"
            }
        } else {
            if (method.returnType == "void") {
                "[ref ${method.name} ${method.formalParams.joinToString(" ") { var2formalParam(it) }}];"
            } else {
                "${method.returnType} result = [ref ${method.name}${method.formalParams.joinToString(" ") { var2formalParam(it) }}];"
            }
        }
    }

    private fun var2formalParam(it: Parameter): String {
        return if (it.variable.typeName.findType().isCallback()) {
            LambdaCallbackTmpl(method, it.variable.typeName.findType()).objcCallback()
        } else {
            when {
                it.named.isNotEmpty() -> "${it.named}: ${it.variable.name}"
                else -> ": ${it.variable.name}"
            }
        }
    }
}