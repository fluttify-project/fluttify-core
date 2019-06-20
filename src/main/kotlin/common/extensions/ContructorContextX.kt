package common.extensions

import common.model.Variable
import parser.java.JavaParser

/**
 * 判断构造器是否含有非jsonable的参数
 */
fun JavaParser.ConstructorDeclarationContext?.hasNonJsonableParameter(): Boolean {
    if (this == null) return false
    val result = mutableListOf<Variable>()

    val parameters = this.formalParameters().formalParameterList()

    // 除最后一个参数之外的参数
    parameters
        ?.formalParameter()
        ?.forEach {
            result.add(Variable(it.typeType().text.toDartType(), it.variableDeclaratorId().text))
        }

    // 最后一个参数
    parameters
        ?.lastFormalParameter()
        ?.run {
            result.add(Variable(typeType().text.toDartType(), variableDeclaratorId().text))
        }

    return result.any { !it.jsonable() }
}