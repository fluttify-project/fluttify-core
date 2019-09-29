package me.yohom.fluttify.tmpl.objc.common.handler.common.invoke

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.enprotocol
import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.isObjcPrimitive
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Parameter

internal class InvokeTmpl private constructor(private val field: Field?, private val method: Method?) {

    constructor(field: Field) : this(field, null)

    constructor(method: Method) : this(null, method)

    fun objcInvoke(): String {
        val invokeGetter = field?.run {
            val typeName = variable.typeName.run {
                if (isObjcPrimitive() || findType().isStruct())
                    this
                else if (findType().isInterface())
                    this.enprotocol()
                else
                    "$this*"
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
        return if (it.variable.typeName.findType().isLambda()) {
            "${it.named}: nil /* lambda回调暂时不支持 */"
//            LambdaCallbackTmpl(method, it.variable.typeName.findType()).objcCallback()
        } else {
            "${it.named}: ${if (it.variable.typeName.findType().isCallback()) "self" else it.variable.name}"
        }
    }
}