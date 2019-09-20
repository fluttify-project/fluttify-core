package me.yohom.fluttify.common.extensions

import me.yohom.fluttify.common.model.Parameter
import me.yohom.fluttify.common.model.Platform
import me.yohom.fluttify.common.model.Variable
import parser.java.JavaParser

/**
 * 是否是公有构造器
 */
fun JavaParser.ConstructorDeclarationContext.isPublic(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("public") ?: false
}

/**
 * 是否是无参构造器
 */
fun JavaParser.ConstructorDeclarationContext.hasDependency(): Boolean {
    return formalParameters().formalParameterList() != null
}

/**
 * 是否是无参构造器
 */
fun JavaParser.ConstructorDeclarationContext.formalParams(): List<Parameter> {
    val result = mutableListOf<Parameter>()

    val parameters = formalParameters().formalParameterList()

    // 除最后一个参数之外的参数
    parameters
        ?.formalParameter()
        ?.forEach { formalParam ->
            val paramType = formalParam.typeType().text.genericType()
            val typeFullName = typeFullName(paramType)
            result.add(
                Parameter(
                    variable = Variable(
                        typeFullName,
                        formalParam.variableDeclaratorId().text,
                        formalParam.typeType().text.isList(),
                        Platform.Android
                    ),
                    platform = Platform.Android
                )
            )
        }

    // 最后一个参数
    parameters
        ?.lastFormalParameter()
        ?.run {
            val paramType = typeType().text.genericType()
            val typeFullName = typeFullName(paramType)
            result.add(
                Parameter(
                    variable = Variable(
                        typeFullName,
                        variableDeclaratorId().text,
                        paramType.isList(),
                        Platform.Android
                    )
                    ,
                    platform = Platform.Android
                )
            )
        }

    return result
}

