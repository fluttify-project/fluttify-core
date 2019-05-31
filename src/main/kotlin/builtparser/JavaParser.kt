package builtparser

import common.model.JavaClassInfo
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import parser.java8.Java8BaseListener
import parser.java8.Java8Lexer
import parser.java8.Java8Parser

class JavaParser(private val javaFilePath: String) {
    private val lexer = Java8Lexer(CharStreams.fromFileName(javaFilePath))
    private val parser = Java8Parser(CommonTokenStream(lexer))
    private val tree = parser.compilationUnit()
    private val walker = ParseTreeWalker()

    fun typeInfo(): JavaClassInfo? {
        val packageName = tree.packageDeclaration()?.packageName()?.text ?: ""
        var className = ""

        walker.walk(object : Java8BaseListener() {
            override fun enterNormalClassDeclaration(ctx: Java8Parser.NormalClassDeclarationContext?) {
                if (ctx != null && ctx.classModifier().map { it.text }.contains("public")) {
                    className = ctx.Identifier().text
                }
            }

            override fun enterInterfaceDeclaration(ctx: Java8Parser.InterfaceDeclarationContext?) {
                if (ctx != null && ctx.normalInterfaceDeclaration().interfaceModifier().map { it.text }.contains("public")) {
                    className = ctx.normalInterfaceDeclaration().Identifier().text
                }
            }

            override fun enterEnumDeclaration(ctx: Java8Parser.EnumDeclarationContext?) {
                if (ctx != null && ctx.classModifier().map { it.text }.contains("public")) {
                    className = ctx.Identifier().text
                }
            }
        }, tree)

        return JavaClassInfo("$packageName.$className", className, javaFilePath)
    }

    fun walkTree(listener: Java8BaseListener) {
        walker.walk(listener, tree)
    }
}