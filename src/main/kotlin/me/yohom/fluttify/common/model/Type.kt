package me.yohom.fluttify.common.model

open class Type {
    /**
     * 类/接口/枚举/lambda
     */
    var typeType: TypeType? = null

    /**
     * 全名
     */
    var name: String = ""

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
    val fields: MutableList<Field> = mutableListOf()

    /**
     * 所有的方法
     */
    val methods: MutableList<Method> = mutableListOf()

    /**
     * 枚举值 枚举专用
     */
    val constants: MutableList<String> = mutableListOf()

    /**
     * 返回值类型 Lambda专用
     */
    var returnType: String = ""

    /**
     * 形参 Lambda专用
     */
    val formalParam: MutableList<Variable> = mutableListOf()
}

enum class TypeType {
    Class, Enum, Interface, Lambda
}