package me.yohom.fluttify.common.model

import me.yohom.fluttify.common.TYPE_NAME
import me.yohom.fluttify.common.extensions.findType
import me.yohom.fluttify.common.extensions.toDartType

/**
 * 表示一个变量(字段, 方法参数, 局部变量)
 */
data class Variable(
    val typeName: TYPE_NAME,
    val name: String,
    val isList: Boolean = false
) {
    fun toDartString(): String {
        return if (typeName.findType().isCallback()) {
            val type = typeName.findType()
            type.methods
                .filter { it.formalParams.none { it.typeName.findType() == Type.UNKNOWN_TYPE } }
                .joinToString { "void ${it.name}(${it.formalParams.joinToString { it.toDartString() }})" }
        } else {
            "${typeName.toDartType()} $name"
        }
    }
}
