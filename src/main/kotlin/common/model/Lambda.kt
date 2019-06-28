package common.model

import common.TYPE_NAME

/**
 * lambda表达式模型
 */
data class Lambda(val returnType: TYPE_NAME, val methodName: String, val formalParams: List<Variable>) {
    override fun toString(): String {
        return "$returnType $methodName(${formalParams.joinToString()})"
    }
}