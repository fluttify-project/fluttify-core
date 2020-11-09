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
                when {
                    trueType == "id" -> "NSObject*"
                    trueType.findType().isInterface -> trueType.enprotocol()
                    else -> trueType
                }
            }

            if (isStatic == true) {
                if (!className.findType().isInterface) {
                    "$typeName result = [$className ${variable.name}];"
                }
                // 协议静态方法
                else {
                    "$typeName result = [[NSObject<$className> class] ${variable.name}];"
                }
            } else {
                "$typeName result = ref.${variable.name};"
            }
        }

        val invokeMethod = method?.run {
            val returnTypeName = when {
                returnType == "id" -> "NSObject*"
                returnType.findType().isInterface -> returnType.enprotocol()
                else -> returnType
            }

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
                    val args = method.formalParams.joinToString(" ") { param2arg(it) }
                    "[[NSObject<${method.className}> class] ${method.name}${args}]"
                }

                if (returnTypeName == "void") {
                    "$call;"
                } else {
                    "$returnTypeName result = $call;"
                }
            } else {
                if (returnTypeName == "void") {
                    "[ref ${method.name} ${method.formalParams.joinToString(" ") { param2arg(it) }}];"
                } else {
                    val args = method.formalParams.joinToString(" ") { param2arg(it) }
                    "$returnTypeName result = [ref ${method.name}${args}];"
                }
            }
        }
        return (invokeGetter ?: invokeMethod)!!
    }

    private fun param2arg(it: Parameter, isFunction: Boolean = false): String {
        return if (isFunction) {
            if (it.variable.isLambda() && method != null) {
                CallbackLambdaTmpl(method, it.variable.trueType.findType())
            } else {
                when {
                    // 回调类, 同时支持作为对象传入, 因为碰到既需要作为对象传递又需要作为回调的情况. 如果参数为null则认为是回调, 否则就认为是普通对象
                    it.variable.isCallback() -> "${it.variable.name} != nil ? ${it.variable.name} : weakSelf"
                    it.variable.trueType.isPrimitivePointerType() -> "[${it.variable.name} pointerValue]"
                    else -> it.variable.name
                }
            }
        } else {
            if (it.variable.isLambda() && method != null) {
                "${it.named}: ${CallbackLambdaTmpl(method, it.variable.trueType.findType())}"
            } else {
                "${it.named}: ${when {
                    // 回调类, 同时支持作为对象传入, 因为碰到既需要作为对象传递又需要作为回调的情况. 如果参数为null则认为是回调, 否则就认为是普通对象
                    it.variable.isCallback() -> "${it.variable.name} != nil ? ${it.variable.name} : weakSelf"
                    it.variable.trueType.isPrimitivePointerType() -> "[${it.variable.name} pointerValue]"
                    else -> it.variable.name
                }}"
            }
        }
    }
}