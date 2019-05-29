package generator.factory

import common.MethodExtractor
import common.jsonable
import common.toDartMap
import generator.IAndroid
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import parser.java8.Java8BaseListener
import parser.java8.Java8Lexer
import parser.java8.Java8Parser
import preprocess.Analyzer.javaClassSimpleName
import preprocess.Analyzer.mainJavaClassPath
import preprocess.Analyzer.methodChannelName

/**
 * Android端目标类以工厂模式创建对象
 */
object FactoryAndroid : IAndroid {
    override val androidDartResult get() = dartResultBuilder.toString()
    override val kotlinResult get() = javaResultBuilder.toString()

    private val dartResultBuilder = StringBuilder()
    private val javaResultBuilder = StringBuilder()

    private val lexer = Java8Lexer(CharStreams.fromFileName(mainJavaClassPath))
    private val parser = Java8Parser(CommonTokenStream(lexer))
    private val tree = parser.compilationUnit()
    private val walker = ParseTreeWalker()

    override fun generateAndroidDart() {
        walker.walk(object : Java8BaseListener() {
            override fun enterClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                dartResultBuilder.append("class ${javaClassSimpleName}SimpleStaticAndroid {\n")
                dartResultBuilder.append("  final _channel = MethodChannel('$methodChannelName');\n")
            }

            override fun enterMethodDeclaration(ctx: Java8Parser.MethodDeclarationContext?) {
                val method = MethodExtractor(ctx!!)

                // 如果参数中有无法直接json序列化的, 就跳过
                if (method.formalParams.any { !it.first.jsonable() }) return
                // 如果返回类型无法直接json序列化的, 就跳过
                if (!method.returnType.jsonable()) return

                dartResultBuilder.append("\n  static Future<${method.returnType}> ${method.name}(${method.formalParams.joinToString { "${it.first} ${it.second}" }}) {\n")
                dartResultBuilder.append("    return _channel.invokeMethodTemp('${method.name}', ${method.formalParams.toDartMap()});\n  }\n")
            }

            override fun exitClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                dartResultBuilder.append("}")
            }
        }, tree)
    }

    override fun generateKotlin() {
        walker.walk(object : Java8BaseListener() {
            override fun enterClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                javaResultBuilder.append("class ${javaClassSimpleName}FlutterPlugin : MethodCallHandler {\n")
                javaResultBuilder.append("  ${companionObject()}\n")
                javaResultBuilder.append("\n  override fun kotlinOnMethodCall(call: MethodCall, result: Result) {\n")
                javaResultBuilder.append("    val args = call.arguments as Map<String, *>\n\n")
                javaResultBuilder.append("    when (call.method) {\n")
            }

            override fun enterMethodDeclaration(ctx: Java8Parser.MethodDeclarationContext?) {
                val method = MethodExtractor(ctx!!)

                // 如果参数中有无法直接json序列化的, 就跳过
                if (method.formalParams.any { !it.first.jsonable() }) return
                // 如果返回类型无法直接json序列化的, 就跳过
                if (!method.returnType.jsonable()) return

                javaResultBuilder.append("\t  \"${method.name}\" -> result.success($javaClassSimpleName.${method.name}(${method.formalParams.joinToString { "args[\"${it.second}\"] as! ${it.first}" }}))\n")
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
                            val channel = MethodChannel(registrar.messenger(), "$methodChannelName")
                            channel.setMethodCallHandler(${javaClassSimpleName}FlutterPlugin())
                        }
                      }
                """.trimIndent()
            }
        }, tree)
    }
}
