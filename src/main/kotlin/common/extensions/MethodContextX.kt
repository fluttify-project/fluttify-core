package common.extensions

import common.model.Method
import common.model.Variable
import parser.java8.Java8Parser
import parser.objc.ObjectiveCParser

//region Java Method
fun Java8Parser.MethodDeclarationContext?.method(): Method? {
    if (this == null) return null
    return Method(
        returnType() ?: return null,
        name() ?: return null,
        formalParams()
    )
}

fun Java8Parser.MethodDeclarationContext?.returnType(): String? {
    if (this == null) return null
    return methodHeader()?.result()?.text
}

fun Java8Parser.MethodDeclarationContext?.modifiers(): List<String> {
    if (this == null) return listOf()
    return methodModifier()?.map { it.text } ?: listOf()
}

fun Java8Parser.MethodDeclarationContext?.isStatic(): Boolean {
    if (this == null) return false
    return modifiers().contains("static")
}

fun Java8Parser.MethodDeclarationContext?.isInstanceMethod(): Boolean {
    if (this == null) return false
    return !isStatic()
}

fun Java8Parser.MethodDeclarationContext?.isPrivate(): Boolean {
    if (this == null) return false
    return modifiers().contains("private")
}

fun Java8Parser.MethodDeclarationContext?.isOverrid(): Boolean {
    if (this == null) return false
    return modifiers().contains("@Override")
}

fun Java8Parser.MethodDeclarationContext?.isDeprecated(): Boolean {
    if (this == null) return false
    return modifiers().contains("@Deprecated")
}

fun Java8Parser.MethodDeclarationContext?.name(): String? {
    if (this == null) return null
    return methodHeader()?.methodDeclarator()?.Identifier()?.text
}

fun Java8Parser.MethodDeclarationContext?.formalParams(): List<Variable> {
    if (this == null) return listOf()
    val result = mutableListOf<Variable>()

    val parameters = methodHeader()
        .methodDeclarator()
        ?.formalParameterList()

    // 除最后一个参数之外的参数
    parameters
        ?.formalParameters()
        ?.formalParameter()
        ?.forEach {
            result.add(Variable(it.unannType().text.toDartType(), it.variableDeclaratorId().text))
        }

    // 最后一个参数
    parameters
        ?.lastFormalParameter()
        ?.formalParameter()
        ?.run {
            result.add(Variable(unannType().text.toDartType(), variableDeclaratorId().text))
        }

    return result
}
//endregion


//region Objc Instance Method
fun ObjectiveCParser.MethodDeclarationContext?.returnType(): String? {
    if (this == null) return null
    return methodType()?.typeName()?.text
}

fun ObjectiveCParser.MethodDeclarationContext?.name(): String? {
    if (this == null) return null
    return methodSelector()
        .selector()
        ?.text ?: methodSelector()
        .keywordDeclarator()[0]
        ?.selector()
        ?.text
}

fun ObjectiveCParser.MethodDeclarationContext?.formalParams(): List<Variable> {
    if (this == null) return listOf()
    val result = mutableListOf<Variable>()

    methodSelector().keywordDeclarator()
        ?.forEach {
            result.add(Variable(it.methodType()[0].typeName().text.toDartType(), it.identifier().text))
        }
    return result
}
//endregion


//region Objc Class Method
fun ObjectiveCParser.ClassMethodDeclarationContext?.returnType(): String? {
    if (this == null) return null
    return methodDeclaration().methodType().typeName().text
}

fun ObjectiveCParser.ClassMethodDeclarationContext?.name(): String? {
    if (this == null) return null
    return methodDeclaration()
        .methodSelector()
        .selector()
        ?.text ?: methodDeclaration()
        .methodSelector()
        .keywordDeclarator()[0]
        .selector()
        .text
}

fun ObjectiveCParser.ClassMethodDeclarationContext?.formalParams(): List<Variable> {
    if (this == null) return listOf()
    val result = mutableListOf<Variable>()

    methodDeclaration()
        .methodSelector()
        .keywordDeclarator()
        ?.forEach {
            result.add(Variable(it.methodType()[0].typeName().text.toDartType(), it.identifier().text))
        }
    return result
}
//endregion