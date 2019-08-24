package me.yohom.fluttify.common.extensions

import parser.java.JavaParser
import parser.objc.ObjectiveCParser

//region Java Field
fun JavaParser.FieldDeclarationContext.isStatic(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("static") == true
}

fun JavaParser.FieldDeclarationContext.isDeprecated(): Boolean {
    return ancestorOf(JavaParser.ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.any { it.text.contains("@Deprecated") } == true
}

fun JavaParser.FieldDeclarationContext.isPrivate(): Boolean {
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
/**
 * 是否是只读 有两种情况
 *
 * 1. property指定是readonly
 * 2. 声明了getter却没有声明setter
 */
fun ObjectiveCParser.FieldDeclarationContext.isFinal(): Boolean {
    val propertyAttributes = ancestorOf(ObjectiveCParser.PropertyDeclarationContext::class)
        ?.propertyAttributesList()
        ?.propertyAttribute()
        ?.map { it.text }

    val getter = propertyAttributes
        ?.find { it.contains("getter") }
        ?.run { split("=")[1] } ?: ""

    val setter = propertyAttributes
        ?.find { it.contains("setter") }
        ?.run { split("=")[1] } ?: ""

    val readonly = propertyAttributes?.contains("readonly") == true

    val copy = propertyAttributes?.contains("copy") == true

    return readonly || copy || (getter.isNotEmpty() && setter.isEmpty())
}

fun ObjectiveCParser.FieldDeclarationContext.type(): String {
    return specifierQualifierList().text.run {
        if (contains("id<")) {
            removePrefix("id<").removeSuffix(">")
        } else {
            this
        }
    }
}

fun ObjectiveCParser.FieldDeclarationContext.name(): String {
    return fieldDeclaratorList().text
}

fun ObjectiveCParser.FieldDeclarationContext.isStatic(): Boolean {
    return false
}

fun ObjectiveCParser.FieldDeclarationContext.getterName(): String {
    return ancestorOf(ObjectiveCParser.PropertyDeclarationContext::class)
        ?.propertyAttributesList()
        ?.propertyAttribute()
        ?.map { it.text }
        ?.find { it.contains("getter") }
        ?.run { split("=")[1] }
        ?: name().depointer()
}

fun ObjectiveCParser.FieldDeclarationContext.setterName(): String {
    return ancestorOf(ObjectiveCParser.PropertyDeclarationContext::class)
        ?.propertyAttributesList()
        ?.propertyAttribute()
        ?.map { it.text }
        ?.find { it.contains("setter") }
        ?.run { split("=")[1] }
        ?: name().depointer()
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