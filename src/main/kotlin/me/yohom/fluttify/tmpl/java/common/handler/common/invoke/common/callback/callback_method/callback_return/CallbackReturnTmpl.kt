package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_return

import me.yohom.fluttify.model.Method

fun CallbackReturnTmpl(method: Method): String {
    return when (method.returnType) {
        "boolean" -> "return true;"
        "int" -> "return 0;"
        "long" -> "return 0L;"
        "float" -> "return 0f;"
        "double" -> "return 0.0;"
        "void" -> ""
        else -> "return null;"
    }
}