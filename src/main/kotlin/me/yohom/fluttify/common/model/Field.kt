package me.yohom.fluttify.common.model

import me.yohom.fluttify.common.extensions.toUnderscore
import me.yohom.fluttify.common.extensions.depointer

data class Field(
    val isPublic: Boolean?,
    val isFinal: Boolean?,
    val isStatic: Boolean?,
    val variable: Variable?,
    val className: String
) {
    fun nativeHandleGetterMethod(): String {
        return "handle${className.toUnderscore()}_get_${variable!!.name.depointer()}"
    }

    fun nativeHandleSetterMethod(): String {
        return "handle${className.toUnderscore()}_set_${variable!!.name.depointer()}"
    }

    fun dartGetterMethod(): String {
        return "$className::get_${variable!!.name}"
    }

    fun dartSetterMethod(): String {
        return "$className::set_${variable!!.name}"
    }
}