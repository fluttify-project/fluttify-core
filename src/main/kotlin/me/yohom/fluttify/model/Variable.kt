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
    @Deprecated("不再使用")
    val listType: ListType = ListType.NonList,
    @Deprecated("不再使用")
    val genericLevel: Int = 0
) : IPlatform {

    val isIterable: Boolean
        get() = typeName.isIterable()

    fun isStructPointer(): Boolean {
        return typeName.findType().isStruct() && (typeName.endsWith("*") || name.startsWith("*"))
    }

    fun isValuePointerType(): Boolean {
        return typeName.isPrimitivePointerType()
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
        return typeName.containerType().findType().isCallback()
    }

    fun isInterface(): Boolean {
        return typeName.containerType().findType().isInterface()
    }

    fun isAbstract(): Boolean {
        return typeName.containerType().findType().isAbstract
    }

    fun isConcret(): Boolean {
        return !isAbstract()
    }

    fun hasConcretSubtype(): Boolean {
        return typeName.findType().firstConcretSubtype() != null
    }

    fun isKnownType(): Boolean {
        return typeName.containerType().run { isIterable() || isMap() || findType().platform != Platform.Unknown }
                && typeName.genericTypes().all { it.findType().platform != Platform.Unknown }
    }

    fun isPublicType(): Boolean {
        return typeName.findType().isPublic
    }

    fun isGenericType(): Boolean {
        return typeName.findType().genericTypes.isNotEmpty()
    }

    fun containerType(): Type {
        return typeName.containerType().findType()
    }

    fun genericTypes(): List<Type> {
        return typeName.genericTypes().map { it.findType() }
    }

    fun allTypes(): List<Type> {
        return typeName.allTypes()
    }

    fun objcType(): String {
        return when {
            typeName == "id" -> "id"
            typeName == "constvoid*" -> "const void*"
            isValueType() or isStruct() -> typeName
            isInterface() -> typeName.enprotocol()
            isIterable && genericLevel > 0 -> "NSArray<$typeName>*"
            else -> typeName.removeObjcSpecifier().enpointer() // 要先去除一下objc里的限定词
        }
    }

    fun getIterableLevel(): Int {
        return typeName.iterableLevel()
    }

    fun toDartString(): String {
        return if (typeName.findType().isLambda()) {
            val type = typeName.findType()
            "${type.returnType} ${name}(${type.formalParams.joinToString { it.variable.toDartString() }})"
        } else {
            // 结构体指针认为是列表类型
            var type = (if (isAliasType()) typeName.findType().aliasOf!! else typeName).toDartType()
            if (isIterable) {
                when {
                    // 数组类型
                    typeName.isArray() -> typeName.removeSuffix("[]")
                    // 如果是列表, 却没有指定泛型, 那么就认为泛型是Object
                    getIterableLevel() == 0 -> type = "List<${platform.objectType()}>"
                }
            } else if (isStructPointer()) {
                type = "List<$type>"
            }
            "$type $name"
        }
    }

    fun toDartStringBatch(): String {
        // 结构体指针认为是列表类型
        var type = (if (isAliasType()) typeName.findType().aliasOf!! else typeName).toDartType()
        if (isIterable) {
            when {
                // 数组类型
                typeName.isArray() -> typeName.removeSuffix("[]")
                // 如果是列表, 却没有指定泛型, 那么就认为泛型是Object
                getIterableLevel() == 0 -> type = "List<${platform.objectType()}>"
            }
        } else if (isStructPointer()) {
            type = "List<$type>"
        }
        return "${type.enList()} ${name.depointer()}"
    }

    fun var2Args(hostMethod: Method? = null): String {
        return if (typeName.findType().isCallback() && hostMethod != null) {
            when {
                isIterable -> "new ArrayList() /* 暂不支持列表回调 */"
                containerType().methods.any { it.isGenericMethod } -> "null /* 暂不支持含有泛型方法的类 */"
                else -> CallbackTmpl(hostMethod, typeName.findType())
            }
        } else {
            when {
                // 字符串数组需要转换
                isStringArray() -> "$name.toArray(new ${typeName.dearray()}[$name.size()])"
                // 基本类型数组不需要转换, 直接使用
                isArray() -> name
                // 自定义类列表需要转换成ArrayList
                isIterable -> "(ArrayList) $name"
                typeName.toLowerCase() == "float" -> "new Double(${name}).floatValue()"
                else -> name
            }
        }
    }

    fun isStringArray(): Boolean = typeName.isStringArray()

    fun isArray(): Boolean = typeName.isArray()

    fun isCollection(): Boolean = typeName.isIterable()

    /**
     * 是否是Lambda以及组成部分是否都是已知元素
     */
    fun isKnownLambda(): Boolean {
        return if (!isLambda()) {
            false
        } else {
            typeName.findType().formalParams.all { it.variable.isKnownType() }
        }
    }
}

@Deprecated("不再使用")
enum class ListType {
    Array, List, ArrayList, LinkedList, NonList,
}