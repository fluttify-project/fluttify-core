package me.yohom.fluttify.common.model

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

    override fun toString(): String {
        return "Type(name='$name', typeType=$typeType, isPublic=$isPublic, superClass='$superClass', fields=$fields, methods=$methods, constants=$constants, returnType='$returnType', formalParam=$formalParam)"
    }
}

enum class TypeType {
    Class, Enum, Interface, Lambda
}