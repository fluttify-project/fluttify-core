package common.extensions

import parser.java.JavaParser
import parser.java.JavaParser.ClassBodyDeclarationContext
import parser.java.JavaParser.FieldDeclarationContext
import parser.objc.ObjectiveCParser

//region Java Field
fun FieldDeclarationContext?.isStatic(): Boolean {
    if (this == null) return false
    return ancestorOf(ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("static") == true
}

fun FieldDeclarationContext?.isPrivate(): Boolean {
    if (this == null) return false
    return ancestorOf(ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("private") == true
}

fun FieldDeclarationContext.isPublic(): Boolean {
    return ancestorOf(ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("public") == true
}

fun FieldDeclarationContext.type(): String {
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

fun FieldDeclarationContext.name(): String {
    return variableDeclarators()?.variableDeclarator()?.get(0)?.variableDeclaratorId()?.text ?: ""
}

fun FieldDeclarationContext.isFinal(): Boolean {
    return ancestorOf(ClassBodyDeclarationContext::class)
        ?.modifier()
        ?.map { it.text }
        ?.contains("final") == true}

fun FieldDeclarationContext?.value(): String? {
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

fun FieldDeclarationContext?.jsonable(): Boolean {
    if (this == null) return true

    return type().jsonable()
}
//endregion

//region Objc field
fun ObjectiveCParser.PropertyDeclarationContext.isFinal(): Boolean {
    return propertyAttributesList()
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

fun ObjectiveCParser.FieldDeclarationContext?.jsonable(): Boolean {
    if (this == null) return true

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