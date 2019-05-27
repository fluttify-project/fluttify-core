package generator.ios

import generator.common.toDartMap
import org.antlr.v4.runtime.ANTLRFileStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import parser.objc.ObjectiveCLexer
import parser.objc.ObjectiveCParser
import parser.objc.ObjectiveCParserBaseListener

object iOS {
    val dartResult get() = dartResultBuilder.toString()

    private val dartResultBuilder = StringBuilder()

    fun generate() {
        val lexer = ObjectiveCLexer(ANTLRFileStream("/Users/yohom/Github/Util/Kotlin/fluttify/src/TbitBluetooth.temp"))
        val tokens = CommonTokenStream(lexer)
        val parser = ObjectiveCParser(tokens)
        val tree = parser.translationUnit()

        ParseTreeWalker().walk(object : ObjectiveCParserBaseListener() {
            override fun enterClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
                dartResultBuilder.append("class ${ctx?.className?.text}IOS {\n")
                dartResultBuilder.append("  final _channel = MethodChannel('test_ios_channel');\n")
            }

            override fun enterMethodDeclaration(ctx: ObjectiveCParser.MethodDeclarationContext?) {
                val method = MethodExtractor(ctx!!)

                // 如果参数中有无法直接json序列化的, 就跳过
                if (method.params.any { !it.first.jsonable() }) return
                // 如果返回类型无法直接json序列化的, 就跳过
                if (!method.returnType.jsonable()) return


                dartResultBuilder.append("\n  Future<${method.returnType}> ${method.name}(${method.params.joinToString { "${it.first} ${it.second}" }}) {\n")
                dartResultBuilder.append("    _channel.invokeMethod('${method.name}', ${method.params.toDartMap()});\n  }\n")
            }

            override fun exitClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
                dartResultBuilder.append("}")
            }
        }, tree)
    }
}