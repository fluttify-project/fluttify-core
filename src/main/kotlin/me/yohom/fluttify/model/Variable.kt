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
    private var typeName: TYPE_NAME,
    val name: String,
    override var platform: Platform,
    override var id: Int = NEXT_ID
) : IPlatform, IElement {

    val isIterable: Boolean
        get() = typeName.isIterable()

    val trueType: String
        get() {
            val origin = typeName.findType().name
            val alias = typeName.findType().aliasOf
            return alias?.run { typeName.replace(origin, this) }
                ?: typeName.objcSpecifierExpand()
        }

    val rawType: String
        get() = typeName

    fun defineGenericType(definedTypeName: TYPE_NAME): Variable {
        typeName = definedTypeName
        return this
    }

    fun isStructPointer(): Boolean {
        return trueType.isStructPointer()
    }

    fun isValuePointerType(): Boolean {
        return trueType.isPrimitivePointerType()
    }

    fun isStruct(): Boolean {
        return trueType.findType().isStruct
    }

    fun isEnum(): Boolean {
        return trueType.findType().isEnum
    }

    fun jsonable(): Boolean {
        return trueType.jsonable()
    }

    fun isVoid(): Boolean {
        return trueType.isVoid()
    }

    fun isAliasType(): Boolean {
        return trueType.findType().isAlias()
    }

    fun isDynamic(): Boolean {
        return trueType.toDartType().isDynamic()
    }

    fun isValueType(): Boolean {
        return trueType.isValueType()
    }

    fun isLambda(): Boolean {
        return trueType.findType().isLambda
    }

    fun isCallback(): Boolean {
        return trueType.containerType().findType().isCallback || trueType.deprotocol().findType().isCallback
    }

    fun isInterface(): Boolean {
        return trueType.containerType().findType().isInterface
    }

    fun isAbstract(): Boolean {
        return trueType.allTypes().any { it.isAbstract }
    }

    fun isConcret(): Boolean {
        return !isAbstract()
    }

    fun hasConcretSubtype(): Boolean {
        // TODO 这里可能要考虑一下泛型的情况
        return trueType.findType().firstConcretSubtype != null
    }

    fun isKnownType(): Boolean {
        // 只有当类型不是Map且包含类型都是已知类, 碰到了Map<String,NSData>类型, 虽然所有成分都是已知类, 但应该过滤掉的
        return (!trueType.isMap() && trueType.allTypes().all { it.isKnownType })
                || trueType.jsonable()
    }

    fun isPublicType(): Boolean {
        return trueType.findType().isPublic
    }

    fun isGenericType(): Boolean {
        return trueType.findType().declaredGenericTypes.isNotEmpty()
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
        return trueType.objcSpecifierExpand()
    }

    fun getIterableLevel(): Int {
        return trueType.iterableLevel()
    }

    fun toDartString(): String {
        return if (trueType.findType().isLambda) {
            val type = trueType.findType()
            "${type.returnType.toDartType()} ${name}(${type.formalParams.joinToString { it.variable.toDartString() }})"
        } else {
            "${trueType.toDartType()} ${name.removeObjcSpecifier()}"
        }
    }

    fun toDartStringBatch(): String {
        return "List<${trueType.toDartType()}> $name"
    }

    fun var2Args(hostMethod: Method? = null): String {
        return if (trueType.findType().isCallback && hostMethod != null) {
            when {
                isIterable -> "new ArrayList() /* 暂不支持列表回调 */"
                containerType().methods.any { it.isGenericMethod } -> "null /* 暂不支持含有泛型方法的类 */"
                else -> CallbackTmpl(hostMethod, trueType.findType())
            }
        } else {
            when (trueType) {
                "float", "Float" -> "${name}.floatValue()"
                "double", "Double" -> "${name}.doubleValue()"
                "int", "Integer" -> "${name}.intValue()"
                "long", "Long" -> "${name}.longValue()"
                else -> name
            }
        }
    }

    fun isStringArray(): Boolean = trueType.isStringArray()

    fun isRefArray(): Boolean = trueType.isRefArray()

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