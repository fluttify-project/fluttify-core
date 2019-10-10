package me.yohom.fluttify.extensions

import me.yohom.fluttify.model.Parameter
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.Variable
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
 * 是否是静态类, 需要构造器中的信息, 如果不是静态内部类的话, 构造器的第一个参数是外部类
 */
fun JavaParser.ConstructorDeclarationContext.isStaticType(): Boolean {
    val simpleClassName = IDENTIFIER()?.text ?: ""
    // 因为构造器和类同名, 所以构造器的名称也可以拿来判断是否是内部类
    val isInnerClass = simpleClassName.contains("$")

    // 如果不是内部类, 那么一定是静态类
    return if (!isInnerClass) {
        true
    } else {
        val outerClass = simpleClassName.split("$")[0]
        // 如果是内部类, 判断构造器第一个参数是否是外部类类型, 如果是, 那么说明就是非静态类
        return formalParams()
            .firstOrNull()
            ?.run { outerClass != variable.typeName.simpleName() } == true
    }
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
                        formalParam.typeType().text.genericLevel(),
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
                        typeType().text.genericLevel(),
                        Platform.Android
                    ),
                    platform = Platform.Android
                )
            )
        }

    return result
}

