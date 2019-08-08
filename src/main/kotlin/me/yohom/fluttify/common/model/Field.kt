package me.yohom.fluttify.common.model

import me.yohom.fluttify.common.extensions.depointer
import me.yohom.fluttify.common.extensions.toUnderscore

data class Field(
    val isPublic: Boolean?,
    val isFinal: Boolean?,
    val isStatic: Boolean?,
    val variable: Variable,
    val className: String,
    val getterName: String = variable.name,
    val setterName: String = variable.name
) {
    fun nativeHandleGetterMethodName(): String {
        return "handle${className.toUnderscore()}_get_${getterName.depointer()}"
    }

    fun nativeHandleSetterMethodName(): String {
        return "handle${className.toUnderscore()}_set_${setterName.depointer()}"
    }

    fun getterMethodName(): String {
        return "$className::get_${getterName.depointer()}"
    }

    fun setterMethodName(): String {
        return "$className::set_${setterName.depointer()}"
    }
}