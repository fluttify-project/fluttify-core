package me.yohom.fluttify.common.model

import me.yohom.fluttify.common.IGNORE_METHOD
import me.yohom.fluttify.common.extensions.findType
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
    fun isOk(): Boolean {
        return when {
            // 不能是忽略的方法
            name in IGNORE_METHOD -> false
            // 不能是非公开方法
            isPublic != true -> false
            // 所在类不能是非公开类
            !className.findType().isPublic -> false
            // 返回类型不能是混淆类
            returnType.findType().isObfuscated() -> false
            // 返回类型不能是未知类
            returnType.findType() == Type.UNKNOWN_TYPE -> false
            // 返回类型不能是接口
            returnType.findType().isInterface() -> false
            // 返回类型不能含有泛型
            returnType.findType().genericTypes.isNotEmpty() -> false
            // 形参类型必须全部都是公开类型
            !formalParams.all { it.typeName.findType().isPublic } -> false
            // 形参类型必须全部都不含有泛型
            !formalParams.all { it.typeName.findType().genericTypes.isEmpty() } -> false
            // 形参类型必须全部都不是未知类型
            !formalParams.all { it.typeName.findType() != Type.UNKNOWN_TYPE } -> false
            else -> true
        }
    }

    fun kotlinHandleMethod(): String {
        return "handle${className.toDartType()}_$name"
    }

    override fun toString(): String {
        return "Method(returnType='$returnType', name='$name', formalParams=$formalParams, isStatic=$isStatic, isAbstract=$isAbstract, isPublic=$isPublic)"
    }
}