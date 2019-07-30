package me.yohom.fluttify.common.model

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
     * 类/接口/枚举/lambda
     */
    var typeType: TypeType? = null

    /**
     * 是否公开
     */
    var isPublic: Boolean = false

    /**
     * 是否primitive
     */
    var isPrimitive: Boolean = false

    /**
     * 父类全名
     */
    var superClass: String = ""

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
    }

    fun isEnum(): Boolean {
        return typeType == TypeType.Enum
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
        return superClass in listOf("android.view.View", "android.view.ViewGroup")
    }

    override fun toString(): String {
        return "Type(name='$name', typeType=$typeType, isPublic=$isPublic, superClass='$superClass', fields=$fields, methods=$methods, constants=$constants, returnType='$returnType', formalParam=$formalParam)"
    }

    companion object {
        val UNKNOWN_TYPE: Type = Type().apply { name = "unknown" }
    }
}

enum class TypeType {
    Class, Enum, Interface, Lambda
}