package me.yohom.fluttify.common.model

import me.yohom.fluttify.common.extensions.toDartType

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
    var formalParams: List<Variable>,
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
    var isPublic: Boolean?,
    /**
     * 所在类名称
     */
    var className: String
) {
    fun kotlinHandleMethod(): String {
        return "handle${className.toDartType()}_$name"
    }

    override fun toString(): String {
        return "Method(returnType='$returnType', name='$name', formalParams=$formalParams, isStatic=$isStatic, isAbstract=$isAbstract, isPublic=$isPublic)"
    }
}