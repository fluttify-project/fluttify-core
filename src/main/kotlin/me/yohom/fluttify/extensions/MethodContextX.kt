package me.yohom.fluttify.extensions

import me.yohom.fluttify.model.ListType
import me.yohom.fluttify.model.Parameter
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.Variable
import parser.java.JavaParser
import parser.objc.ObjectiveCParser

//region Java Method
fun JavaParser.MethodDeclarationContext.returnType(): String {
    val containerType = typeTypeOrVoid().text.containerType()
    // 返回类型 简称
    val genericTypes = typeTypeOrVoid().text.genericType().split(",")
    // 返回类型 全称
    val fullGenericTypes = genericTypes.map { typeFullName(it) }.toMutableList()
    // 返回容器类型 全称
    val fullContainerType = typeFullName(containerType)

    // 如果返回类型是当前类, 那么从import里是找不到的, 需要用package和当前类名合成
    genericTypes.forEachIndexed { index, type ->
        if (type.simpleName() == ancestorOf(JavaParser.ClassDeclarationContext::class)?.IDENTIFIER()?.text) {
            val `package` =
                ancestorOf(JavaParser.CompilationUnitContext::class)?.packageDeclaration()?.qualifiedName()?.text
            fullGenericTypes[index] = "$`package`.${type.simpleName()}"
        }
    }

    return when {
        typeTypeOrVoid().text.isList() -> {
            var result = fullGenericTypes[0]
            for (i in 0 until typeTypeOrVoid().text.genericLevel()) {
                result = result.enlist()
            }
            result
        }
        // 容器类型和泛型类型不一样, 说明是泛型类型
        fullContainerType != fullGenericTypes[0] -> {
            "$fullContainerType<${fullGenericTypes.joinToString(",")}>"
        }
        // 普通类型
        else -> {
            fullGenericTypes[0]
        }
    }
}

fun JavaParser.InterfaceMethodDeclarationContext.returnType(): String {
    val containerType = typeTypeOrVoid().text.containerType()
    // 返回类型 简称
    val genericTypes = typeTypeOrVoid().text.genericType().split(",")
    // 返回类型 全称
    val fullGenericTypes = genericTypes.map { typeFullName(it) }.toMutableList()
    // 返回容器类型 全称
    val fullContainerType = typeFullName(containerType)

    // 如果返回类型是当前类, 那么从import里是找不到的, 需要用package和当前类名合成
    genericTypes.forEachIndexed { index, type ->
        if (type.simpleName() == ancestorOf(JavaParser.ClassDeclarationContext::class)?.IDENTIFIER()?.text) {
            val `package` =
                ancestorOf(JavaParser.CompilationUnitContext::class)?.packageDeclaration()?.qualifiedName()?.text
            fullGenericTypes[index] = "$`package`.${type.simpleName()}"
        }
    }

    return when {
        typeTypeOrVoid().text.isList() -> {
            var result = fullGenericTypes[0]
            for (i in 0 until typeTypeOrVoid().text.genericLevel()) {
                result = result.enlist()
            }
            result
        }
        // 容器类型和泛型类型不一样, 说明是泛型类型
        fullContainerType != fullGenericTypes[0] -> {
            "$fullContainerType<${fullGenericTypes.joinToString(",")}>"
        }
        // 普通类型
        else -> {
            fullGenericTypes[0]
        }
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
                        formalParam.typeType().text.run {
                            when {
                                isArray() -> ListType.Array
                                isArrayList() -> ListType.ArrayList
                                isLinkedList() -> ListType.LinkedList
                                isList() -> ListType.List
                                else -> ListType.NonList
                            }
                        },
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
                        typeType().text.run {
                            when {
                                isArray() -> ListType.Array
                                isArrayList() -> ListType.ArrayList
                                isLinkedList() -> ListType.LinkedList
                                isList() -> ListType.List
                                else -> ListType.NonList
                            }
                        },
                        typeType().text.genericLevel(),
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
                        formalParam.typeType().text.run {
                            when {
                                isArray() -> ListType.Array
                                isArrayList() -> ListType.ArrayList
                                isLinkedList() -> ListType.LinkedList
                                isList() -> ListType.List
                                else -> ListType.NonList
                            }
                        },
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
                        typeType().text.run {
                            when {
                                isArray() -> ListType.Array
                                isArrayList() -> ListType.ArrayList
                                isLinkedList() -> ListType.LinkedList
                                isList() -> ListType.List
                                else -> ListType.NonList
                            }
                        },
                        typeType().text.genericLevel(),
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
                        }.genericType(),
                        it.identifier().text,
                        it.methodType()[0].typeName().text.run {
                            when {
                                isArray() -> ListType.Array
                                isArrayList() -> ListType.ArrayList
                                isLinkedList() -> ListType.LinkedList
                                isList() -> ListType.List
                                else -> ListType.NonList
                            }
                        },
                        it.methodType()[0].typeName().text.genericLevel(),
                        Platform.iOS
                    ),
                    platform = Platform.iOS
                )
            )
        }
    return result
}

fun ObjectiveCParser.MethodDeclarationContext.isDeprecated(): Boolean {
    return macro()?.primaryExpression()?.any { it.text.contains("deprecated") } == true
            || attributeSpecifier()?.text?.contains("deprecated") == true
}

fun ObjectiveCParser.MethodDeclarationContext.isUnavailable(): Boolean {
    return macro()?.primaryExpression()?.any { it.text.contains("unavailable") } == true
            || attributeSpecifier()?.text?.contains("unavailable") == true
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