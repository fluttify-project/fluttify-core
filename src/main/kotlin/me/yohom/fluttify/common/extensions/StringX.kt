package me.yohom.fluttify.common.extensions

import com.google.gson.Gson
import me.yohom.fluttify.common.PATH
import me.yohom.fluttify.common.SYSTEM_TYPEDEF
import me.yohom.fluttify.common.TYPE_NAME
import me.yohom.fluttify.common.model.SDK
import me.yohom.fluttify.common.model.Type
import java.io.File

fun String?.isLiteral(): Boolean {
    return when {
        this == null -> false
        Regex("(\\d)+").matches(this) -> true
        this in listOf("null", "nil") -> true
        else -> false
    }
}

inline fun <reified T> String.fromJson(): T {
    return Gson().fromJson(this, T::class.java)
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
    return Regex("\\w*List<(\\w*|.*)>").matches(this)
            || Regex("Iterable<(\\w*|.*)>").matches(this)
            || Regex("\\w*\\[]").matches(this)
            || Regex("NSArray.*\\*?").matches(this)
}

/**
 * 是否是集合类型
 */
fun TYPE_NAME.isArrayList(): Boolean {
    return Regex("ArrayList<(\\w*|.*)>").matches(this)
}

/**
 * 简写类名
 */
fun TYPE_NAME.simpleName(): String {
    return substringAfterLast(".")
}

/**
 * 从类名获取类信息
 */
fun TYPE_NAME.findType(): Type {
    return SDK.findType(this.depointer().deprotocol())
}

/**
 * 转kotlin类型
 */
fun TYPE_NAME.toKotlinType(): String {
    return when {
        this == "void" -> "Unit"
        this == "Integer" -> "Int"
        this == "float" -> "Double" // 到kotlin的时候, 一律是Double
        jsonable() -> capitalize()
        else -> this
    }.replace("[]", "Array")
}

/**
 * 转swift类型
 */
fun TYPE_NAME.toSwiftType(): String {
    var depointed = depointer()
    // 如果是形如id<XXX>的protocol的话, 那么去掉id<>
    if (contains("id<")) {
        depointed = depointed.removePrefix("id<").removeSuffix(">")
    }
    return when {
        depointed == "void" -> "Void"
        depointed == "NSInteger" -> "Int"
        depointed == "NSString" -> "String"
        depointed == "BOOL" -> "Bool"
        depointed in listOf("NSArray", "NSArray*") -> "[Any]"
        depointed.jsonable() -> capitalize()
        else -> depointed
    }
}

/**
 * 是否是值类型(相对指针类型)
 */
fun TYPE_NAME.isObjcValueType(): Boolean {
    return (this in listOf(
        "BOOL",
        "NSInteger",
        "NSUInteger",
        "CGFloat"
    )) or this.findType().isEnum() or isCType() or (this in SYSTEM_TYPEDEF)
}

/**
 * 是否是C类型
 */
fun TYPE_NAME.isCType(): Boolean {
    return (this in listOf(
        "int",
        "float",
        "double"
    ))
}

/**
 * 是否是c类型
 */
fun TYPE_NAME.toObjcType(): String {
    return when (this) {
//        "double" -> "NSNumber*"
//        "float" -> "NSNumber*"
//        "int" -> "NSNumber*"
        else -> this
    }
}

/**
 * objc方法名转swift名
 */
fun String.toSwiftMethod(): String {
    return if (!contains("with", true)) {
        // 如果不包含`with`的话, 那么就直接使用原来的方法名, 不需要转换
        "$this("
    } else {
        // 形如`xxWithXxx: (XXX)xx` 的方法, swift会转换为`xx(xxx: xx)`方法
        val methodNameBeforeWith = substringBefore("With")
        val methodNameAfterWith = substringAfter("With").decapitalize()
        "$methodNameBeforeWith($methodNameAfterWith: "
    }
}

/**
 * 判断一个类名是否是被混淆过的
 *
 * 规则为判断文件名长度是否是1或者2且仅包含小写字母
 */
fun TYPE_NAME.isObfuscated(): Boolean {
    val type = replace("$", ".").substringAfterLast(".")
    val regex = Regex("[a-z]{1,2}")
    return regex.matches(type) || regex.matches(this)
}

/**
 * java或objc可json序列化类型转为dart可json序列化类型
 */
fun TYPE_NAME?.toDartType(): TYPE_NAME {
    return SYSTEM_TYPEDEF[this?.depointer()] ?: when (this?.depointer()) {
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
        "void" -> "String"
        null -> "null"
        // 开始objc
        "NSString", "NSString*" -> "String"
        "nil" -> "null"
        "id" -> "Object"
        "NSArray", "NSArray*" -> "List"
        "NSInteger", "NSUInteger" -> "int"
        "BOOL" -> "bool"
        "CGFloat" -> "double"
        else -> {
            when {
                Regex("ArrayList<\\w*>").matches(this) -> removePrefix("Array")
                startsWith("NSArray") -> "List<${genericType().depointer()}>"
                Regex("id<\\w*>").matches(this) -> removePrefix("id<").removeSuffix(">")
                else -> this
            }
        }
    }.replace("$", ".").replace(".", "_").depointer()
}

fun TYPE_NAME.toUnderscore(): String {
    return replace("$", ".").replace(".", "_")
}

/**
 * 去除指针类型的`*`号
 */
fun String.depointer(): String {
    return removePrefix("*").removeSuffix("*")
}

/**
 * 去除协议类型的id<>
 */
fun String.deprotocol(): String {
    return removePrefix("id<").removeSuffix(">")
}

/**
 * 去除协议类型的id<>
 */
fun String.enprotocol(): String {
    return "id<${this}>"
}

/**
 * 为指针类型加上`*`号
 */
fun String.enpointer(): String {
    return if (endsWith("*")) this else "$this *"
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
 * objc命名规范改为swift命名规范, 这个没什么办法, 目前先枚举替换
 *
 * 比如 URL->url
 */
fun String.objc2SwiftSpec(): String {
    return replace("URL", "url")
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

fun String.replaceParagraph(oldValue: String, newValue: String): String {
    val oldValueLine = lines().firstOrNull { it.contains(oldValue) } ?: ""

    // 计算首行的缩进
    val indent = StringBuilder("")
    for (char in oldValueLine) {
        if (char.isWhitespace()) {
            indent.append(" ")
        } else {
            break
        }
    }

    return lines().joinToString("\n") {
        if (it.contains(oldValue))
            newValue
                .lines()
                .joinToString("\n") { line ->
                    line.prependIndent(indent.toString())
                }
        else
            it
    }
}
