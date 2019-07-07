package common.model

import Jar
import common.TYPE_NAME
import common.extensions.toDartType

/**
 * 表示一个变量(字段, 方法参数, 局部变量)
 */
data class Variable(val type: TYPE_NAME, val name: String) {
    fun toDartString(): String {
        // 如果变量类型是接口, 那么就需要展开
        return if (Jar.Decompiled.CLASSES[type]?.typeType == TypeType.Interface) {
            Jar.Decompiled
                .CLASSES[type]
                ?.methods
                ?.distinctBy { it.name }
                ?.joinToString(prefix = "{", postfix = ",}") { it.toDartString() } ?: ""
        }
        // 普通变量
        else {
            "${type.toDartType()} $name"
        }
    }
}