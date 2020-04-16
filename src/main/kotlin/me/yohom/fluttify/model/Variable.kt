package me.yohom.fluttify.model

import me.yohom.fluttify.NEXT_ID
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
    override var id: Int = NEXT_ID
) : IPlatform, IElement {

    val isIterable: Boolean
        get() = typeName.isIterable()

    fun isStructPointer(): Boolean {
        return typeName.isStructPointer()
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
        return typeName.containerType().findType().isCallback() || typeName.deprotocol().findType().isCallback()
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
                || typeName.jsonable()
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
        return when (typeName) {
            "constvoid*" -> "const void*"
            else -> typeName.removeObjcSpecifier() // 要先去除一下objc里的限定词
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
            "${typeName.toDartType()} $name"
        }
    }

    fun toDartStringBatch(): String {
        return "List<${typeName.toDartType()}> $name"
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