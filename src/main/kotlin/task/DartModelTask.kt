package task

import common.DART_SOURCE
import common.JAVA_SOURCE
import common.Temps
import common.extensions.*
import common.gWalker
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import parser.java.JavaLexer
import parser.java.JavaParser
import parser.java.JavaParser.*
import parser.java.JavaParserBaseListener
import preprocess.OutputProject
import java.io.File

/**
 * Android模型类转换成对应的Dart模型类
 *
 * 输入: Java模型类文件
 * 输出: Dart模型类文件
 * 依赖: [RecognizeAndroidModelTask]
 */
class AndroidDartModelTask(private val javaModelFile: File) : Task<File, File>(javaModelFile) {
    private val results = mutableListOf<StringBuilder>()
    private var currentDepth = -1 // 嵌套类深度

    override fun process(): File {
        val javaContent = javaModelFile.readText()
        val dartModelSource = translate(javaContent)

        File(OutputProject.Dart.androidDartDirPath).run { if (!exists()) mkdirs() }

        return File("${OutputProject.Dart.androidDartDirPath}/${javaModelFile.nameWithoutExtension.camel2Underscore()}.dart")
            .apply {
                if (!exists()) createNewFile()
                writeText(dartModelSource)
            }
    }

    private fun translate(source: JAVA_SOURCE): DART_SOURCE {
        val lexer = JavaLexer(CharStreams.fromString(source))
        val parser = JavaParser(CommonTokenStream(lexer))
        val tree = parser.compilationUnit()

        gWalker.walk(object : JavaParserBaseListener() {
            //region 普通类
            // 生成类名
            override fun enterClassDeclaration(ctx: ClassDeclarationContext?) {
                results.add(StringBuilder())
                ctx?.run { results[++currentDepth].append(Temps.Dart.classDeclaration.placeholder(ctx.IDENTIFIER().text)) }
            }

            // 生成Field类型名
            override fun enterFieldDeclaration(field: FieldDeclarationContext?) {
                field?.run {
                    if (!type()!!.isModelType()) return

                    results[currentDepth].append("  ${if (isStatic()) "static " else ""}${type().toDartType()}")
                }
            }

            // 生成Field变量名和等于号(如果需要的话)
            override fun enterVariableDeclarator(ctx: VariableDeclaratorContext?) {
                ctx?.run {
                    results[currentDepth].append(" ${variableDeclaratorId().text}")
                }
            }

            // 生成Field的分号
            override fun exitFieldDeclaration(ctx: FieldDeclarationContext?) {
                ctx?.run {
                    if (!type()!!.isModelType()) return

                    results[currentDepth].append(";\n")
                }
            }

            // 生成类结束花括号
            override fun exitClassDeclaration(ctx: ClassDeclarationContext?) {
                ctx?.run { results[currentDepth--].append(Temps.Dart.classEnd) }
            }
            //endregion

            //region Enum类
            // 生成枚举类名
            override fun enterEnumDeclaration(`enum`: EnumDeclarationContext?) {
                results.add(StringBuilder())
                enum?.run { results[++currentDepth].append("\nenum ${enum.IDENTIFIER()} {\n") }
            }

            // 生成枚举值
            override fun enterEnumConstant(ctx: EnumConstantContext?) {
                ctx?.run { results[currentDepth].append("  ${ctx.IDENTIFIER()},\n") }
            }

            // 生成枚举结束花括号
            override fun exitEnumDeclaration(ctx: EnumDeclarationContext?) {
                ctx?.run { results[currentDepth--].append("}\n") }
            }
            //endregion
        }, tree)

        return results.joinToString("\n")
    }
}