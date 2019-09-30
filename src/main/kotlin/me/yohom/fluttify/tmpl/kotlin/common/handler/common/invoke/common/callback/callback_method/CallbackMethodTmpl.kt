package me.yohom.fluttify.tmpl.kotlin.common.handler.common.invoke.common.callback.callback_method

import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.extensions.toKotlinType
import me.yohom.fluttify.model.Method

//override fun #__callback_method__#(#__formal_params__#): #__return_type__# {
//    // 日志打印
//    #__log__#
//
//    // 开始回调
//    callbackChannel.invokeMethod(
//        "Callback::#__callback_method_name__#",
//        mapOf<String, Any?>(
//            #__callback_params__#
//        )
//    )
//
//    // 方法返回值
//    #__return_stmt__#
//}
// todo 支持回调方法的列表参数
internal class CallbackMethodTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/callback_method.mtd.kt.tmpl").readText()

    fun kotlinCallbackMethod(): String {
        val callbackMethod = method.name
        val callbackMethodName = method.nameWithClass()
        val methodChannel = "${method.className}::Callback"
        val formalParams = method
            .formalParams
            .joinToString { "${it.variable.name}: ${if (it.variable.isList) "List<${it.variable.typeName.toKotlinType()}>" else it.variable.typeName.toKotlinType()}" }
        val returnType = when (method.returnType.toKotlinType()) {
            // 原始类型使用非可空类型
            "Boolean", "Int", "Float", "Double", "Unit" -> method.returnType.toKotlinType()
            // 引用类型使用可空类型
            else -> "${method.returnType.toKotlinType()}?"
        }
        val callbackParams = method
            .formalParams
            .joinToString(",\n") {
                "\"${it.variable.name}\" to ${if (it.variable.jsonable()) it.variable.name else "${it.variable.name}.hashCode().apply { HEAP[this] = ${it.variable.name} }"}"
            }
        val log =
            "println(\"fluttify-kotlin-callback: ${method.name}(${method.formalParams.map { "\\\"${it.variable.name}\\\":$${it.variable.name}" }})\")"
        val returnStmt = when (method.returnType.toKotlinType()) {
            "Boolean" -> "return true"
            "Int" -> "return 0"
            "Float" -> "return 0f"
            "Double" -> "return 0.0"
            "Unit" -> ""
            else -> "return null"
        }

        return tmpl
            .replace("#__callback_method__#", callbackMethod)
            .replace("#__callback_method_name__#", callbackMethodName)
            .replace("#__method_channel__#", methodChannel)
            .replace("#__formal_params__#", formalParams)
            .replace("#__return_type__#", returnType)
            .replaceParagraph("#__callback_params__#", callbackParams)
            .replaceParagraph("#__log__#", log)
            .replaceParagraph("#__return_stmt__#", returnStmt)
    }
}