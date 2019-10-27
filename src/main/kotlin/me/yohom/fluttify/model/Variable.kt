package me.yohom.fluttify.model

import me.yohom.fluttify.SYSTEM_TYPE
import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.*

/**
 * 表示一个变量(字段, 方法参数, 局部变量)
 */
data class Variable(
    val typeName: TYPE_NAME,
    val name: String,
    val isList: Boolean = false,
    val genericLevel: Int = 0,
    override var platform: Platform
) : IPlatform {
    fun constructable(): Boolean {
        return typeName.findType().constructable() || isList
    }

    fun isPlatformType(): Boolean {
        return typeName in SYSTEM_TYPE.map { it.name }
    }

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

    fun isAliasType(): Boolean {
        return typeName.findType().isAlias()
    }

    fun isCType(): Boolean {
        return typeName.isCType()
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

    fun hasConcretSubtype(): Boolean {
        return typeName.findType().firstConcretSubtype() != null
    }

    fun hasSubtype(): Boolean {
        return typeName.findType().hasSubtype()
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

    fun isGenericType(): Boolean {
        return typeName.findType().genericTypes.isNotEmpty()
    }

    fun paramType(): String {
        return when {
            typeName == "id" -> "id"
            isEnum() or isCType() or isAliasType() -> typeName
            isInterface() -> typeName.enprotocol()
            isList && genericLevel > 0 -> "NSArray<$typeName>*"
            else -> typeName.enpointer()
        }
    }

    fun toDartString(): String {
        return if (typeName.findType().isLambda()) {
            val type = typeName.findType()
            "${type.returnType} ${name}(${type.formalParams.joinToString { it.variable.toDartString() }})"
        } else {
            // 结构体指针认为是列表类型
            var type = (if (isAliasType()) typeName.findType().aliasOf!! else typeName).toDartType()
            if (isList) {
                // 如果是列表, 却没有指定泛型, 那么就认为泛型是Object
                if (genericLevel == 0) {
                    type = "List<${platform.objectType()}>"
                } else {
                    // 根据List嵌套层次生成类型
                    for (i in 0 until genericLevel) {
                        type = "List<$type>"
                    }
                }
            } else if (isStructPointer()) {
                type = "List<$type>"
            }
            "$type ${name.depointer()}"
        }
    }
}
