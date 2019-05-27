package generator.ios

import org.antlr.v4.runtime.ANTLRFileStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import parser.objc.ObjectiveCLexer
import parser.objc.ObjectiveCParser
import parser.objc.ObjectiveCParserBaseListener

object iOS {
    val result get() = resultBuilder.toString()

    private val resultBuilder = StringBuilder()

    fun generate() {
        val lexer = ObjectiveCLexer(ANTLRFileStream("/Users/yohom/Github/Util/Kotlin/fluttify/src/TbitBluetooth.temp"))
        val tokens = CommonTokenStream(lexer)
        val parser = ObjectiveCParser(tokens)
        val tree = parser.translationUnit()

        ParseTreeWalker().walk(object : ObjectiveCParserBaseListener() {
            override fun enterClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
                resultBuilder.append("class ${ctx?.className?.text}IOS {")
            }

            override fun enterMethodDeclaration(ctx: ObjectiveCParser.MethodDeclarationContext?) {
                val method = MethodExtractor(ctx!!)

                // 如果参数中有无法直接json序列化的, 就跳过
                if (method.params.any { !it.first.jsonable() }) return
                // 如果返回类型无法直接json序列化的, 就跳过
                if (!method.returnType.jsonable()) return

                resultBuilder.append("\n  ${method.returnType} ${method.name}(${method.params.joinToString { "${it.first} ${it.second}" }}) {}\n")
            }

            override fun exitClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
                resultBuilder.append("}")
            }
        }, tree)
    }
}