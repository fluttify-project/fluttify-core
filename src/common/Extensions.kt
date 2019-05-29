package common

fun List<Pair<String, String>>.toDartMap(): String {
    if (isEmpty()) return ""
    return joinToString(prefix = "{", postfix = "}") { "\"${it.second}\": ${it.second}" }
}

fun String.jsonable(): Boolean {
    return this.toDartType() in listOf("bool", "int", "double", "String", "List", "Map", "void")
}

fun String.toDartType(): String {
    return when (this) {
        "BOOL", "boolean" -> "bool"
        "int" -> "int"
        "double" -> "double"
        "NSString*", "String" -> "String"
        "NSArray*", "List" -> "List"
        "NSDictionary*", "Map" -> "Map"
        else -> this
    }
}

fun String.underscore2Camel(capitalized: Boolean = true): String {
    val raw = split("_").joinToString("") { it.capitalize() }
    return if (capitalized) raw else raw.decapitalize()
}