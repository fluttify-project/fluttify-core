package common.extensions

import common.model.Method
import common.model.Variable
import parser.java.JavaParser
import parser.objc.ObjectiveCParser

fun JavaParser.MethodDeclarationContext?.method(): Method? {
    if (this == null) return null
    return Method(
        returnType(),
        IDENTIFIER().text ?: return null,
        formalParams()
    )
}

fun JavaParser.InterfaceMethodDeclarationContext?.method(): Method? {
    if (this == null) return null
    return Method(
        returnType(),
        IDENTIFIER().text ?: return null,
        formalParams()
    )
}

fun JavaParser.MethodDeclarationContext.returnType(): String {
    return typeTypeOrVoid().text
}

fun JavaParser.InterfaceMethodDeclarationContext.returnType(): String {
    return typeTypeOrVoid().text
}

fun JavaParser.MethodDeclarationContext.name(): String {
    return IDENTIFIER().text
}

fun JavaParser.InterfaceMethodDeclarationContext.name(): String {
    return IDENTIFIER().text
}

fun JavaParser.MethodDeclarationContext?.isPrivate(): Boolean {
    if (this == null) return false
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("private") == true
}

fun JavaParser.MethodDeclarationContext?.isStatic(): Boolean {
    if (this == null) return false
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("static") == true
}

fun JavaParser.InterfaceMethodDeclarationContext?.isStatic(): Boolean {
    if (this == null) return false
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("static") == true
}

/**
 * 判断当前方法是否被混淆
 *
 * 规则:
 *   1. 方法名长度只有1
 */
fun JavaParser.MethodDeclarationContext.isObfuscated(): Boolean {
    return name().length == 1
}

fun JavaParser.MethodDeclarationContext?.isPublic(): Boolean {
    if (this == null) return false
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("public") == true
}

fun JavaParser.InterfaceMethodDeclarationContext?.isPublic(): Boolean {
    if (this == null) return false
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("public") == true
}

fun JavaParser.MethodDeclarationContext?.isDeprecated(): Boolean {
    if (this == null) return false
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("@Deprecated") == true
}

fun JavaParser.InterfaceMethodDeclarationContext?.isDeprecated(): Boolean {
    if (this == null) return false
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("@Deprecated") == true
}

fun JavaParser.MethodDeclarationContext?.isOverride(): Boolean {
    if (this == null) return false
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("@Deprecated") == true
}

fun JavaParser.InterfaceMethodDeclarationContext?.isOverride(): Boolean {
    if (this == null) return false
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("@Deprecated") == true
}

fun JavaParser.MethodDeclarationContext?.isInstanceMethod(): Boolean {
    if (this == null) return false
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("static") != true
}

fun JavaParser.InterfaceMethodDeclarationContext?.isInstanceMethod(): Boolean {
    if (this == null) return false
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("static") != true
}

fun JavaParser.MethodDeclarationContext?.formalParams(): List<Variable> {
    if (this == null) return listOf()
    val result = mutableListOf<Variable>()

    val parameters = this.formalParameters().formalParameterList()

    // 除最后一个参数之外的参数
    parameters
        ?.formalParameter()
        ?.forEach {
            result.add(Variable(it.typeType().text, it.variableDeclaratorId().text))
        }

    // 最后一个参数
    parameters
        ?.lastFormalParameter()
        ?.run {
            result.add(Variable(typeType().text, variableDeclaratorId().text))
        }

    return result
}

fun JavaParser.InterfaceMethodDeclarationContext?.formalParams(): List<Variable> {
    if (this == null) return listOf()
    val result = mutableListOf<Variable>()

    val parameters = this.formalParameters().formalParameterList()

    // 除最后一个参数之外的参数
    parameters
        ?.formalParameter()
        ?.forEach {
            result.add(Variable(it.typeType().text, it.variableDeclaratorId().text))
        }

    // 最后一个参数
    parameters
        ?.lastFormalParameter()
        ?.run {
            result.add(Variable(typeType().text, variableDeclaratorId().text))
        }

    return result
}
//endregion

//region Objc Method
fun ObjectiveCParser.MethodDeclarationContext?.returnType(): String? {
    if (this == null) return null
    return methodType().typeName().text
}

fun ObjectiveCParser.MethodDeclarationContext?.name(): String? {
    if (this == null) return null
    return methodSelector()
        .selector()
        ?.text ?: methodSelector()
        .keywordDeclarator()[0]
        .selector()
        .text
}

fun ObjectiveCParser.MethodDeclarationContext?.formalParams(): List<Variable> {
    if (this == null) return listOf()
    val result = mutableListOf<Variable>()

    methodSelector()
        .keywordDeclarator()
        ?.forEach {
            result.add(Variable(it.methodType()[0].typeName().text.toDartType(), it.identifier().text))
        }
    return result
}
//endregion