package me.yohom.fluttify.common.tmpl.kotlin.plugin.handlermethod.invoke

import me.yohom.fluttify.common.extensions.jsonable
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.extensions.toKotlinType
import me.yohom.fluttify.common.model.Method

//override fun #__callback_method__#(#__formal_params__#): #__return_type__# {
//    callbackChannel.invokeMethod(
//        "#__caller_class_name__#::#__caller_method_name__#_Callback::#__callback_method__#",
//        mapOf<String, Any?>(
//            #__callback_params__#
//        )
//    )
//    #__return_stmt__#
//}
class CallbackMethodTmpl(private val callerMethod: Method, private val callbackMethod: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/callback_method.stmt.kt.tmpl").readText()

    fun kotlinCallbackMethod(): String {
        return tmpl
            .replace("#__callback_method__#", callbackMethod.name)
            .replace(
                "#__formal_params__#",
                callbackMethod.formalParams.joinToString { "${it.name}: ${it.typeName.toKotlinType()}" }
            )
            .replace("#__return_type__#", callbackMethod.returnType.toKotlinType())
            .replace("#__caller_class_name__#", callerMethod.className)
            .replace("#__caller_method_name__#", callerMethod.name)
            .replace("#__callback_method__#", callbackMethod.name)
            .replaceParagraph(
                "#__callback_params__#",
                callbackMethod.formalParams.joinToString(",\n") {
                    "\"${it.name}\" to ${if (it.typeName.jsonable()) it.name else "${it.name}.hashCode()"}"
                }
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