package me.yohom.fluttify.extensions

import com.google.gson.Gson
import me.yohom.fluttify.PATH
import me.yohom.fluttify.SYSTEM_TYPEDEF
import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.model.SDK
import me.yohom.fluttify.model.Type
import java.io.File

inline fun <reified T> String.fromJson(): T {
    return Gson().fromJson(this, T::class.java)
}

/**
 * 是否可序列化
 */
fun TYPE_NAME.jsonable(): Boolean {
    return toDartType().pack() in listOf(
        "bool",
        "int",
        "double",
        "num",
        "String",
        "Map<String,String>",
        "Map",
        "null",
        "List<int>",
        "List<double>",
        "List<num>",
        "List<String>",
        "Uint8List",
        "Uint32List",
        "Uint64List",
        "Int32List",
        "Int64List",
        "Float64List",
        // 把Object列为jsonable, 解决参数为Object时的情况, 因为jsonable类型会自动在平台间进行转换,
        // 所以兼容起jsonable和非jsonable的类型比较麻烦, 这里规定只要是java.lang.Object的参数,
        // 一律断言为jsonable类型并且实际的类型也必须要是jsonable才能在Channel中传递
        "Object"
    )
}

/**
 * 是否是集合类型
 */
fun TYPE_NAME.isCollection(): Boolean {
    return Regex("\\w*List<(\\w*|.*)>").matches(this)
            || Regex("Iterable<(\\w*|.*)>").matches(this)
            || Regex("Collection<(\\w*|.*)>").matches(this)
            || Regex("NSArray.*\\*?").matches(this)
            || Regex("NSMutableArray.*\\*?").matches(this)
            || Regex("""\w+\[]""").matches(this)
}

/**
 * 是否是ArrayList类型
 */
fun TYPE_NAME.isArrayList(): Boolean {
    return Regex("ArrayList<(\\w*|.*)>").matches(this)
}

/**
 * 是否是列表类型
 */
fun TYPE_NAME.isList(): Boolean {
    return Regex("List<(\\w*|.*)>").matches(this)
}

/**
 * 是否是数字
 */
fun TYPE_NAME.isNumber(): Boolean {
    return toDoubleOrNull() != null
}

/**
 * 是否是字符串
 */
fun TYPE_NAME.isString(): Boolean {
    return Regex("\".*\"").matches(this)
}

/**
 * 是否是集合类型
 */
fun TYPE_NAME.isLinkedList(): Boolean {
    return Regex("LinkedList<(\\w*|.*)>").matches(this)
}

/**
 * 是否是void类型
 */
fun TYPE_NAME.isVoid(): Boolean {
    return this.toLowerCase() == "void";
}

/**
 * 是否是布尔类型
 */
fun TYPE_NAME.isBoolean(): Boolean {
    return toLowerCase() == "boolean" || toLowerCase() == "bool"
}

/**
 * 套上List<>
 */
fun TYPE_NAME.enList(): TYPE_NAME {
    return "List<$this>"
}

/**
 * 套上Collection<>
 */
fun TYPE_NAME.enCollection(): TYPE_NAME {
    return "Collection<$this>"
}

/**
 * 套上ArrayList<>
 */
fun TYPE_NAME.enArrayList(): TYPE_NAME {
    return "ArrayList<$this>"
}

/**
 * 套上[]
 */
fun TYPE_NAME.enArray(): TYPE_NAME {
    return "$this[]"
}

/**
 * 是否是数组
 */
fun TYPE_NAME.isArray(): Boolean {
    return endsWith("[]")
}

/**
 * 是否是Map类型
 */
fun TYPE_NAME.isMap(): Boolean {
    return Regex("\\w*Map(<*)\\w*(,*)\\w*(>*)").matches(this.pack()) || Regex("NSDictionary(<*)\\w*(,*)\\w*(>*)").matches(
        this.pack()
    )
}

/**
 * 是否是字符串数组 只有字符串数组需要在数组和列表之间手动转换, 基本类型flutter自动会转换
 */
fun TYPE_NAME.isStringArray(): Boolean {
    return this == "String[]"
}

/**
 * 装箱后的类型
 */
fun TYPE_NAME.boxedType(): TYPE_NAME {
    return when (this) {
        "byte" -> "Byte"
        "short" -> "Short"
        "int" -> "Integer"
        "long" -> "Long"
        "float" -> "Float"
        "double" -> "Double"
        "boolean" -> "Boolean"
        else -> this
    }
}

/**
 * 数组转为列表
 */
fun TYPE_NAME.stringArray2List(): TYPE_NAME {
    return if (this == "String[]") "List<${removeSuffix("[]")}>" else this
}

/**
 * 去掉[]
 */
fun TYPE_NAME.dearray(): TYPE_NAME {
    return removeSuffix("[]")
}

/**
 * 简写类名
 */
fun TYPE_NAME.simpleName(): String {
    return substringAfterLast(".")
}

/**
 * 父类类型
 */
fun TYPE_NAME.superTypes(): List<Type> {
    return findType().superTypes()
}

/**
 * 从类名获取类信息
 */
fun TYPE_NAME.findType(): Type {
    val type = depointer()
        .deprotocol()
        .let {
            if (it.isCollection()) {
                if (it.genericLevel() != 0) it.genericType() else ""
            } else {
                it
            }
        }
    return SDK.findType(type)
}

/**
 * 转kotlin类型
 */
fun TYPE_NAME.toKotlinType(): String {
    return when {
        this == "void" -> "Unit"
        this == "Integer" -> "Int"
//        this == "float" -> "Double" // 到kotlin的时候, 一律是Double
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
fun TYPE_NAME.isValueType(): Boolean {
    return (this in listOf(
        "int",
        "float",
        "double",
        "int64_t",
        "BOOL",
        "NSUInteger",
        "NSInteger",
        "CGFloat"
    )) or (this in SYSTEM_TYPEDEF) or findType().run { isEnum() or isAlias() }
}

/**
 * 是否是C的指针类型(相对objc指针类型)
 *
 * 先判断是否是c类型, 然后判断是不是`*`结尾
 */
fun TYPE_NAME.isCPointerType(): Boolean {
    return (depointer().isValueType() && endsWith("*")) || pack() == "constvoid*"
}

/**
 * 压缩字符串, 即去掉所有的空格
 */
fun String.pack(): String {
    return replace(" ", "")
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
    val regex = Regex("[a-z|\\d]{1,2}")
    // objc的id类型不作为混淆类型, 如果java有个类叫id也没关系, 因为肯定会有包名在前面
    return (regex.matches(type) || regex.matches(this)) && this != "id"
}

/**
 * java或objc可json序列化类型转为dart可json序列化类型
 */
fun TYPE_NAME.toDartType(): TYPE_NAME {
    return SYSTEM_TYPEDEF[this.depointer()]
        ?: when (this.pack()) {
            // android
            "String" -> "String"
            "boolean", "Boolean" -> "bool"
            "byte", "Byte", "int", "Integer", "long", "Long" -> "int"
            "double", "Double", "float", "Float" -> "double"
            "Collection<Byte>", "Collection<Integer>", "Collection<Long>", "List<Byte>", "List<Integer>", "List<Long>", "ArrayList<Byte>", "ArrayList<Integer>", "ArrayList<Long>" -> "List<int>"
            "ArrayList<String>", "String[]" -> "List<String>"
            "Collection<String>", "List<String>" -> "List<String>"
            "Collection<Float>", "Collection<Double>", "List<Float>", "List<Double>", "List<float>", "List<double>" -> "List<double>"
            "byte[]", "Byte[]" -> "Uint8List"
            "int[]", "Integer[]" -> "Int32List"
            "long[]", "Long[]" -> "Int64List"
            "double[]", "Double[]", "float[]", "Float[]" -> "Float64List"
            "Map" -> "Map"
            "java.lang.Object" -> "Object" // 这里为什么要转为dart的Object在36行有说明
            // objc
            "NSString", "NSString*" -> "String"
            "NSArray<NSString*>", "NSArray<NSString*>*", "NSMutableArray<NSString*>", "NSMutableArray<NSString*>*" -> "List<String>"
            "nil" -> "null"
            "id" -> "NSObject"
            "NSArray", "NSArray*", "NSMutableArray", "NSMutableArray*" -> "List"
            "NSInteger", "NSUInteger" -> "int"
            "NSNumber", "NSNumber*" -> "num"
            "int64_t" -> "int"
            "BOOL" -> "bool"
            "CGFloat" -> "double"
            else -> when {
                // 若是某种java的List, 那么去掉前缀
                Regex("(\\w*)List<.+>").matches(this) -> removePrefix(substringBefore("List<"))
                Regex("Collection<.+>").matches(this) -> replace("Collection", "List")
                Regex("NSDictionary<.+,.+>").matches(this) -> {
                    val keyType = substringAfter("<").substringBefore(",").toDartType()
                    val valueType = substringAfter(",").substringBefore(">").toDartType()
                    "Map<$keyType, $valueType>"
                }
                startsWith("NSArray") -> "List<${genericType().depointer()}>"
                Regex("id<.+>").matches(this) -> removePrefix("id<").removeSuffix(">")
                // 其他情况需要去掉泛型
                else -> this.substringBefore("<")
            }
        }
            .replace("$", ".")
            .replace(".", "_")
            .depointer()
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
 * 取出指针变量的值 也就是前面加`*`
 */
fun String.pointerValue(): String {
    return "* $this"
}

/**
 * 去除协议类型的id<>
 */
fun String.deprotocol(): String {
    return if (startsWith("id<")) removePrefix("id<").removeSuffix(">") else this
}

/**
 * 加上协议类型的id<>
 */
fun String.enprotocol(): String {
    return "id<${this}>"
}

/**
 * 为指针类型加上`*`号
 */
fun String.enpointer(): String {
    return if (endsWith("*")) this else "$this*"
}

/**
 * 获取泛型类型名称
 */
fun TYPE_NAME.genericType(): TYPE_NAME {
    var result = this
    while (result.contains("<") && result.contains(">")) {
        // NSDictionary(objc)相关类, 和Map(java)相关类作为普通类处理
        if (Regex("NS(Mutable)?Dictionary<(\\w|\\*)+,(\\w|\\*)+>").matches(this) || Regex("\\w*Map<\\w+,\\w+>").matches(this)) {
            break
        } else {
            result = result.substringAfter("<").substringBeforeLast(">")
        }
    }
    return result
}

/**
 * 获取泛型容器名称 比如List<Integer> -> List
 */
fun TYPE_NAME.containerType(): TYPE_NAME {
    return if (contains("<") && contains(">")) substringBefore("<") else this
}

/**
 * 去除数字后面的标识 (L/F/D等)
 */
fun TYPE_NAME.removeNumberSuffix(): TYPE_NAME {
    return removeSuffix("L").removeSuffix("F").removeSuffix("D")
}

/**
 * 获取泛型层数 用在List中 表示嵌套了几层
 */
fun TYPE_NAME.genericLevel(): Int {
    var result = this
    var level = 0
    while (result.contains("<") && result.contains(">")) {
        result = result.substringAfter("<").substringBeforeLast(">")
        level++
    }
    return level
}

/**
 * 下划线风格转为驼峰风格, [capitalized]表示转换后首字母是否大写
 */
fun String.underscore2Camel(capitalized: Boolean = true): String {
    val raw = trim { it == '_' } // 先去掉收尾的下划线
        .split("_")
        .joinToString("") { it.capitalize() }
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
    // 如果不小心多加了一个`/`, 那么替换一下
    val cleanPath = replace("//", "/")
    val file = File(cleanPath)
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

fun String.stripQuotes(): String {
    return replace("\"", "").replace("'", "")
}

fun String.isAndroidArchive(): Boolean {
    return endsWith("jar") || endsWith("aar")
}

fun String.isIOSArchive(): Boolean {
    return endsWith("framework")
}

/**
 * 为一些类限定词增加前后的空格, 这么做的原因是类限定词会跟类名粘在一起, 所以要加下空格
 */
fun String.objcSpecifierExpand(): String {
    return replace("__kindof", " __kindof ")
        .replace("_Nullable", " _Nullable ")
        .replace("_Nonnull", " _Nonnull ")
}

/**
 * 为一些类限定词增加前后的空格, 这么做的原因是类限定词会跟类名粘在一起, 所以要加下空格
 */
fun String.removeObjcSpecifier(): String {
    return replace("__kindof", "")
        .replace("_Nullable", "")
        .replace("_Nonnull", "")
        .pack()
}