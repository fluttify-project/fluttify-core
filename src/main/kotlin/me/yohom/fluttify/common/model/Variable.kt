package me.yohom.fluttify.common.model

import me.yohom.fluttify.common.TYPE_NAME
import me.yohom.fluttify.common.extensions.depointer
import me.yohom.fluttify.common.extensions.toDartType

/**
 * 表示一个变量(字段, 方法参数, 局部变量)
 */
data class Variable(
    val typeName: TYPE_NAME,
    val name: String,
    val isList: Boolean = false,
    override var platform: Platform
) : PlatformAware {
    fun toDartString(): String {
        return "${typeName.toDartType()} ${name.depointer()}"
    }
}
