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
                when {
                    typeName == "id" -> "NSObject*"
                    isStructPointer() -> typeName.enpointer()
                    typeName.isValueType() || isStruct() -> typeName
                    isList && genericLevel > 0 -> if (isInterface()) "NSArray<${typeName.enprotocol()}>*" else "NSArray<${typeName}>*"
                    isInterface() -> typeName.enprotocol()
                    else -> typeName.enpointer()
                }
            }

            "$typeName result = ref.${variable.name.depointer()};"
        }

        val invokeMethod = method?.run {
            // 在引用上调用方法 先分是否是静态方法, 再分返回类型是否是void
            if (method.isStatic) {
                // 函数
                val call = if (method.isFunction) {
                    "${method.name}(${method.formalParams.joinToString { it.variable.name.depointer() }})"
                }
                // 方法
                else {
                    "[${method.className} ${method.name}${method.formalParams.joinToString(" ") { param2arg(it) }}]"
                }

                if (method.returnType == "void") {
                    "$call;"
                } else {
                    "${method.returnType} result = $call;"
                }
            } else {
                if (method.returnType == "void") {
                    "[ref ${method.name} ${method.formalParams.joinToString(" ") { param2arg(it) }}];"
                } else {
                    "${method.returnType} result = [ref ${method.name}${method.formalParams.joinToString(" ") {
                        param2arg(it)
                    }}];"
                }
            }
        }
        return (invokeGetter ?: invokeMethod)!!
    }

    private fun param2arg(it: Parameter): String {
        return if (it.variable.isLambda() && method != null) {
            "${it.named}: ${CallbackLambdaTmpl(method, it.variable.typeName.findType()).objcCallback()}"
        } else {
            "${it.named}: ${if (it.variable.isCallback()) "self" else it.variable.name}"
        }
    }
}