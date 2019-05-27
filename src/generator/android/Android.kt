package generator.android

import generator.common.toDartMap
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import parser.java8.Java8BaseListener
import parser.java8.Java8Lexer
import parser.java8.Java8Parser

object Android {
    val dartResult get() = dartResultBuilder.toString()
    val javaResult get() = javaResultBuilder.toString()

    private val dartResultBuilder = StringBuilder()
    private val javaResultBuilder = StringBuilder()

    private val lexer = Java8Lexer(CharStreams.fromFileName("/Users/yohom/Github/Util/Kotlin/fluttify/src/TbitBle.temp"))
    private val parser = Java8Parser(CommonTokenStream(lexer))
    private val tree = parser.compilationUnit()
    private val walker = ParseTreeWalker()

    fun generateDart() {
        walker.walk(object : Java8BaseListener() {
            override fun enterClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                dartResultBuilder.append("class ${ctx?.normalClassDeclaration()?.Identifier()}Android {\n")
                dartResultBuilder.append("  final _channel = MethodChannel('test_android_channel');\n")
            }

            override fun enterMethodDeclaration(ctx: Java8Parser.MethodDeclarationContext?) {
                val method = MethodExtractor(ctx!!)

                // 如果参数中有无法直接json序列化的, 就跳过
                if (method.formalParams.any { !it.first.jsonable() }) return
                // 如果返回类型无法直接json序列化的, 就跳过
                if (!method.returnType.jsonable()) return

                dartResultBuilder.append("\n  Future<${method.returnType}> ${method.name}(${method.formalParams.joinToString { "${it.first} ${it.second}" }}) {\n")
                dartResultBuilder.append("    _channel.invokeMethod('${method.name}', ${method.formalParams.toDartMap()});\n  }\n")
            }

            override fun exitClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                dartResultBuilder.append("}")
            }
        }, tree)
    }

    fun generateKotlin() {
        walker.walk(object : Java8BaseListener() {
            lateinit var className: String

            override fun enterClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                className = ctx?.normalClassDeclaration()?.Identifier()?.text ?: ""
                javaResultBuilder.append("class ${className}FlutterPlugin : MethodCallHandler {\n")
                javaResultBuilder.append("  ${companionObject()}\n")
                javaResultBuilder.append("\n  override fun onMethodCall(call: MethodCall, result: Result) {\n")
                javaResultBuilder.append("    val args = call.arguments as Map<String, *>\n\n")
                javaResultBuilder.append("    when (call.method) {\n")
            }

            override fun enterMethodDeclaration(ctx: Java8Parser.MethodDeclarationContext?) {
                val method = MethodExtractor(ctx!!)

                // 如果参数中有无法直接json序列化的, 就跳过
                if (method.formalParams.any { !it.first.jsonable() }) return
                // 如果返回类型无法直接json序列化的, 就跳过
                if (!method.returnType.jsonable()) return

                javaResultBuilder.append("\t  \"${method.name}\" -> result.success($className.${method.name}(${method.formalParams.joinToString { "args[\"${it.second}\"] as! ${it.first}" }}))\n")
            }

            override fun exitClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                javaResultBuilder.append("    }\n")
                javaResultBuilder.append("  }\n")
                javaResultBuilder.append("}")
            }

            private fun companionObject(): String {
                return """
                    companion object {
                        @JvmStatic
                        fun registerWith(registrar: Registrar) {
                            val channel = MethodChannel(registrar.messenger(), "test_android_plugin")
                            channel.setMethodCallHandler(TbitbleFlutterPlugin())
                        }
                      }
                """.trimIndent()
            }
        }, tree)
    }
}