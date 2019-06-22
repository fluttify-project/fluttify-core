package common.extensions

import Framework
import Jar
import common.PATH
import common.PRESERVED_MODEL
import common.TYPE_NAME
import java.io.File

fun String?.isLiteral(): Boolean {
    return when {
        this == null -> false
        Regex("(\\d)+").matches(this) -> true
        this in listOf("null", "nil") -> true
        else -> false
    }
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
        "List<int>",
        "List<double>",
        "void"
    )
}

/**
 * java或objc可json序列化类型转为dart可json序列化类型
 */
fun TYPE_NAME?.toDartType(): TYPE_NAME {
    // 目前只关心java类型, 扩展到ios端后处理oc类型
    return when (this) {
        "String" -> "String"
        "boolean", "Boolean" -> "bool"
        "byte", "Byte", "int", "Integer", "long", "Long" -> "int"
        "double", "Double", "float", "Float" -> "double"
        "List<Byte>", "List<Integer>", "List<Long>", "ArrayList<Byte>", "ArrayList<Integer>", "ArrayList<Long>" -> "List<int>"
        "byte[]", "Byte[]", "int[]", "Int[]", "long[]", "Long[]" -> "List<int>"
        "double[]", "Double[]", "float[]", "Float[]" -> "List<double>"
        "Map" -> "Map"
        "void" -> "void"
        null -> "null"
        else -> this
    }
}

/**
 * 获取泛型类型名称
 */
fun TYPE_NAME.genericType(): TYPE_NAME {
    return if (contains("<") && contains(">")) {
        substringAfter("<").run { substringBefore(">") }
    } else {
        this
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
 * 下划线风格转为驼峰风格
 */
fun String.camel2Underscore(): String {
    if ("" == trim()) {
        return ""
    }
    val len = this.length
    val sb = StringBuilder(len)
    for (i in 0 until len) {
        val c = this[i]
        if (Character.isUpperCase(c)) {
            if (i != 0) sb.append("_")
            sb.append(Character.toLowerCase(c))
        } else {
            sb.append(c)
        }
    }
    return sb.toString()
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
 * 批量替换字符串 数组分为两部分, 前半部分为被替换的, 后半部分为替换的
 */
fun String.replaceBatch(vararg sourcesAndDestination: String): String {
    if (sourcesAndDestination.size % 2 != 0) throw IllegalArgumentException("参数个数应为偶数个")

    val sources = sourcesAndDestination.asList().subList(0, sourcesAndDestination.size / 2)
    val destinations =
        sourcesAndDestination.asList().subList(sourcesAndDestination.size / 2, sourcesAndDestination.size)

    var result = this
    for (index in 0 until sources.size) {
        result = result.replace(sources[index], destinations[index])
    }

    return result
}

/**
 * 类型名判断是否是java model
 */
fun TYPE_NAME.isJavaModelType(): Boolean {
    // 如果是系统知道的模型类, 那么直接返回true
    if (PRESERVED_MODEL.contains(this)) return true

    // 如果是可以直接json序列化的, 那么直接就返回true
    if (jsonable()) return true

    return Jar
        .Decompiled
        .classes[this]
        ?.path
        ?.file()
        ?.readText()
        ?.isJavaModel() == true
}

/**
 * 类型名判断是否是objc model
 */
fun TYPE_NAME.isObjcModelType(): Boolean {
    // 如果是可以直接json序列化的, 那么直接就返回true
    if (jsonable()) return true

    return Framework
        .classes[this]
        ?.path
        ?.file()
        ?.readText()
        ?.isObjcModel() ?: false
}

/**
 * 路径字符串转为文件
 *
 * 如果文件不存在:
 *     如果路径以"/"结尾, 那么创建文件夹
 *     如果不以"/"结尾, 那么创建文件
 * 如果文件存在:
 *     返回文件
 */
fun PATH.file(): File {
    val file = File(this)
    if (!file.exists()) {
        if (endsWith("/")) {
            file.mkdirs()
        } else {
            // 如果是文件, 那么获取文件上级文件夹, 检查是否存在, 不存在就先创建文件夹, 再创建文件
            val dir = File(substringBeforeLast("/"))
            if (!dir.exists()) {
                dir.mkdirs()
            }
            file.createNewFile()
        }
    }
    return file
}
