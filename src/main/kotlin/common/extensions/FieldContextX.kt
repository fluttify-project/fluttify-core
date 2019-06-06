package common.extensions

import parser.java.JavaParser.*
import parser.java.JavaParser.FieldDeclarationContext

fun FieldDeclarationContext?.isStatic(): Boolean {
    if (this == null) return false
    return ancestorOf(ClassBodyDeclarationContext::class).modifier().map { it.text }.contains("static")
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
        "Uint8List",
        "Int32List",
        "Int64List",
        "Float64List",
        "void"
    )
}