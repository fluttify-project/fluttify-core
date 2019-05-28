package generator.common

import generator.android.toDartType

fun List<Pair<String, String>>.toDartMap(): String {
    if (isEmpty()) return ""
    return joinToString(prefix = "{", postfix = "}") { "\"${it.second}\": ${it.second}" }
}

fun String.jsonable(): Boolean {
    return this.toDartType() in listOf("bool", "int", "double", "String", "List", "Map", "void")
}