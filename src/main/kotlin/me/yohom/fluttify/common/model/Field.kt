package me.yohom.fluttify.common.model

import me.yohom.fluttify.common.extensions.depointer
import me.yohom.fluttify.common.extensions.toUnderscore

data class Field(
    /**
     * 是否公开
     */
    val isPublic: Boolean?,
    /**
     * 是否只读
     */
    val isFinal: Boolean?,
    /**
     * 是否静态
     */
    val isStatic: Boolean?,
    /**
     * 变量
     */
    val variable: Variable,
    /**
     * 所在类名
     */
    val className: String,
    /**
     * getter
     */
    val getterName: String = variable.name,
    /**
     * setter
     */
    val setterName: String = variable.name,
    /**
     * 所属平台
     */
    override var platform: Platform,
    /**
     * 是否过时
     */
    var isDeprecated: Boolean = false
) : PlatformAware {
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