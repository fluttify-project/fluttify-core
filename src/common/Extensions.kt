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

fun String.placeholder(vararg replacements: String): String {
    var result = this
    replacements.forEach {
        // 正则表达式: 匹配所有`##`包围的字符, 但是被包围的字符中不能有`#`
        result = result.replaceFirst(Regex("#[^#]*#"), it)
    }
    return result
}