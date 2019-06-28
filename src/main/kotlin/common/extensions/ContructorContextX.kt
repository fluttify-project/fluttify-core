package common.extensions

import common.model.Variable
import parser.java.JavaParser

/**
 * 判断构造器是否含有非jsonable的参数
 */
fun JavaParser.ConstructorDeclarationContext.hasNonJsonableParameter(): Boolean {
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

    return result.any { !it.type.jsonable() }
}

/**
 * 是否是公有构造器
 */
fun JavaParser.ConstructorDeclarationContext.isPublic(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("public") ?: false
}