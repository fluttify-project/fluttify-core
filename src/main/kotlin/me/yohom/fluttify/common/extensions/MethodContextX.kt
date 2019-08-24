package me.yohom.fluttify.common.extensions

import me.yohom.fluttify.common.model.Parameter
import me.yohom.fluttify.common.model.Platform
import me.yohom.fluttify.common.model.Variable
import parser.java.JavaParser
import parser.objc.ObjectiveCParser

//region Java Method
fun JavaParser.MethodDeclarationContext.returnType(): String {
    // 返回类型 简称
    val paramType = typeTypeOrVoid().text.genericType()
    // 返回类型 全称
    var fullGenericType = typeFullName(paramType)

    // 如果返回类型是当前类, 那么从import里是找不到的, 需要用package和当前类名合成
    if (paramType == ancestorOf(JavaParser.ClassDeclarationContext::class)?.IDENTIFIER()?.text) {
        val `package` =
            ancestorOf(JavaParser.CompilationUnitContext::class)?.packageDeclaration()?.qualifiedName()?.text
        fullGenericType = "$`package`.$paramType"
    }

    return if (typeTypeOrVoid().text.isList()) {
        "List<$fullGenericType>"
    } else {
        fullGenericType
    }
}

fun JavaParser.InterfaceMethodDeclarationContext.returnType(): String {
    val paramType = typeTypeOrVoid().text.genericType()
    val fullGenericType = typeFullName(paramType)

    return if (typeTypeOrVoid().text.isList()) {
        "List<$fullGenericType>"
    } else {
        fullGenericType
    }
}

fun JavaParser.MethodDeclarationContext.name(): String {
    return IDENTIFIER().text
}

fun JavaParser.MethodDeclarationContext.isAbstract(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("abstract") == true
}

fun JavaParser.InterfaceMethodDeclarationContext.name(): String {
    return IDENTIFIER().text
}

fun JavaParser.MethodDeclarationContext.isPrivate(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("private") == true
}

fun JavaParser.MethodDeclarationContext.isStatic(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("static") == true
}

fun JavaParser.InterfaceMethodDeclarationContext.isStatic(): Boolean {
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

fun JavaParser.MethodDeclarationContext.isPublic(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("public") == true
}

fun JavaParser.MethodDeclarationContext.isInstanceMethod(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("static") != true
}

fun JavaParser.MethodDeclarationContext.isDeprecated(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.any { it.text.contains("@Deprecated") } == true
}

fun JavaParser.InterfaceMethodDeclarationContext.isDeprecated(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.any { it.text.contains("@Deprecated") } == true
}

fun JavaParser.MethodDeclarationContext.formalParams(): List<Parameter> {
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
                        typeType().text.isList(),
                        Platform.Android
                    ),
                    platform = Platform.Android
                )
            )
        }

    return result
}

fun JavaParser.InterfaceMethodDeclarationContext.formalParams(): List<Parameter> {
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
                        typeType().text.isList(),
                        Platform.Android
                    ),
                    platform = Platform.Android
                )
            )
        }

    return result
}
//endregion

//region Objc Method
fun ObjectiveCParser.MethodDeclarationContext.returnType(): String {
    return methodType().typeName().text.run {
        if (this == "instancetype") {
            val instancetype = ancestorOf(ObjectiveCParser.ClassInterfaceContext::class)?.className?.text
            if (instancetype != null) {
                "$instancetype*"
            } else {
                ""
            }
        } else {
            this
        }
    }
}

fun ObjectiveCParser.MethodDeclarationContext.isStatic(): Boolean {
    return ancestorOf(ObjectiveCParser.ClassMethodDeclarationContext::class) != null

}

fun ObjectiveCParser.MethodDeclarationContext.name(): String {
    return methodSelector()
        .selector()
        ?.text ?: methodSelector()
        .keywordDeclarator()[0]
        .selector()
        .text
}

fun ObjectiveCParser.MethodDeclarationContext.formalParams(): List<Parameter> {
    val result = mutableListOf<Parameter>()

    methodSelector()
        .keywordDeclarator()
        ?.forEachIndexed { index, it ->
            result.add(
                Parameter(
                    if (index == 0) "" else it.selector().text ?: "",
                    Variable(
                        it.methodType()[0].typeName().run {
                            blockType()?.run { "${returnType()}|${parameters()}" } ?: text
                        },
                        it.identifier().text,
                        platform = Platform.iOS
                    ),
                    platform = Platform.iOS
                )
            )
        }
    return result
}

fun ObjectiveCParser.MethodDeclarationContext.isDeprecated(): List<Parameter> {
    val result = mutableListOf<Parameter>()

    methodSelector()
        .keywordDeclarator()
        ?.forEachIndexed { index, it ->
            result.add(
                Parameter(
                    if (index == 0) "" else it.selector().text ?: "",
                    Variable(
                        it.methodType()[0].typeName().run {
                            blockType()?.run { "${returnType()}|${parameters()}" } ?: text
                        },
                        it.identifier().text,
                        platform = Platform.iOS
                    ),
                    platform = Platform.iOS
                )
            )
        }
    return result
}

fun ObjectiveCParser.BlockTypeContext.returnType(): String {
    return typeSpecifier()[0].text
}

fun ObjectiveCParser.BlockTypeContext.parameters(): String {
    return blockParameters().typeVariableDeclaratorOrName().joinToString {
        "${it.typeVariableDeclarator().declarationSpecifiers().text} ${it.typeVariableDeclarator().declarator().directDeclarator().identifier().text}"
    }
}
//endregion