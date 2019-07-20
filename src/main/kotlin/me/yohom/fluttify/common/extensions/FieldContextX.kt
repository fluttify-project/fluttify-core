package me.yohom.fluttify.common.extensions

import parser.java.JavaParser
import parser.objc.ObjectiveCParser

//region Java Field
fun JavaParser.FieldDeclarationContext?.isStatic(): Boolean {
    if (this == null) return false
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("static") == true
}

fun JavaParser.FieldDeclarationContext?.isPrivate(): Boolean {
    if (this == null) return false
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("private") == true
}

fun JavaParser.FieldDeclarationContext.isPublic(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("public") == true
}

fun JavaParser.FieldDeclarationContext.type(): String {
    val simpleType = typeType().text
    return ancestorOf(JavaParser.CompilationUnitContext::class)
        ?.importDeclaration()
        ?.firstOrNull {
            !simpleType.jsonable()
                    && it.qualifiedName().text.length >= simpleType.length
                    && it.qualifiedName()
                .text
                .replace("$", ".")
                .run { substringAfterLast(".") } == simpleType
        }
        ?.qualifiedName()?.text ?: simpleType
}

fun JavaParser.FieldDeclarationContext.name(): String {
    return variableDeclarators()?.variableDeclarator()?.get(0)?.variableDeclaratorId()?.text ?: ""
}

fun JavaParser.FieldDeclarationContext.isFinal(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("final") == true
}

fun JavaParser.FieldDeclarationContext?.value(): String? {
    if (this == null) return null
    return variableDeclarators()
        ?.variableDeclarator()
        ?.get(0)
        ?.variableInitializer()
        ?.run {
            return when {
                arrayInitializer() != null -> {
                    arrayInitializer().text.replace("{", "[").replace("}", "]")
                }
                expression() != null -> {
                    expression().text
                }
                else -> ""
            }
        }
}

fun JavaParser.FieldDeclarationContext?.jsonable(): Boolean {
    if (this == null) return true

    return type().jsonable()
}
//endregion

//region Objc field
fun ObjectiveCParser.FieldDeclarationContext.isFinal(): Boolean {
    return ancestorOf(ObjectiveCParser.PropertyDeclarationContext::class)
        ?.propertyAttributesList()
        ?.propertyAttribute()
        ?.map { it.text }
        ?.contains("readonly") == true
}

fun ObjectiveCParser.FieldDeclarationContext.type(): String {
    return specifierQualifierList().text
}

fun ObjectiveCParser.FieldDeclarationContext.name(): String {
    return fieldDeclaratorList().text
}

fun ObjectiveCParser.FieldDeclarationContext.isStatic(): Boolean {
    return false
}

fun ObjectiveCParser.FieldDeclarationContext.jsonable(): Boolean {
    return type().toDartType() in listOf(
        "bool",
        "int",
        "double",
        "String",
        "List",
        "Map",
        "null",
        "List<int>",
        "List<double>",
        "void"
    )
}
//endregion