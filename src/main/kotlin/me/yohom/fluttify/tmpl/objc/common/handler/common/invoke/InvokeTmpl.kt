package me.yohom.fluttify.tmpl.objc.common.handler.common.invoke

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Parameter
import me.yohom.fluttify.tmpl.objc.common.callback.callback_lambda.CallbackLambdaTmpl

class InvokeTmpl private constructor(private val field: Field?, private val method: Method?) {

    constructor(field: Field) : this(field, null)

    constructor(method: Method) : this(null, method)

    fun objcInvoke(): String {
        val invokeGetter = field?.run {
            val typeName = variable.run {
                when (trueType) {
                    "id" -> "NSObject*"
                    else -> trueType
                }
            }

            "$typeName result = ref.${variable.name};"
        }

        val invokeMethod = method?.run {
            // 在引用上调用方法 先分是否是静态方法, 再分返回类型是否是void
            if (method.isStatic) {
                // 函数
                val call = if (method.isFunction) {
                    "${method.name}(${method.formalParams.joinToString { param2arg(it, true) }})"
                }
                // 类静态方法
                else if (!method.className.findType().isInterface) {
                    "[${method.className} ${method.name}${method.formalParams.joinToString(" ") { param2arg(it) }}]"
                }
                // 协议静态方法
                else {
                    "[[NSObject<${method.className}> class] ${method.name}${method.formalParams.joinToString(" ") { param2arg(it) }}]"
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
                    "${method.returnType} result = [ref ${method.name}${method.formalParams.joinToString(" ") { param2arg(it) }}];"
                }
            }
        }
        return (invokeGetter ?: invokeMethod)!!
    }

    private fun param2arg(it: Parameter, isFunction: Boolean = false): String {
        return if (isFunction) {
            if (it.variable.isLambda() && method != null) {
                CallbackLambdaTmpl(it.variable.trueType.findType())
            } else {
                when {
                    it.variable.isCallback() -> "self"
                    it.variable.trueType.isPrimitivePointerType() -> "[${it.variable.name} pointerValue]"
                    else -> it.variable.name
                }
            }
        } else {
            if (it.variable.isLambda() && method != null) {
                "${it.named}: ${CallbackLambdaTmpl(it.variable.trueType.findType())}"
            } else {
                "${it.named}: ${when {
                    it.variable.isCallback() -> "self"
                    it.variable.trueType.isPrimitivePointerType() -> "[${it.variable.name} pointerValue]"
                    else -> it.variable.name
                }}"
            }
        }
    }
}