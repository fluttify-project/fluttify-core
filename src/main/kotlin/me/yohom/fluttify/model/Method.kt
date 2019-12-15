package me.yohom.fluttify.model

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.joinToStringX
import me.yohom.fluttify.extensions.toDartType

data class Method(
    /**
     * 方法返回类型
     */
    var returnType: String,
    /**
     * 方法名称
     */
    var name: String,
    /**
     * 形参
     */
    var formalParams: List<Parameter>,
    /**
     * 是否静态
     */
    var isStatic: Boolean,
    /**
     * 是否抽象
     */
    var isAbstract: Boolean?,
    /**
     * 是否公开
     */
    override var isPublic: Boolean,
    /**
     * 所在类名称
     */
    var className: TYPE_NAME,

    override var platform: Platform,

    /**
     * 是否过时
     */
    var isDeprecated: Boolean = false,
    /**
     * 是否是函数
     */
    var isFunction: Boolean = false
) : IPlatform, IScope {

    val exactName: String = "$name${formalParams.joinToString(":") { it.named }}"

    @Deprecated("不再使用方法引用的方式, 而是使用匿名函数的方式放到handlerMap中去", ReplaceWith("methodName"))
    fun handleMethodName(): String {
        return "handle${className.toDartType()}_$name"
    }

    fun nameWithClass(): String {
        return "${className.replace("$", ".")}::${signature()}"
    }

    /**
     * 包含方法名, 命名参数和参数类型的完整签名
     */
    fun signature(): String {
        return if (className.findType().methods.map { it.signatureNamed() }.filter { it == this.signatureNamed() }.size > 1) {
            // 类内部含有相同方法名超过1个, 说明有重载, 这里需要给方法名加上类型
            name + formalParams.joinToStringX("__", "__") { "${it.named}${it.variable.typeName.toDartType()}" }
        } else {
            signatureNamed()
        }
    }

    /**
     * 只包含方法名和命名参数部分的签名
     */
    fun signatureNamed(): String {
        return name + formalParams.joinToString("") { it.named }.capitalize()
    }

    override fun toString(): String {
        return "Method(returnType='$returnType', name='$name', formalParams=$formalParams, isStatic=$isStatic, isAbstract=$isAbstract, isPublic=$isPublic, className='$className', platform=$platform, isDeprecated=$isDeprecated)"
    }
}