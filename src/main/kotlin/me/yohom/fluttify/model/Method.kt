package me.yohom.fluttify.model

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
    var className: String,

    override var platform: Platform,

    /**
     * 是否过时
     */
    var isDeprecated: Boolean = false
) : IPlatform, IScope {
    @Deprecated("不再使用方法引用的方式, 而是使用匿名函数的方式放到handlerMap中去", ReplaceWith("methodName"))
    fun handleMethodName(): String {
        return "handle${className.toDartType()}_$name"
    }

    fun nameWithClass(): String {
        return "${className}::$name${formalParams.joinToString("") { it.named }.capitalize()}"
    }

    override fun toString(): String {
        return "Method(returnType='$returnType', name='$name', formalParams=$formalParams, isStatic=$isStatic, isAbstract=$isAbstract, isPublic=$isPublic, className='$className')"
    }
}