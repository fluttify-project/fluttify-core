package common.extensions

import common.model.Method
import common.model.Variable
import parser.java.JavaParser
import parser.objc.ObjectiveCParser

fun JavaParser.MethodDeclarationContext?.method(): Method? {
    if (this == null) return null
    return Method(
        returnType() ?: return null,
        IDENTIFIER().text ?: return null,
        formalParams()
    )
}

fun JavaParser.MethodDeclarationContext?.returnType(): String? {
    if (this == null) return null
    return typeTypeOrVoid().text
}

fun JavaParser.MethodDeclarationContext?.name(): String? {
    if (this == null) return null
    return IDENTIFIER().text
}

fun JavaParser.MethodDeclarationContext?.isPrivate(): Boolean {
    if (this == null) return false
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class).modifier().map { it.text }.contains("private")
}

fun JavaParser.MethodDeclarationContext?.isDeprecated(): Boolean {
    if (this == null) return false
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class).modifier().map { it.text }.contains("@Deprecated")
}

fun JavaParser.MethodDeclarationContext?.isInstanceMethod(): Boolean {
    if (this == null) return false
    return !ancestorOf(JavaParser.ClassBodyDeclarationContext::class).modifier().map { it.text }.contains("static")
}

fun JavaParser.MethodDeclarationContext?.formalParams(): List<Variable> {
    if (this == null) return listOf()
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