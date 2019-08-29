package me.yohom.fluttify.common.tmpl.kotlin.plugin.handler.invoke

import me.yohom.fluttify.common.extensions.jsonable
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.extensions.toKotlinType
import me.yohom.fluttify.common.model.Method

//override fun #__callback_method__#(#__formal_params__#): #__return_type__# {
//    // 日志打印
//    #__log__#
//
//    // 开始回调
//    callbackChannel.invokeMethod(
//        "#__caller_class_name__#::#__caller_method_name__#_Callback::#__callback_method__#",
//        mapOf<String, Any?>(
//            #__callback_params__#
//            "refId" to refId
//        )
//    )
//
//    // 方法返回值
//    #__return_stmt__#
//}
internal class CallbackMethodTmpl(private val callerMethod: Method, private val callbackMethod: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/callback_method.mtd.kt.tmpl").readText()

    fun kotlinCallbackMethod(): String {
        return tmpl
            .replace("#__callback_method__#", callbackMethod.name)
            .replace(
                "#__formal_params__#",
                callbackMethod.formalParams.joinToString { "${it.variable.name}: ${if (it.variable.isList) "List<${it.variable.typeName.toKotlinType()}>" else it.variable.typeName.toKotlinType()}" }
            )
            .replace("#__return_type__#", callbackMethod.returnType.toKotlinType())
            .replace("#__caller_class_name__#", callerMethod.className)
            .replace("#__caller_method_name__#", callerMethod.name)
            .replace("#__callback_method__#", callbackMethod.name)
            .replaceParagraph(
                "#__callback_params__#",
                callbackMethod.formalParams.joinToString("") {
                    "\"${it.variable.name}\" to ${if (it.variable.typeName.jsonable()) it.variable.name else "${it.variable.name}.hashCode().apply { REF_MAP[this] = ${it.variable.name} }"},\n"
                }
            )
            .replaceParagraph(
                "#__log__#",
                "println(\"fluttify-kotlin-callback: ${callerMethod.className}@\$refId::${callerMethod.name}_${callbackMethod.name}(${callbackMethod.formalParams.map { "\\\"${it.variable.name}\\\":$${it.variable.name}" }})\")"
            )
            .replaceParagraph(
                "#__return_stmt__#",
                when (callbackMethod.returnType.toKotlinType()) {
                    "Boolean" -> "return true"
                    "Int" -> "return 0"
                    else -> ""
                }
            )
    }
}