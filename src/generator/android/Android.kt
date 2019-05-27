package generator.android

import org.antlr.v4.runtime.ANTLRFileStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import parser.java8.Java8BaseListener
import parser.java8.Java8Lexer
import parser.java8.Java8Parser

object Android {
    val result get() = resultBuilder.toString()

    private val resultBuilder = StringBuilder()

    fun generate() {
        val lexer = Java8Lexer(ANTLRFileStream("/Users/yohom/Github/Util/Kotlin/fluttify/src/TbitBle.temp"))
        val tokens = CommonTokenStream(lexer)
        val parser = Java8Parser(tokens)
        val tree = parser.compilationUnit()

        ParseTreeWalker().walk(object : Java8BaseListener() {
            override fun enterClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                resultBuilder.append("class ${ctx?.normalClassDeclaration()?.Identifier()} {")
            }

            override fun enterMethodDeclaration(ctx: Java8Parser.MethodDeclarationContext?) {
                val method = MethodExtractor(ctx!!)
                resultBuilder.append("\n  ${method.returnType} ${method.name}(${method.params.joinToString { "${it.first} ${it.second}" }}) {}\n")
            }

            override fun exitClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                resultBuilder.append("}")
            }
        }, tree)
    }
}