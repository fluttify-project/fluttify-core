package common

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import parser.java8.Java8BaseListener
import parser.java8.Java8Lexer
import parser.java8.Java8Parser
import preprocess.Analyzer.jarSourcePath
import java.io.File

/**
 * 键值对转成dart的map字面量字符串
 */
fun List<Pair<String, String>>.toDartMap(): String {
    if (isEmpty()) return ""
    return joinToString(prefix = "{", postfix = "}") { "\"${it.second}\": ${it.second}" }
}

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
fun String.placeholder(vararg replacements: String): String {
    var result = this
    replacements.forEach {
        // 正则表达式: 匹配所有`##`包围的字符, 但是被包围的字符中不能有`#`
        result = result.replaceFirst(Regex("#[^#]*#"), it)
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

/**
 * 给一个类的文件名, 判断这个类是否是`model`
 */
fun String.isModel(): Boolean {
    if (this.substringAfterLast(".") != "java") return false

    var result = false

    // 判断返回类型是否是复杂类型
    val lexer = Java8Lexer(CharStreams.fromFileName(this))
    val parser = Java8Parser(CommonTokenStream(lexer))
    val tree = parser.compilationUnit()
    val walker = ParseTreeWalker()

    walker.walk(object : Java8BaseListener() {
        override fun enterInterfaceDeclaration(ctx: Java8Parser.InterfaceDeclarationContext?) {
            // 如果是接口, 那么就不是model
            result = false
        }

        override fun enterNormalClassDeclaration(ctx: Java8Parser.NormalClassDeclarationContext?) {
            // 如果类有继承或者实现的话, 暂时认为不是model
            if (ctx?.superclass() != null || ctx?.superinterfaces() != null) {
                result = false
            }

            // 抽象类不是model
            if (ctx?.classModifier()?.map { it.text }?.contains("abstract") == true) {
                result = false
            }
        }

        override fun enterConstructorDeclarator(ctx: Java8Parser.ConstructorDeclaratorContext?) {
            result = ctx?.formalParameterList()
                ?.formalParameters()
                ?.formalParameter()
                ?.isEmpty() ?: true
        }

        override fun enterFieldDeclaration(ctx: Java8Parser.FieldDeclarationContext?) {
            val fieldType = ctx?.unannType()?.text
            result = if (!fieldType.jsonable()) {
                fieldType?.findPath(jarSourcePath)?.isModel() ?: false
            } else {
                true
            }
        }
    }, tree)

    return result
}

//fun main() {
//    Analyzer.analyze()
//
//    println("isModel: " + "ConnectObservable".findPath(jarSourcePath).isModel())
//}