package me.yohom.fluttify.model

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.jsonable
import me.yohom.fluttify.extensions.toDartType

/**
 * 表示一个变量(字段, 方法参数, 局部变量)
 */
data class Variable(
    val typeName: TYPE_NAME,
    val name: String,
    val isList: Boolean = false,
    val genericLevel: Int = 0,
    override var platform: Platform
) : PlatformAware {
    fun isStructPointer(): Boolean {
        return typeName.findType().isStruct() && (typeName.endsWith("*") || name.startsWith("*"))
    }

    fun isStruct(): Boolean {
        return typeName.findType().isStruct()
    }

    fun isEnum(): Boolean {
        return typeName.findType().isEnum()
    }

    fun jsonable(): Boolean {
        return typeName.jsonable()
    }

    fun isLambda(): Boolean {
        return typeName.findType().isLambda()
    }

    fun isCallback(): Boolean {
        return typeName.findType().isCallback()
    }

    fun isInterface(): Boolean {
        return typeName.findType().isInterface()
    }

    fun isAbstract(): Boolean {
        return typeName.findType().isAbstract
    }

    fun isConcret(): Boolean {
        return !isAbstract()
    }

    fun isRefType(): Boolean {
        return typeName.findType().isRefType()
    }

    fun isUnknownType(): Boolean {
        return typeName.findType() == Type.UNKNOWN_TYPE
    }

    fun isKnownType(): Boolean {
        return typeName.findType() != Type.UNKNOWN_TYPE
    }

    fun isPublicType(): Boolean {
        return typeName.findType().isPublic
    }

    fun toDartString(): String {
        return if (typeName.findType().isLambda()) {
            val type = typeName.findType()
            "${type.returnType} ${name}(${type.formalParams.joinToString { it.variable.toDartString() }})"
        } else {
            // 结构体指针认为是列表类型
            val isListType = isList || isStructPointer()
            var type = typeName.toDartType()
            if (isListType) {
                // 根据List嵌套层次生成类型
                for (i in 0 until genericLevel) {
                    type = "List<$type>"
                }
            }
            "$type ${name.depointer()}"
        }
    }
}
