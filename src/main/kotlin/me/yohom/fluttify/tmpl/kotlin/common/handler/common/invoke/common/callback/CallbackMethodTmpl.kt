package me.yohom.fluttify.tmpl.kotlin.common.handler.common.invoke.common.callback

import me.yohom.fluttify.extensions.jsonable
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.extensions.toKotlinType
import me.yohom.fluttify.model.Method

//override fun #__callback_method__#(#__formal_params__#): #__return_type__# {
//    // 日志打印
//    #__log__#
//
//    // 开始回调
//    callbackChannel.invokeMethod(
//        "Callback::#__callback_method__#",
//        mapOf<String, Any?>(#__callback_params__#)
//    )
//
//    // 方法返回值
//    #__return_stmt__#
//}
internal class CallbackMethodTmpl(private val callbackMethod: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/callback_method.mtd.kt.tmpl").readText()

    fun kotlinCallbackMethod(): String {
        return tmpl
            .replace("#__callback_method__#", callbackMethod.name)
            .replace("#__callback_method_name__#", callbackMethod.nameWithClass())
            .replace("#__method_channel__#", "${callbackMethod.className}::Callback")
            .replace(
                "#__formal_params__#",
                callbackMethod.formalParams.joinToString { "${it.variable.name}: ${if (it.variable.isList) "List<${it.variable.typeName.toKotlinType()}>" else it.variable.typeName.toKotlinType()}" }
            )
            .replace("#__return_type__#", when (callbackMethod.returnType.toKotlinType()) {
                // 原始类型使用非可空类型
                "Boolean", "Int", "Float", "Double", "Unit" -> callbackMethod.returnType.toKotlinType()
                // 引用类型使用可空类型
                else -> "${callbackMethod.returnType.toKotlinType()}?"
            })
            .replace(
                "#__callback_params__#",
                callbackMethod.formalParams.joinToString(",\n") {
                    "\"${it.variable.name}\" to ${if (it.variable.typeName.jsonable()) it.variable.name else "${it.variable.name}.hashCode().apply { HEAP[this] = ${it.variable.name} }"}"
                }
            )
            .replaceParagraph(
                "#__log__#",
                "println(\"fluttify-kotlin-callback: ${callbackMethod.name}(${callbackMethod.formalParams.map { "\\\"${it.variable.name}\\\":$${it.variable.name}" }})\")"
            )
            .replaceParagraph(
                "#__return_stmt__#",
                when (callbackMethod.returnType.toKotlinType()) {
                    "Boolean" -> "return true"
                    "Int" -> "return 0"
                    "Float" -> "return 0f"
                    "Double" -> "return 0.0"
                    "Unit" -> ""
                    else -> "return null"
                }
            )
    }
}