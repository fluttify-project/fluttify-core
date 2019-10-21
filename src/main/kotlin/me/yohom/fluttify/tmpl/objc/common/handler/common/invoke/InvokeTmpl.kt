package me.yohom.fluttify.tmpl.objc.common.handler.common.invoke

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Parameter
import me.yohom.fluttify.tmpl.objc.common.callback.callback_lambda.CallbackLambdaTmpl

internal class InvokeTmpl private constructor(private val field: Field?, private val method: Method?) {

    constructor(field: Field) : this(field, null)

    constructor(method: Method) : this(null, method)

    fun objcInvoke(): String {
        val invokeGetter = field?.run {
            val typeName = variable.run {
                if (isStructPointer()) {
                    typeName.enpointer()
                } else if (typeName.isObjcPrimitive() || isStruct()) {
                    typeName
                } else if (isList && genericLevel > 0) {
                    if (isInterface()) "NSArray<${typeName.enprotocol()}>*" else "NSArray<${typeName}>*"
                } else if (isInterface()) {
                    typeName.enprotocol()
                } else {
                    "$typeName*"
                }
            }

            "$typeName result = ref.${variable.name.depointer()};"
        }

        val invokeMethod = method?.run {
            // 在引用上调用方法 先分是否是静态方法, 再分返回类型是否是void
            if (method.isStatic) {
                if (method.returnType == "void") {
                    "[${method.className} ${method.name} ${method.formalParams.joinToString(" ") { var2formalParam(it) }}];"
                } else {
                    "${method.returnType} result = [${method.className} ${method.name}${method.formalParams.joinToString(
                        " "
                    ) {
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

        return (invokeGetter ?: invokeMethod)!!
    }

    private fun var2formalParam(it: Parameter): String {
        return if (it.variable.isLambda() && method != null) {
            "${it.named}: ${CallbackLambdaTmpl(method, it.variable.typeName.findType()).objcCallback()}"
        } else {
            "${it.named}: ${if (it.variable.isCallback()) "self" else it.variable.name}"
        }
    }
}