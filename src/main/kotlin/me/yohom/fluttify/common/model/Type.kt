package me.yohom.fluttify.common.model

import me.yohom.fluttify.common.TYPE_NAME
import me.yohom.fluttify.common.extensions.isList
import me.yohom.fluttify.common.extensions.isObfuscated
import me.yohom.fluttify.common.extensions.jsonable
import me.yohom.fluttify.common.extensions.toDartType

open class Type {
    /**
     * 全名
     */
    var name: String = ""

    /**
     * 泛型类型
     */
    var genericTypes: MutableList<TYPE_NAME> = mutableListOf()

    /**
     * 类/接口/枚举/lambda
     */
    var typeType: TypeType? = null

    /**
     * 是否公开
     */
    var isPublic: Boolean = true

    /**
     * 是否是内部类
     */
    var isInnerClass: Boolean = true

    /**
     * 是否primitive
     */
    var isPrimitive: Boolean = false

    /**
     * 父类全名
     */
    var superClass: String = ""

    /**
     * 所有的构造器
     */
    var constructors: MutableList<Constructor> = mutableListOf()

    /**
     * 所有的字段
     */
    var fields: MutableList<Field> = mutableListOf()

    /**
     * 所有的方法
     */
    var methods: MutableList<Method> = mutableListOf()

    /**
     * 枚举值 枚举专用
     */
    var constants: MutableList<String> = mutableListOf()

    /**
     * 返回值类型 Lambda专用
     */
    var returnType: String = ""

    /**
     * 形参 Lambda专用
     */
    var formalParam: MutableList<Variable> = mutableListOf()

    fun isCallback(): Boolean {
        return typeType == TypeType.Interface
                && methods.all { it.returnType in listOf("void", "Boolean") }
                && superClass.isEmpty()
    }

    fun isEnum(): Boolean {
        return typeType == TypeType.Enum
    }

    fun isInterface(): Boolean {
        return typeType == TypeType.Interface
    }

    fun isList(): Boolean {
        return name.isList()
    }

    fun jsonable(): Boolean {
        return name.jsonable()
    }

    fun toDartType(): String {
        return name.toDartType()
    }

    fun isObfuscated(): Boolean {
        return name.isObfuscated()
    }

    fun isView(): Boolean {
        return superClass in listOf("android.view.View", "android.view.ViewGroup", "android.widget.FrameLayout")
    }

    fun nameWithGeneric(): String {
        return if (genericTypes.isEmpty()) name else "$name<${genericTypes.joinToString()}>"
    }

    override fun toString(): String {
        return "Type(name='$name', genericTypes=$genericTypes, typeType=$typeType, isPublic=$isPublic, isInnerClass=$isInnerClass, isPrimitive=$isPrimitive, superClass='$superClass', constructors=$constructors, fields=$fields, methods=$methods, constants=$constants, returnType='$returnType', formalParam=$formalParam)"
    }

    companion object {
        val UNKNOWN_TYPE: Type = Type().apply { name = "unknown" }
    }
}

enum class TypeType {
    Class, Enum, Interface, Lambda
}