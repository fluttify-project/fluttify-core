package generator.ios

internal fun String.toDartType(): String {
    return when (this) {
        "BOOL" -> "bool"
        "int" -> "int"
        "double" -> "double"
        "NSString*" -> "String"
        "NSArray*" -> "List"
        "NSDictionary*" -> "Map"
        else -> this
    }
}

internal fun String.jsonable(): Boolean {
    return this.toDartType() in listOf("bool", "int", "double", "String", "List", "Map", "void")
}