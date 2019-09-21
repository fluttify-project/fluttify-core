package me.yohom.fluttify.tmpl.objc.common.handler.common.invoke

import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Parameter

internal class InvokeTmpl(private val method: Method) {
    fun objcInvoke(): String {
        // 在引用上调用方法 先分是否是静态方法, 再分返回类型是否是void
        return if (method.isStatic) {
            if (method.returnType == "void") {
                "[${method.className} ${method.name} ${method.formalParams.joinToString(" ") { var2formalParam(it) }}];"
            } else {
                "${method.returnType} result = [${method.className} ${method.name}${method.formalParams.joinToString(" ") {
                    var2formalParam(it)
                }}];"
            }
        } else {
            if (method.returnType == "void") {
                "[ref ${method.name} ${method.formalParams.joinToString(" ") { var2formalParam(it) }}];"
            } else {
                "${method.returnType} result = [ref ${method.name}${method.formalParams.joinToString(" ") {
                    var2formalParam(it)
                }}];"
            }
        }
    }

    private fun var2formalParam(it: Parameter): String {
        return if (it.variable.typeName.findType().isLambda()) {
            "${it.named}: nil /* lambda回调暂时不支持 */"
//            LambdaCallbackTmpl(method, it.variable.typeName.findType()).objcCallback()
        } else {
            "${it.named}: ${if (it.variable.typeName.findType().isCallback()) "self" else it.variable.name}"
        }
    }
}