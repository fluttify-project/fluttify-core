package common.extensions

import Framework
import Jar
import common.PATH
import common.PRESERVED_MODEL
import common.TYPE_NAME
import common.model.JavaTypeInfo
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
        "Map<String,dynamic>",
        "Map",
        "null",
        "List<int>",
        "List<double>",
        "List<String>",
        "Uint8List",
        "Uint32List",
        "Uint64List"
    )
}

/**
 * 是否是集合类型
 */
fun TYPE_NAME.isList(): Boolean {
    return Regex("\\w*List<\\w*>").matches(this)
}

/**
 * 是否是未知类型, 即非当前sdk内的类
 */
fun TYPE_NAME.isUnknownType(): Boolean {
    return !(Jar.Decompiled.classes.containsKey(this) || jsonable())
}

/**
 * 是否是枚举类
 */
fun TYPE_NAME.isEnum(): Boolean {
    return Jar.Decompiled.classes[this]?.isEnum == true
}

/**
 * 获取内部类的类名, 如果没有内部类的话, 那么就使用原名
 */
fun TYPE_NAME.innerClass(): String {
    return substringAfterLast("$")
}

/**
 * 转kotlin类型
 */
fun TYPE_NAME.toKotlinType(): String {
    return when (this) {
        "void" -> "Unit"
        else -> this.capitalize()
    }
}

/**
 * 判断一个类名是否是被混淆过的
 *
 * 规则为判断文件名长度是否是1或者2且仅包含小写字母
 */
fun TYPE_NAME.isObfuscated(): Boolean {
    val types = split("$")
    val regex = Regex("[a-z]{1,2}")
    return types.any { regex.matches(it) }
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
        "ArrayList<String>" -> "List<String>"
        "List<String>" -> "List<String>"
        "byte[]", "Byte[]", "int[]", "Int[]", "long[]", "Long[]" -> "List<int>"
        "double[]", "Double[]", "float[]", "Float[]" -> "List<double>"
        "Map" -> "Map"
        "Bundle" -> "Map<String,dynamic>"
        "Bitmap" -> "Uint8List"
        "void" -> "String"
        null -> "null"
        else -> {
            if (Regex("ArrayList<\\w*>").matches(this)) {
                removePrefix("Array")
            } else {
                this
            }
        }
    }.replace("$", "_")
}

/**
 * 从java类型获取类型信息
 */
fun TYPE_NAME.javaTypeInfo(): JavaTypeInfo? {
    return Jar.Decompiled.classes[this]
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
        // 正则表达式: 匹配所有`##`包围的字符, 但是被包围的字符中不能有`#` 如果replacement中有`$`符号时, 会报错, 替换掉`$`
        result = result.replaceFirst(Regex("#[^#]*#"), it?.replace("\$", "_") ?: "")
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
 * 类型名判断是否是java引用类型
 */
fun TYPE_NAME.isJavaRefType(): Boolean {
    return !isJavaModelType()
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

fun String.builder(): StringBuilder {
    return StringBuilder(this)
}