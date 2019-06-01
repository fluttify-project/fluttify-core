package common.extensions

import parser.java8.Java8Parser

fun Java8Parser.FieldDeclarationContext?.isStatic(): Boolean {
    if (this == null) return false

    return fieldModifier().map { it.text }.contains("static")
}

fun Java8Parser.FieldDeclarationContext?.type(): String? {
    if (this == null) return null

    return unannType()?.text
}

fun Java8Parser.FieldDeclarationContext?.name(): String? {
    if (this == null) return null

    return variableDeclaratorList()?.variableDeclarator()?.get(0)?.variableDeclaratorId()?.text
}

fun Java8Parser.FieldDeclarationContext?.value(): String? {
    if (this == null) return null

    return variableDeclaratorList()?.variableDeclarator()?.get(0)?.variableInitializer()?.text
}

fun Java8Parser.FieldDeclarationContext?.jsonable(): Boolean {
    if (this == null) return true

    return unannType()?.text?.toDartType() in listOf(
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