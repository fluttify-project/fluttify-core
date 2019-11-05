package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_return

import me.yohom.fluttify.extensions.toKotlinType
import me.yohom.fluttify.model.Method

class CallbackReturnTmpl(private val method: Method) {
    fun kotlinCallbackReturn(): String {
        return when (method.returnType.toKotlinType()) {
            "Boolean" -> "return true;"
            "Int" -> "return 0;"
            "Float" -> "return 0f;"
            "Double" -> "return 0.0;"
            "Unit" -> ""
            else -> "return null;"
        }
    }
}