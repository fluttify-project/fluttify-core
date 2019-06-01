package common.extensions

import builtparser.JavaParser
import common.TYPE_NAME
import parser.java8.Java8BaseListener
import parser.java8.Java8Parser
import preprocess.Jar
import java.io.File

/**
 * 是否可序列化
 */
fun String?.jsonable(): Boolean {
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
fun String?.toDartType(): String {
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
 * 给一个类名, 找到其所在路径, [rootPath]为搜索的根路径
 */
fun String.findPath(rootPath: String): String {
    val jarSourceDir = File(rootPath)
    var result = ""
    for (file in jarSourceDir.listFiles() ?: arrayOf()) {
        if (file.isFile && file.nameWithoutExtension == this) {
            return file.absolutePath
        } else if (file.isDirectory) {
            result = findPath(rootPath + "/" + file.nameWithoutExtension)
            if (result.isNotEmpty()) {
                return result
            }
        }
    }
    return result
}

fun TYPE_NAME.isModel(): Boolean {
    // 如果是可以直接json序列化的, 那么直接就返回true
    if (jsonable()) return true

    var isAbstract = false
    var isSubclass = false
    var hasDependency = false
    val fieldJsonable: MutableList<Boolean> = mutableListOf()

    val parser = JavaParser(Jar.Decompiled.classes[this]?.path ?: return false)

    parser.walkTree(object : Java8BaseListener() {
        override fun enterInterfaceDeclaration(`interface`: Java8Parser.InterfaceDeclarationContext?) {
            // 如果是接口, 那么就不是model
            `interface`?.run {
                isAbstract = true
            }
        }

        override fun enterNormalClassDeclaration(`class`: Java8Parser.NormalClassDeclarationContext?) {
            `class`?.run {
                // 如果类有继承或者实现的话, 暂时认为不是model
                isSubclass = `class`.isSubclass()

                // 抽象类不是model
                isAbstract = `class`.isAbstract()
            }
        }

        override fun enterConstructorDeclarator(constructor: Java8Parser.ConstructorDeclaratorContext?) {
            constructor?.run {
                hasDependency = constructor.hasParameter()
            }
        }

        override fun enterFieldDeclaration(field: Java8Parser.FieldDeclarationContext?) {
            field?.run {
                if (field.isStatic()) return

                fieldJsonable.add(
                    if (!field.jsonable()) {
                        field.type()?.isModel() ?: false
                    } else {
                        true
                    }
                )
            }
        }
    })

    return if (isAbstract || isSubclass || hasDependency || fieldJsonable.isEmpty()) false
    else fieldJsonable.all { it }
}