package common.extensions

import common.model.Variable
import parser.java.JavaParser
import parser.objc.ObjectiveCParser

//fun JavaParser.MethodDeclarationContext?.method(): Method? {
//    if (this == null) return null
//    return Method(
//        returnType(),
//        IDENTIFIER().text ?: return null,
//        formalParams()
//    )
//}
//
//fun JavaParser.InterfaceMethodDeclarationContext?.method(): Method? {
//    if (this == null) return null
//    return Method(
//        returnType(),
//        IDENTIFIER().text ?: return null,
//        formalParams()
//    )
//}

fun JavaParser.MethodDeclarationContext.returnType(): String {
    val paramType = typeTypeOrVoid().text.genericType()
    val fullGenericType = ancestorOf(JavaParser.CompilationUnitContext::class)
        ?.importDeclaration()
        // 找到import语句中对应的语句
        ?.firstOrNull {
            !paramType.jsonable()
                    && it.qualifiedName().text.length >= paramType.length
                    && it.qualifiedName()
                .text
                .run { substring(length - paramType.length, length) } == paramType
        }
        ?.qualifiedName()?.text ?: paramType

    return if (typeTypeOrVoid().text.isList()) {
        "List<$fullGenericType>"
    } else {
        fullGenericType
    }
}

fun JavaParser.InterfaceMethodDeclarationContext.returnType(): String {
    val paramType = typeTypeOrVoid().text.genericType()
    val fullGenericType = ancestorOf(JavaParser.CompilationUnitContext::class)
        ?.importDeclaration()
        // 找到import语句中对应的语句
        ?.firstOrNull {
            !paramType.jsonable()
                    && it.qualifiedName().text.length >= paramType.length
                    && it.qualifiedName()
                .text
                .run { substring(length - paramType.length, length) } == paramType
        }
        ?.qualifiedName()?.text ?: paramType

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

fun JavaParser.MethodDeclarationContext?.isPublic(): Boolean {
    if (this == null) return false
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("public") == true
}

fun JavaParser.MethodDeclarationContext?.isInstanceMethod(): Boolean {
    if (this == null) return false
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("static") != true
}

fun JavaParser.MethodDeclarationContext.formalParams(): List<Variable> {
    val result = mutableListOf<Variable>()

    val parameters = formalParameters().formalParameterList()

    // 除最后一个参数之外的参数
    parameters
        ?.formalParameter()
        ?.forEach { formalParam ->
            val paramType = formalParam.typeType().text.genericType()
            val typeFullName = ancestorOf(JavaParser.CompilationUnitContext::class)
                ?.importDeclaration()
                ?.firstOrNull {
                    !paramType.jsonable()
                            && it.qualifiedName().text.length >= paramType.length
                            && it.qualifiedName()
                        .text
                        .replace("$", ".")
                        .run { substringAfterLast(".") } == paramType
                }
                ?.qualifiedName()?.text ?: paramType
            result.add(
                Variable(
                    when {
                        formalParam.typeType().text.isList() -> "List<$typeFullName>"
                        else -> typeFullName
                    },
                    formalParam.variableDeclaratorId().text
                )
            )
        }

    // 最后一个参数
    parameters
        ?.lastFormalParameter()
        ?.run {
            val paramType = typeType().text.genericType()
            val typeFullName = ancestorOf(JavaParser.CompilationUnitContext::class)
                ?.importDeclaration()
                ?.firstOrNull {
                    !paramType.jsonable()
                            && it.qualifiedName().text.length >= paramType.length
                            && it.qualifiedName()
                        .text
                        .replace("$", ".")
                        .run { substringAfterLast(".") } == paramType
                }
                ?.qualifiedName()?.text ?: paramType
            result.add(
                Variable(
                    when {
                        typeType().text.isList() -> "List<$typeFullName>"
                        else -> typeFullName
                    },
                    variableDeclaratorId().text
                )
            )
        }

    return result
}

fun JavaParser.InterfaceMethodDeclarationContext.formalParams(): List<Variable> {
    val result = mutableListOf<Variable>()

    val parameters = formalParameters().formalParameterList()

    // 除最后一个参数之外的参数
    parameters
        ?.formalParameter()
        ?.forEach { formalParam ->
            val paramType = formalParam.typeType().text.genericType()
            val typeFullName = ancestorOf(JavaParser.CompilationUnitContext::class)
                ?.importDeclaration()
                ?.firstOrNull {
                    !paramType.jsonable()
                            && it.qualifiedName().text.length >= paramType.length
                            && it.qualifiedName()
                        .text
                        .replace("$", ".")
                        .run { substringAfterLast(".") } == paramType
                }
                ?.qualifiedName()?.text ?: paramType
            result.add(
                Variable(
                    when {
                        formalParam.typeType().text.isList() -> "List<$typeFullName>"
                        else -> typeFullName
                    },
                    formalParam.variableDeclaratorId().text
                )
            )
        }

    // 最后一个参数
    parameters
        ?.lastFormalParameter()
        ?.run {
            val paramType = typeType().text.genericType()
            val typeFullName = ancestorOf(JavaParser.CompilationUnitContext::class)
                ?.importDeclaration()
                ?.firstOrNull {
                    !paramType.jsonable()
                            && it.qualifiedName().text.length >= paramType.length
                            && it.qualifiedName()
                        .text
                        .replace("$", ".")
                        .run { substringAfterLast(".") } == paramType
                }
                ?.qualifiedName()?.text ?: paramType
            result.add(
                Variable(
                    when {
                        typeType().text.isList() -> "List<$typeFullName>"
                        else -> typeFullName
                    },
                    variableDeclaratorId().text
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
            ancestorOf(ObjectiveCParser.ClassInterfaceContext::class)?.className?.text ?: ""
        } else {
            this
        }
    }
}

fun ObjectiveCParser.MethodDeclarationContext.name(): String {
    return methodSelector()
        .selector()
        ?.text ?: methodSelector()
        .keywordDeclarator()[0]
        .selector()
        .text
}

fun ObjectiveCParser.MethodDeclarationContext.formalParams(): List<Variable> {
    val result = mutableListOf<Variable>()

    methodSelector()
        .keywordDeclarator()
        ?.forEach {
            result.add(
                Variable(
                    it.methodType()[0].typeName().text.toDartType(),
                    it.identifier().text
                )
            )
        }
    return result
}
//endregion