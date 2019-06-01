package common.extensions

import common.PATH
import common.TYPE_NAME
import preprocess.Jar
import java.io.File

fun String?.log() {
    if (this == null) println("") else println(this)
}

/**
 * 是否可序列化
 */
fun TYPE_NAME?.jsonable(): Boolean {
    return this?.toDartType() in listOf(
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

/**
 * java或objc可json序列化类型转为dart可json序列化类型
 */
fun TYPE_NAME?.toDartType(): TYPE_NAME {
    return when (this) {
        "BOOL", "boolean" -> "bool"
        "int" -> "int"
        "double", "float" -> "double"
        "NSString*", "String" -> "String"
        "NSArray*", "List", "ArrayList" -> "List"
        "NSDictionary*", "Map" -> "Map"
        "byte[]", "Byte[]" -> "Uint8List"
        "int[]", "Int[]" -> "Int32List"
        "long[]", "Long[]" -> "Int64List"
        "double[]", "Double[]" -> "Float64List"
        "void" -> "void"
        null -> "null"
        else -> this
    }
}

/**
 * 下划线风格转为驼峰风格, [capitalized]表示转换后首字母是否大写
 */
fun String.underscore2Camel(capitalized: Boolean = true): String {
    val raw = split("_").joinToString("") { it.capitalize() }
    return if (capitalized) raw else raw.decapitalize()
}

/**
 * 替换模板字符串中的占位符
 */
fun String.placeholder(vararg replacements: String?): String {
    var result = this
    replacements.forEach {
        // 正则表达式: 匹配所有`##`包围的字符, 但是被包围的字符中不能有`#`
        result = result.replaceFirst(Regex("#[^#]*#"), it ?: "")
    }
    return result
}

/**
 * 类型名判断是否是model
 */
fun TYPE_NAME.isModelType(): Boolean {
    // 如果是可以直接json序列化的, 那么直接就返回true
    if (jsonable()) return true

    return Jar
        .Decompiled
        .classes[this]
        ?.path
        ?.toFile()
        ?.readText()
        ?.isModel() ?: false
}

fun PATH.toFile(): File {
    val file = File(this)
    if (!file.exists()) {
        if (file.isDirectory)
            file.mkdirs()
        else if (file.isFile)
            file.createNewFile()
    }
    return file
}