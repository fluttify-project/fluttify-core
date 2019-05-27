package generator.android

import org.antlr.v4.runtime.ANTLRFileStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import parser.java8.Java8BaseListener
import parser.java8.Java8Lexer
import parser.java8.Java8Parser

object Android {
    val dartResult get() = dartResultBuilder.toString()
    val androidResult get() = androidResultBuilder.toString()

    private val dartResultBuilder = StringBuilder()
    private val androidResultBuilder = StringBuilder()

    fun generate() {
        val lexer = Java8Lexer(ANTLRFileStream("/Users/yohom/Github/Util/Kotlin/fluttify/src/TbitBle.temp"))
        val tokens = CommonTokenStream(lexer)
        val parser = Java8Parser(tokens)
        val tree = parser.compilationUnit()

        ParseTreeWalker().walk(object : Java8BaseListener() {
            override fun enterClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                dartResultBuilder.append("class ${ctx?.normalClassDeclaration()?.Identifier()}Android {\n")
                dartResultBuilder.append("  final _channel = MethodChannel('test_android_channel');\n")
            }

            override fun enterMethodDeclaration(ctx: Java8Parser.MethodDeclarationContext?) {
                val method = MethodExtractor(ctx!!)

                // 如果参数中有无法直接json序列化的, 就跳过
                if (method.params.any { !it.first.jsonable() }) return
                // 如果返回类型无法直接json序列化的, 就跳过
                if (!method.returnType.jsonable()) return

                dartResultBuilder.append("\n  Future<${method.returnType}> ${method.name}(${method.params.joinToString { "${it.first} ${it.second}" }}) {\n")
                dartResultBuilder.append("    _channel.invokeMethod('${method.name}');\n  }\n")
            }

            override fun exitClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                dartResultBuilder.append("}")
            }
        }, tree)
    }
}