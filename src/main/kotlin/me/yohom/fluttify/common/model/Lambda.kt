package me.yohom.fluttify.common.model

import me.yohom.fluttify.common.TYPE_NAME

/**
 * lambda表达式模型
 */
data class Lambda(val returnType: TYPE_NAME, val methodName: String, val formalParams: List<Variable>) {
    override fun toString(): String {
        // 返回类型统一使用void好了, 这样可以利用协程
        return "void $methodName(${formalParams.joinToString()})"
    }
}