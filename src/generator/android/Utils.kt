package generator.android

internal fun String.toDartType(): String {
    return when (this) {
        "boolean" -> "bool"
        "int" -> "int"
        "double" -> "double"
        "String" -> "String"
        "List" -> "List"
        "Map" -> "Map"
        else -> this
    }
}

internal fun String.jsonable(): Boolean {
    return this.toDartType() in listOf("bool", "int", "double", "String", "List", "Map", "void")
}

internal fun List<Pair<String, String>>.toDartMap(): String {
    if (isEmpty()) return ""

    val result = StringBuilder()
    result.append("{")
    forEach { result.append("${it.first}: ${it.second}, ") }
    result.append("}")
    return result.toString()
}