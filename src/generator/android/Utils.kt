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