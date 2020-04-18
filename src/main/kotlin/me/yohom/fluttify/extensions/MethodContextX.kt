package me.yohom.fluttify.extensions

import me.yohom.fluttify.model.Parameter
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.Variable
import parser.java.JavaParser
import parser.objc.ObjectiveCParser

//region Java Method
fun JavaParser.MethodDeclarationContext.returnType(): String {
    return typeFullName(typeTypeOrVoid().text)
}

fun JavaParser.InterfaceMethodDeclarationContext.returnType(): String {
    return typeFullName(typeTypeOrVoid().text)
}

fun JavaParser.MethodDeclarationContext.name(): String {
    return IDENTIFIER().text
}

fun JavaParser.MethodDeclarationContext.isGenericMethod(): Boolean {
    return isChildOf(JavaParser.GenericMethodDeclarationContext::class)
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

fun JavaParser.InterfaceMethodDeclarationContext.isGenericMethod(): Boolean {
    return typeParameters() != null
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

fun JavaParser.MethodDeclarationContext.isPublic(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("public") == true
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

    // 所在类声明的泛型类型
    val typeDeclareGenericTypes = ancestorOf(JavaParser.ClassDeclarationContext::class)?.genericTypes() ?: listOf()
    // 除最后一个参数之外的参数
    parameters
        ?.formalParameter()
        ?.forEach { formalParam ->
            val paramType = formalParam.typeType().text
            // 如果当前参数类型是所在类声明中的泛型类型, 那么就直接使用, 否则拼接包名
            val typeFullName = if (paramType in typeDeclareGenericTypes) {
                paramType
            } else {
                typeFullName(paramType)
            }
            result.add(
                Parameter(
                    variable = Variable(
                        typeFullName,
                        formalParam.variableDeclaratorId().text,
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
            val paramType = typeType().text
            // 如果当前参数类型是所在类声明中的泛型类型, 那么就直接使用, 否则拼接包名
            val typeFullName = if (paramType in typeDeclareGenericTypes) {
                paramType
            } else {
                typeFullName(paramType)
            }
            result.add(
                Parameter(
                    variable = Variable(
                        typeFullName,
                        variableDeclaratorId().text,
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

    // 所在类声明的泛型类型
    val typeDeclareGenericTypes = ancestorOf(JavaParser.InterfaceDeclarationContext::class)?.genericTypes() ?: listOf()

    // 除最后一个参数之外的参数
    parameters
        ?.formalParameter()
        ?.forEach { formalParam ->
            val paramType = formalParam.typeType().text
            // 如果当前参数类型是所在类声明中的泛型类型, 那么就直接使用, 否则拼接包名
            val typeFullName = if (paramType in typeDeclareGenericTypes) {
                paramType
            } else {
                typeFullName(paramType)
            }
            result.add(
                Parameter(
                    variable = Variable(
                        typeFullName,
                        formalParam.variableDeclaratorId().text,
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
            val paramType = typeType().text
            // 如果当前参数类型是所在类声明中的泛型类型, 那么就直接使用, 否则拼接包名
            val typeFullName = if (paramType in typeDeclareGenericTypes) {
                paramType
            } else {
                typeFullName(paramType)
            }
            result.add(
                Parameter(
                    variable = Variable(
                        typeFullName,
                        variableDeclaratorId().text,
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
    return methodType()
        .typeName()
        .text
        .run {
            if (this == "instancetype") {
                val instancetype = ancestorOf(ObjectiveCParser.ClassInterfaceContext::class)?.className?.text
                    ?: ancestorOf(ObjectiveCParser.ProtocolDeclarationContext::class)?.protocolName()?.text
                if (instancetype != null) {
                    "$instancetype*"
                } else {
                    ""
                }
            } else {
                this
            }
        }
        // 有些方法在返回类型后面会跟一些宏, 去掉这些宏
        .run { removeSuffix(substringAfterLast("*", "")) }
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
                        it.methodType()[0]
                            .typeName()
                            .run {
                                // lambda类型的参数处理
                                blockType()?.run { "${returnType()}|${parameters()}" }
                                // 非lambda参数处理 如果有__kindof限定词就空格分隔一下
                                    ?: text.objcSpecifierExpand()
                            }
                            .run {
                                // 如果变量名以*号开始, 说明类名上的*号被移动到变量名上了, 需要加回来
                                if (it.identifier().text.startsWith("*")) {
                                    enpointer()
                                } else {
                                    this
                                }
                            },
                        it.identifier().text.depointer(), // 统一把*号加到类名上去
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
    return blockParameters()
        .typeVariableDeclaratorOrName()
        .mapIndexed { index, context -> index to context }
        .joinToString(",") {
            // lambda参数, 可以是只有类名, 所以这里的name有可能是空, 类名也可以是空, 如果类名是空的话就直接使用
            // it.typeName().text
            val name = it.second?.typeVariableDeclarator()?.declarator()?.text ?: "__arg_${it.first}__"
            val type = it.second?.typeVariableDeclarator()
                ?.declarationSpecifiers()
                ?.text
                ?.run {
                    // 如果变量名上面有*号, 那么需要把*号移到类型名上面来
                    if (name.startsWith("*")) enpointer() else this
                }
                ?: it.second?.typeName()?.text
            "$type#${name.depointer()}"
        }
}
//endregion