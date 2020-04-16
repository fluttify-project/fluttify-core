package me.yohom.fluttify.model

import me.yohom.fluttify.NEXT_ID
import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.CallbackTmpl

/**
 * 表示一个变量(字段, 方法参数, 局部变量)
 */
data class Variable(
    private val typeName: TYPE_NAME,
    val name: String,
    override var platform: Platform,
    override var id: Int = NEXT_ID
) : IPlatform, IElement {

    val isIterable: Boolean
        get() = typeName.isIterable()

    /**
     * 如果类型由被手动override的话, 这里需要使用override之后的类
     */
    val trueType: String
        get() = ext.ios.overrideElements[id]?.fromJson<Variable>()?.typeName ?: typeName

    fun isStructPointer(): Boolean {
        return trueType.isStructPointer()
    }

    fun isValuePointerType(): Boolean {
        return trueType.isPrimitivePointerType()
    }

    fun isStruct(): Boolean {
        return trueType.findType().isStruct()
    }

    fun isEnum(): Boolean {
        return trueType.findType().isEnum()
    }

    fun jsonable(): Boolean {
        return trueType.jsonable()
    }

    fun isAliasType(): Boolean {
        return trueType.findType().isAlias()
    }

    fun isValueType(): Boolean {
        return trueType.isValueType()
    }

    fun isLambda(): Boolean {
        return trueType.findType().isLambda()
    }

    fun isCallback(): Boolean {
        return trueType.containerType().findType().isCallback() || trueType.deprotocol().findType().isCallback()
    }

    fun isInterface(): Boolean {
        return trueType.containerType().findType().isInterface()
    }

    fun isAbstract(): Boolean {
        return trueType.containerType().findType().isAbstract
    }

    fun isConcret(): Boolean {
        return !isAbstract()
    }

    fun hasConcretSubtype(): Boolean {
        return trueType.findType().firstConcretSubtype() != null
    }

    fun isKnownType(): Boolean {
        return trueType.containerType().run { isIterable() || isMap() || findType().platform != Platform.Unknown }
                && trueType.genericTypes().all { it.findType().platform != Platform.Unknown }
                || trueType.jsonable()
    }

    fun isPublicType(): Boolean {
        return trueType.findType().isPublic
    }

    fun isGenericType(): Boolean {
        return trueType.findType().genericTypes.isNotEmpty()
    }

    fun containerType(): Type {
        return trueType.containerType().findType()
    }

    fun genericTypes(): List<Type> {
        return trueType.genericTypes().map { it.findType() }
    }

    fun allTypes(): List<Type> {
        return trueType.allTypes()
    }

    fun objcType(): String {
        return when (trueType) {
            "constvoid*" -> "const void*"
            else -> trueType.removeObjcSpecifier() // 要先去除一下objc里的限定词
        }
    }

    fun getIterableLevel(): Int {
        return trueType.iterableLevel()
    }

    fun toDartString(): String {
        return if (trueType.findType().isLambda()) {
            val type = trueType.findType()
            "${type.returnType} ${name}(${type.formalParams.joinToString { it.variable.toDartString() }})"
        } else {
            "${trueType.toDartType()} $name"
        }
    }

    fun toDartStringBatch(): String {
        return "List<${trueType.toDartType()}> $name"
    }

    fun var2Args(hostMethod: Method? = null): String {
        return if (trueType.findType().isCallback() && hostMethod != null) {
            when {
                isIterable -> "new ArrayList() /* 暂不支持列表回调 */"
                containerType().methods.any { it.isGenericMethod } -> "null /* 暂不支持含有泛型方法的类 */"
                else -> CallbackTmpl(hostMethod, trueType.findType())
            }
        } else {
            when {
                // 字符串数组需要转换
                isStringArray() -> "$name.toArray(new ${trueType.dearray()}[$name.size()])"
                // 基本类型数组不需要转换, 直接使用
                isArray() -> name
                // 自定义类列表需要转换成ArrayList
                isIterable -> "(ArrayList) $name"
                trueType.toLowerCase() == "float" -> "new Double(${name}).floatValue()"
                else -> name
            }
        }
    }

    fun isStringArray(): Boolean = trueType.isStringArray()

    fun isArray(): Boolean = trueType.isArray()

    fun isCollection(): Boolean = trueType.isIterable()

    /**
     * 是否是Lambda以及组成部分是否都是已知元素
     */
    fun isKnownLambda(): Boolean {
        return if (!isLambda()) {
            false
        } else {
            trueType.findType().formalParams.all { it.variable.isKnownType() }
        }
    }
}