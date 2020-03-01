package me.yohom.fluttify.model

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.CallbackTmpl

/**
 * 表示一个变量(字段, 方法参数, 局部变量)
 */
data class Variable(
    val typeName: TYPE_NAME,
    val name: String,
    override var platform: Platform,
    val listType: ListType = ListType.NonList,
    val genericLevel: Int = 0
) : IPlatform {

    val isList: Boolean
        get() = listType != ListType.NonList

    fun constructable(): Boolean {
        return typeName.findType().constructable()
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

    fun isValueType(): Boolean {
        return typeName.isValueType()
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

    fun type(): Type {
        return typeName.findType()
    }

// TODO 重命名为objcType
    fun paramType(): String {
        return when {
            typeName == "id" -> "id"
            typeName == "constvoid*" -> "const void*"
            isValueType() or isStruct() -> typeName
            isInterface() -> typeName.enprotocol()
            isList && genericLevel > 0 -> "NSArray<$typeName>*"
            else -> typeName.removeObjcSpecifier().enpointer() // 要先去除一下objc里的限定词
        }
    }
//
//    fun dartType(): String {
//        return when {
//            isMap() -> typeName.split(",").joinToString(",") { it.toDartType() }.enMap()
//            isList -> typeName.toDartType().enList()
//            else -> typeName.toDartType()
//        }
//    }

    fun toDartString(): String {
        return if (typeName.findType().isLambda()) {
            val type = typeName.findType()
            "${type.returnType} ${name}(${type.formalParams.joinToString { it.variable.toDartString() }})"
        } else {
            // 结构体指针认为是列表类型
            var type = (if (isAliasType()) typeName.findType().aliasOf!! else typeName).toDartType()
            if (isList) {
                when {
                    // 数组类型
                    typeName.isArray() -> typeName.removeSuffix("[]")
                    // 如果是列表, 却没有指定泛型, 那么就认为泛型是Object
                    genericLevel == 0 -> type = "List<${platform.objectType()}>"
                    // 根据List嵌套层次生成类型
                    else -> for (i in 0 until genericLevel) type = "List<$type>"
                }
            } else if (isStructPointer()) {
                type = "List<$type>"
            }
            "$type ${name.depointer()}"
        }
    }

    fun toDartStringBatch(): String {
        // 结构体指针认为是列表类型
        var type = (if (isAliasType()) typeName.findType().aliasOf!! else typeName).toDartType()
        if (isList) {
            when {
                // 数组类型
                typeName.isArray() -> typeName.removeSuffix("[]")
                // 如果是列表, 却没有指定泛型, 那么就认为泛型是Object
                genericLevel == 0 -> type = "List<${platform.objectType()}>"
                // 根据List嵌套层次生成类型
                else -> for (i in 0 until genericLevel) type = "List<$type>"
            }
        } else if (isStructPointer()) {
            type = "List<$type>"
        }
        return "${type.enList()} ${name.depointer()}"
    }

    fun var2Args(hostMethod: Method? = null): String {
        return if (typeName.findType().isCallback() && hostMethod != null) {
            CallbackTmpl(hostMethod, typeName.findType())
        } else {
            when {
                isList -> when {
                    // 字符串数组需要转换
                    isStringArray() -> "$name.toArray(new ${typeName.dearray()}[$name.size()])"
                    // 基本类型数组不需要转换, 直接使用
                    isArray() -> name
                    // 自定义类列表需要转换成ArrayList
                    else -> "new ArrayList($name)"
                }
                typeName.toLowerCase() == "float" -> "new Double(${name}).floatValue()"
                else -> name
            }
        }
    }

    fun isStringArray(): Boolean = typeName.isStringArray()

    fun isArray(): Boolean = typeName.isArray()

    fun isCollection(): Boolean = typeName.isCollection()

    fun isMap(): Boolean = typeName.isMap()

    /**
     * 是否是Lambda以及组成部分是否都是已知元素
     */
    fun isKnownLambda(): Boolean {
        return if (!isLambda()) {
            false
        } else {
            type().formalParams.all { it.variable.type().isKnownType() }
        }
    }
}

enum class ListType {
    Array, List, ArrayList, LinkedList, NonList,
}