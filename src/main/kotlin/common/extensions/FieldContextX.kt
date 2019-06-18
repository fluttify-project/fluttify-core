package common.extensions

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

fun FieldDeclarationContext?.type(): String? {
    if (this == null) return null
    return typeType()?.text
}

fun FieldDeclarationContext?.name(): String? {
    if (this == null) return null
    return variableDeclarators()?.variableDeclarator()?.get(0)?.variableDeclaratorId()?.text
}

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

    return type()?.toDartType() in listOf(
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

//region Objc field
fun ObjectiveCParser.FieldDeclarationContext?.isStatic(): Boolean {
    return false
}

fun ObjectiveCParser.FieldDeclarationContext?.type(): String? {
    if (this == null) return null
    return specifierQualifierList().text
}

fun ObjectiveCParser.FieldDeclarationContext?.name(): String? {
    if (this == null) return null
    return fieldDeclaratorList().text
}

fun ObjectiveCParser.FieldDeclarationContext?.jsonable(): Boolean {
    if (this == null) return true

    return type()?.toDartType() in listOf(
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