package me.yohom.fluttify.extensions

import com.google.gson.Gson
import me.yohom.fluttify.*
import me.yohom.fluttify.model.*
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory

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
        "Map<String,Object>",
        "Map<String,int>",
        "Map<String,Int8List>",
        "Map<String,Int32List>",
        "Map<String,Int64List>",
        "Map<String,Uint8List>",
        "Map<String,Uint32List>",
        "Map<String,Uint64List>",
        "Map<String,dynamic>",
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
        // 这里加上数组类型的列表类型, 虽然不是最终解决方案, 但是应该也能覆盖99%的场景了
        "List<Uint8List>",
        "List<Uint32List>",
        "List<Uint64List>",
        "List<Int32List>",
        "List<Int64List>",
        "List<Float64List>",
        // 把Object列为jsonable, 解决参数为Object时的情况, 因为jsonable类型会自动在平台间进行转换,
        // 所以兼容起jsonable和非jsonable的类型比较麻烦, 这里规定只要是java.lang.Object的参数,
        // 一律断言为jsonable类型并且实际的类型也必须要是jsonable才能在Channel中传递
        "Object"
    )
}

/**
 * 是否是集合类型
 */
fun TYPE_NAME.isIterable(): Boolean {
    return Regexes.ITERABLE.matches(this)
}

/**
 * 是否是枚举集合类型
 */
fun TYPE_NAME.isEnumList(): Boolean {
    return isIterable() && genericTypes().isNotEmpty() && genericTypes()[0].findType().isEnum
}

/**
 * 是否是列表类型
 */
fun TYPE_NAME.isList(): Boolean {
    return Regex("(Array)?List<(\\w*|.*)>").matches(this)
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
 * 是否是void类型
 */
fun TYPE_NAME.isVoid(): Boolean {
    return this.toLowerCase() == "void" || this == "java.lang.Void"
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
fun TYPE_NAME.enList(level: Int = 1): TYPE_NAME {
    var result = this
    for (i in 0 until level) {
        result = "List<$result>"
    }
    return result
}

/**
 * 是否是数组
 */
fun TYPE_NAME.isArray(): Boolean {
    return endsWith("[]")
}

/**
 * 是否是数组
 */
fun TYPE_NAME.isRefArray(): Boolean {
    return isArray()
            &&
            this != "byte[]" && this != "int[]" && this != "long[]" && this != "double[]" && this != "float[]" && this != "char[]"
}

/**
 * 是否是Map类型
 */
fun TYPE_NAME.isMap(): Boolean {
    return Regex("(java\\.util\\.(Hash)?Map|NS(Mutable)?Dictionary)(\\u003c.*,.*\\u003e)?\\*?").matches(
        pack()
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
        "void" -> "Void"
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
fun TYPE_NAME.deSquareBracket(): TYPE_NAME {
    return removeSuffix("[]")
}

/**
 * 去掉:
 */
fun TYPE_NAME.deColon(): TYPE_NAME {
    return replace(":", "")
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
private val findTypeCache = mutableMapOf<String, Type>()
fun TYPE_NAME.findType(): Type {
    if (findTypeCache.containsKey(this) && ENABLE_CACHE) {
        if (CACHE_LOG) println("findType命中缓存: $this -> ${findTypeCache[this]!!.name}")
        return findTypeCache[this]!!
    }

    val type = depointer().deprotocol()
    val result = if (type.genericTypes().isNotEmpty()) {
        // 说明有泛型, 合成一个新的类
        val containerType = SDK.findType(type.containerType())

        // 要使用克隆对象, 因为定义的泛型类可能不止一个, 如果直接在原对象上操作的话, 那么后续的泛型类可能会受影响
        val clonedContainerType = containerType.toJson().fromJson<Type>()

        val definedGenericTypes = type.genericTypes().toMutableList()
        clonedContainerType.definedGenericTypes = definedGenericTypes
        // 类内的方法有用到泛型的把声明的泛型也替换成定义的泛型
        clonedContainerType.methods
            .flatMap { it.formalParams }
            .map { it.variable }
            // 过滤出所有用到类泛型的方法的参数 这里使用rawType代替trueType防止循环调用
            .filter { it.rawType in clonedContainerType.declaredGenericTypes }
            .forEach {
                // 找出当前声明泛型在泛型列表中的位置
                val genericTypePosition =
                    clonedContainerType.declaredGenericTypes.indexOf(it.rawType)
                // 按照这个位置再从定义泛型列表中拿到定义的泛型, 并重新设置给方法参数
                if (genericTypePosition < definedGenericTypes.size) {
                    it.defineGenericType(definedGenericTypes[genericTypePosition])
                } else {
                    it.defineGenericType(it.platform.objectType())
                }
            }
        clonedContainerType
    } else {
        val result = SDK.findType(type)

        // 如果类型没有指定泛型, 却发现是泛型类, 那么把泛型类型全部替换成Object类
        if (result.declaredGenericTypes.isNotEmpty()) {
            val clonedContainerType = result.toJson().fromJson<Type>()

            clonedContainerType.definedGenericTypes.replaceAll { result.platform.nativeObjectType() }
            // 类内的方法有用到泛型的把声明的泛型也替换成定义的泛型
            clonedContainerType.methods
                .flatMap { it.formalParams }
                .map { it.variable }
                // 过滤出所有用到类泛型的方法的参数 这里使用rawType代替trueType防止循环调用
                .filter { it.rawType in clonedContainerType.declaredGenericTypes }
                .forEach {
                    // 全部替换成各平台的Object类型
                    it.defineGenericType(clonedContainerType.platform.nativeObjectType())
                }
            clonedContainerType
        } else {
            result
        }
    }
    findTypeCache[this] = result

    return result
}

fun TYPE_NAME.ifIsGenericTypeConvertToObject(): String {
    // TODO 对应参数类型是泛型的workaround, 判断类型名长度是否为1, 如果是的话, 则替换为Object, 这个需要后期完善一下
    return if (isNotEmpty() && length != 1) {
        this
    } else {
        "java.lang.Object"
    }
}

/**
 * 获取与当前类名关联的所有类型信息
 */
fun TYPE_NAME.allTypes(): List<Type> {
    val containerTypes = deSquareBracket().containerType().findType()
    val genericTypes = deSquareBracket().genericTypes().map { it.findType() }
    return genericTypes
        .union(listOf(containerTypes))
        .toList()
}

/**
 * 是否是值类型(相对指针类型)
 */
fun TYPE_NAME.isValueType(): Boolean {
    return (this in listOf(
        "int",
        "float",
        "double",
        "long",
        "BOOL",
        "bool",
        "unsigned long long",
        "unsigned int",
        "unsigned long",
        "long long",
        "GLuint",
        "CGFloat",
        "NSUInteger",
        "NSInteger"
    )) or (this in SYSTEM_TYPEDEF.keys && this !in SYSTEM_POINTER_TYPEDEF.keys) or findType().run { isEnum or isAlias() }
}


/**
 * 是否是值类型的指针类型(相对objc指针类型)
 */
fun TYPE_NAME.isPrimitivePointerType(): Boolean {
    /**
     * 是否是C的指针类型(相对objc指针类型)
     *
     * 先判断是否是c类型, 然后判断是不是`*`结尾
     */
    fun TYPE_NAME.isCPointerType(): Boolean {
        // 防止循环递归调用, 这里重复一下isValueType方法的实现
        val isValueType = ((pack() in listOf(
            "int*",
            "float*",
            "double*",
            "BOOL*",
            "CGFloat*"
        )) || (this in SYSTEM_TYPEDEF.map { it.key.enpointer() }))
        val isVoidPointer = Regex("(const)?void\\*").matches(pack())

        return isVoidPointer || isValueType
    }

    // 原始类型的指针类型和结构体的指针类型还是有点区别, 比如说结构体在dart端是生成的类的, 而原始类型是没有类的, 所以这边还是区分对待好了
    val isVoidPointer = Regex("(const)?void\\*").matches(pack())
    val isCPointer = isCPointerType()
    val isSystemTypedefPointer = this in SYSTEM_TYPEDEF.map { it.key.enpointer() }
            || this in SYSTEM_POINTER_TYPEDEF.keys
    return isVoidPointer || isCPointer || isSystemTypedefPointer/* || isStructPointer*/
}

/**
 * 压缩字符串, 即去掉所有的空格
 */
fun String.pack(): String {
    return replace(Regex("\\s*|\t|\r|\n"), "")
}

/**
 * 判断一个类名是否是被混淆过的
 *
 * 规则为判断文件名长度是否是1或者2且仅包含小写字母
 */
fun TYPE_NAME.isObfuscated(): Boolean {
    // 如果类名不包含`.`, 说明是泛型类型, 则不认为是混淆类
    if (!contains(".")) return false

    // 容器类型+泛型类型
    val genericTypes = genericTypes()
        .map { it.replace("$", ".").substringAfterLast(".") }
    val containerType = containerType().replace("$", ".").substringAfterLast(".")
    val regex = Regex("[a-z|\\d]{0,3}")
    // objc的id类型不作为混淆类型, 如果java有个类叫id也没关系, 因为肯定会有包名在前面
    return this !in ext.obfuscatedWhiteList
            &&
            (regex.matches(containerType) || regex.matches(this) || genericTypes.any { it.isObfuscated() })
            &&
            this != "id"
}

/**
 * 判断一个文件是否是被混淆过的
 *
 * 规则为判断文件名长度是否是1或者2且仅包含小写字母
 */
fun String.isObfuscatedFile(): Boolean {
    val parts = split("$")
    val regex = Regex("^[a-z|\\d]{0,3}")
    return parts.any { regex.matches(it) || it in JAVA_RESERVED }
}

/**
 * 判断一个方法名是否是被混淆过的
 *
 * 规则为判断文件名长度是否是1或者2且仅包含小写字母
 */
fun String.isObfuscatedMethod(): Boolean {
    val regex = Regex("[a-zA-Z|\\d]{0,2}")
    return regex.matches(this)
}

/**
 * java或objc可json序列化类型转为dart可json序列化类型
 */
fun TYPE_NAME.toDartType(): TYPE_NAME {
    // 如果是系统别名就先取出原始类型, 否则就直接使用
    return (SYSTEM_TYPEDEF[this] ?: this).pack()
        .run {
            when {
                // java
                Regex("String").matches(this) -> "String"
                Regex("[Bb]oolean").matches(this) -> "bool"
                Regex("(unsigned)?([Bb]yte|[Ii]nt|Integer|[Ll]ong)").matches(this) -> "int"
                Regex("[Dd]ouble|[Ff]loat").matches(this) -> "double"
                Regex("java\\.util\\.(Collection|(Array)?List)\\u003c(Byte|Integer|Long)\\u003e").matches(
                    this
                ) -> "List<int>"
                Regex("java\\.util\\.(Collection|(Array)?List)\\u003c(Float|Double)\\u003e").matches(
                    this
                ) -> "List<double>"
                Regex("java\\.util\\.(Collection|(Array)?List)\\u003cString\\u003e|String\\[]").matches(
                    this
                ) -> "List<String>"
                Regex("[Bb]yte\\[]").matches(this) -> "Uint8List"
                Regex("(int|Integer)\\[]").matches(this) -> "Int32List"
                Regex("[Ll]ong\\[]").matches(this) -> "Int64List"
                Regex("([Dd]ouble|[Ff]loat)\\[]").matches(this) -> "Float64List"
                Regex("java\\.util\\.(Hash)?Map").matches(this) -> "Map"
                Regex(".*\\[]").matches(this) -> deSquareBracket().enList() // 数组转列表
                Regex("java\\.lang\\.Object").matches(this) -> "Object" // 这里为什么要转为dart的Object在36行有说明
                Regex("java\\.lang\\.Void").matches(this) -> "void"
                Regex("java\\.(\\w|\\.)*(List|Iterable|Collection)(<java\\.lang\\.Object>)?").matches(
                    this
                ) -> "List<dynamic>"
                // 若是某种java的List, 那么去掉前缀, 然后转换泛型类型
                Regex("java\\.(\\w|\\.)*(List|Iterable|Collection)\\u003c.*\\u003e").matches(this) -> {
                    val genericType = genericTypes()[0]
                    "List<${genericType.toDartType()}>"
                }
                Regex("java\\.util\\.Collection\\u003c.+\\u003e").matches(this) -> replace(
                    "java.util.Collection",
                    "List"
                )
                Regex("java\\.lang\\.Iterable\\u003c.+\\u003e").matches(this) -> replace(
                    "java.lang.Iterable",
                    "List"
                )

                // objc
                Regex("NSString\\*?").matches(this) -> "String"
                Regex("NS(Mutable)?Array\\u003cNSString\\*?\\u003e\\*?").matches(this) -> "List<String>"
                Regex("nil").matches(this) -> "null"
                Regex("id").matches(this) -> "dynamic"
                Regex("NS(Mutable)?Array\\*?").matches(this) -> "List<dynamic>"
                Regex("NS(U)?Integer").matches(this) -> "int"
                Regex("NSNumber\\*?").matches(this) -> "num"
                Regex("NSArray\\u003cNSNumber\\*\\u003e\\*").matches(this) -> "List<num>"
                Regex("u?int(32|64)?(_t)?").matches(this) -> "int"
                // 因为已经被pack, 所以要去掉空格
                Regex("(unsigned)?longlong").matches(this) -> "int"
                Regex("(unsigned)?int").matches(this) -> "int"
                Regex("BOOL").matches(this) -> "bool"
                Regex("CGFloat").matches(this) -> "double"
                Regex("NS(Mutable)?Dictionary\\*").matches(this) -> "Map"
                Regex("(java\\.util\\.(Hash)?Map|NS(Mutable)?Dictionary)(\\u003c.+,.+\\u003e)(\\*)?").matches(
                    this
                ) -> {
                    val keyType = substringAfter("\u003c").substringBefore(",").toDartType()
                    val valueType = substringAfter(",").substringBefore("\u003e").toDartType()
                    "Map<$keyType,$valueType>"
                }
                Regex("NSArray\\u003c.+\\u003e\\*?").matches(this) -> "List<${genericTypes()[0].toDartType()}>"
                Regex("(float|double|int|void)\\*").matches(this) -> "NSValue/* $this */"
                Regex("id\\u003c.+\\u003e").matches(this) -> removePrefix("id<").removeSuffix(">")
                Regex("GLuint").matches(this) -> "int"

                // 通用
                findType().isAlias() -> findType().aliasOf!!.toDartType()
                // 是否是结构体指针
                findType().isStruct && endsWith("*") -> findType().name.depointer().enList()
                genericTypes().isNotEmpty() -> "${containerType()}<${genericTypes().joinToString(",") { it.toDartType() }}>"
                else -> this
            }
        }
        .replace(Regex("java\\.util\\.(Collection|(Array)?List)"), "List")
        .replace(Regex("java\\.util\\.(Hash)?Map"), "Map")
        .replace(Regex("java\\.lang\\.Object"), "Object")
        .replace(Regex("NSMutableArray"), "List")

        .replace("$", ".")
        .replace(".", "_")
        .removePrefix("struct") // 不明原因结构体可能会出现struct前缀
        .depointer()
        .deprotocol()
}

fun TYPE_NAME.toUnderscore(): String {
    return replace(Regex("[$.<>,|]"), "_")
}

fun TYPE_NAME.isStructPointer(): Boolean {
    return findType().isStruct && endsWith("*")
}

/**
 * 添加可空'?'
 */
fun TYPE_NAME.enOptional(optional: Boolean = true): String {
    if (!optional) return this
    return if (isOneOf("void", "dynamic")) this else "${this}?"
}

/**
 * 去除指针类型的`*`号
 */
fun String.depointer(): String {
    return removePrefix("*")
        .removeSuffix("*").removeSuffix("*") // 有可能多级指针
}

/**
 * 去除OC中协议的`<>`号
 */
fun String.deAngleBracket(): String {
    return removePrefix("<").removeSuffix(">")
}

/**
 * 去除协议类型的id<>
 */
fun String.deprotocol(): String {
    return if (startsWith("id<")) removePrefix("id<").removeSuffix(">") else this
}

/**
 * 是否是排除类
 */
fun String.isExcludedType(): Boolean {
    return ext.android.exclude.classes.union(ext.ios.exclude.classes)
        .any { Regex(it).matches(this) }
}

/**
 * 加上协议类型的id<>
 */
fun String.enprotocol(): String {
    // 不重复添加id<>
    return if (Regex("id<.*>").matches(this)) this else "id<${this}>"
}

/**
 * 为指针类型加上`*`号
 */
fun TYPE_NAME.enpointer(): TYPE_NAME {
    return if (endsWith("*") || Regex("id(<\\w+>)?").matches(this)) this else "$this*"
}

/**
 * 获取泛型列表
 *
 * 根据[level]获取对应层级的泛型类型, 如果为null就获取到最内层的泛型. 如果没有泛型则返回空列表.
 */
fun TYPE_NAME.genericTypes(level: Int? = null): List<TYPE_NAME> {
    var result = this
    if (level != null) {
        for (i in 0 until level) {
            result = result.substringAfter("<").substringBeforeLast(">")
        }
    } else {
        result = result.substringAfter("<").substringBeforeLast(">")
    }
    return if (result == this) listOf() else result.split(",")
}

/**
 * 获取最内层泛型
 */
fun TYPE_NAME.innermostGenericType(): TYPE_NAME {
    var result = this
    while (result.contains("<") && result.contains(">")) {
        result = result.substringAfter("<").substringBeforeLast(">")
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
fun String.removeNumberSuffix(): TYPE_NAME {
    return removeSuffix("L")
        .removeSuffix("F")
        .removeSuffix("D")
        .removeSuffix("U")
}

/**
 * 字符串常量转义
 */
fun String.escape(): TYPE_NAME {
    return replace("$", "\\$")
}

/**
 * 去除objc的限定词
 */
fun TYPE_NAME.removeObjcSpecifier(): TYPE_NAME {
    return replace("__nullable", "")
        .replace("__nonnull", "")
        .replace("_Nullable", "")
        .replace("_Nonnull", "")
        .replace("nullable", "")
        .replace("nonnull", "")
        .replace("*__autoreleasing", "")
        .replace("__autoreleasing", "")
        .replace("FOUNDATION_EXPORT", "")
}

/**
 * 获取泛型层数 用在List中 表示嵌套了几层
 */
fun TYPE_NAME.iterableLevel(): Int {
    var result = this
    var level = 0
    if (isIterable()) {
        while (result.contains("<") && result.contains(">")) {
            result = result.substringAfter("<").substringBeforeLast(">")
            level++
        }
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
//        println("PATH.file(): 文件${this}不存在")
        if (endsWith("/")) {
//            println("PATH.file(): 路径以\\结尾, 创建文件夹${this}")
            file.mkdirs()
        } else {
//            println("PATH.file(): 创建文件${this}")
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

/**
 * 为一些类限定词增加前后的空格, 这么做的原因是类限定词会跟类名粘在一起, 所以要加下空格
 */
fun String.objcSpecifierExpand(): String {
    return replace("__kindof", "")
        .replace("__nullable", "")
        .replace("__nonnull", "")
        .replace("_Nullable", "")
        .replace("_Nonnull", "")
        .replace("nullable", "")
        .replace("nonnull", "")
        .replace("__autoreleasing", "")
        .replace("unsignedint", "unsigned int")
        .replace("constvoid*", "const void*")
        .replace("unsignedlonglong", "unsigned long long")
        .replace("unsignedlong", "unsigned long")
        .replace("unsignedint", "unsigned int")
        .replace("longlong", "long long")
}

fun String.isDynamic(): Boolean {
    val dartType = toDartType()
    return dartType == "dynamic" || dartType == "List<dynamic>"
}

/**
 * 是否是多级指针
 */
fun String.isMultiPointer(): Boolean {
    return contains("**")
}

/**
 * 解析SDK
 */
fun String.parseSDK(): SDK {
    var result = this
    for (entry in ext.android.overrideElements.entries) {
        result = result.replace(Regex(entry.key), entry.value)
    }
    for (entry in ext.ios.overrideElements.entries) {
        result = result.replace(Regex(entry.key), entry.value)
    }
    return result.removeObjcSpecifier().fromJson()
}

class RootObject {
    var doxygen: DoxygenType? = null
}

/**
 * 从文件(夹)解析SDK
 */
fun File.parseSDK(): SDK {
    if (isFile) {
        return readText().parseSDK()
    } else if (isDirectory) {
        val sdk = SDK().also {
            it.platform = if (path.contains("ios")) {
                Platform.iOS
            } else if (path.contains("android")) {
                Platform.Android
            } else {
                Platform.General
            }
        }
        val lib = Lib().also {
            sdk.libs.add(it)
            it.name = nameWithoutExtension
        }
        var successCount = 0
        var errorCount = 0
        for (item in listFiles()!!) {
            if (item.extension != "xml") continue
            if (item.name == "Doxyfile.xml") continue
            if (item.name == "index.xml") continue
            try {
                val sourceFile = SourceFile().also {
                    lib.sourceFiles.add(it)

                    it.fileName = item.nameWithoutExtension
                }

                val doc = DocumentBuilderFactory.newInstance()
                    .newDocumentBuilder()
                    .parse(item)
                val doxygenRoot = doc.getElementsByTagName("doxygen").item(0)
                sourceFile.types = doxygenRoot.types()
                    .union(doxygenRoot.enums())
                    .union(doxygenRoot.topLevelFunctions())
                    .union(doxygenRoot.typedefs())
                    .toList()
                sourceFile.topLevelConstants = doxygenRoot.topLevelConstants()
                successCount++
            } catch (e: Exception) {
                errorCount++
                println("解析过程出现错误: $item, $e, ${e.stackTraceToString()}")
                continue
            }
        }
        println("成功数: $successCount, 失败数: $errorCount")
        return sdk
    } else {
        throw Exception("文件类型错误")
    }
}

/**
 * 变量名为id的情况
 */
fun String.objcId(): String {
    return if (this == "id") "id__" else this
}

fun String.replaceGlobal(platform: Platform? = null): String {
    return replace("#__project_name__#", ext.projectName)
        .replace("#__project_prefix__#", ext.projectName.underscore2Camel())
        .replace("#__tag__#", ext.projectName)
        .replace("#__channel_name__#", ext.methodChannelName)
        .replace("#__current_package__#", ext.projectName)
        .run {
            if (platform != null) replace(
                "#__platform__#",
                platform.toString().capitalize()
            ) else this
        }
}

fun String.isOneOf(vararg candidates: String): Boolean {
    return candidates.contains(this)
}