package generator.statik

import Configs.outputOrg
import Configs.outputProjectName
import common.MethodExtractor
import common.jsonable
import common.placeholder
import common.template.*
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
import preprocess.Analyzer.pluginClassSimpleName

private val lexer = Java8Lexer(CharStreams.fromFileName(mainJavaClassPath))
private val parser = Java8Parser(CommonTokenStream(lexer))
private val tree = parser.compilationUnit()
private val walker = ParseTreeWalker()

/**
 * Android端目标类以静态模式创建对象, 简单接口
 */
object SimpleStaticAndroid : IAndroid {
    override val androidDartResult get() = dartResultBuilder.toString()
    override val kotlinResult get() = kotlinResultBuilder.toString()

    private val dartResultBuilder = StringBuilder()
    private val kotlinResultBuilder = StringBuilder()

    override fun generateAndroidDart() {
        walker.walk(object : Java8BaseListener() {
            override fun enterCompilationUnit(ctx: Java8Parser.CompilationUnitContext?) {
                dartResultBuilder.append(`import`)
            }

            override fun enterClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                dartResultBuilder.append(dartClassDeclaration.placeholder(pluginClassSimpleName))
                dartResultBuilder.append(methodChannel.placeholder(methodChannelName))
            }

            override fun enterMethodDeclaration(ctx: Java8Parser.MethodDeclarationContext?) {
                val method = MethodExtractor(ctx!!)

                // 如果参数中有无法直接json序列化的, 就跳过
                if (method.formalParams.any { !it.first.jsonable() }) return
                // 如果返回类型无法直接json序列化的, 就跳过
                if (!method.returnType.jsonable()) return
                // 跳过不是静态的方法
                if (!method.modifiers.contains("static")) return

                dartResultBuilder.append(invodeMethod.placeholder(
                    method.returnType,
                    method.name,
                    method.formalParams.joinToString { "${it.first} ${it.second}" },
                    method.name,
                    if (method.formalParams.isEmpty()) "" else ", ",
                    method.formalParams.toDartMap()
                ))
            }

            override fun exitClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                dartResultBuilder.append("}")
            }
        }, tree)
    }

    override fun generateKotlin() {
        walker.walk(object : Java8BaseListener() {
            override fun enterCompilationUnit(ctx: Java8Parser.CompilationUnitContext?) {
                kotlinResultBuilder.append(packageImport.placeholder("$outputOrg.$outputProjectName"))
            }

            override fun enterClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                kotlinResultBuilder.append(kotlinClassDeclaration.placeholder(pluginClassSimpleName))
                kotlinResultBuilder.append(companionObject.placeholder(methodChannelName, pluginClassSimpleName))
                kotlinResultBuilder.append(onMethodCall)
            }

            override fun enterMethodDeclaration(ctx: Java8Parser.MethodDeclarationContext?) {
                val method = MethodExtractor(ctx!!)

                // 如果参数中有无法直接json序列化的, 就跳过
                if (method.formalParams.any { !it.first.jsonable() }) return
                // 如果返回类型无法直接json序列化的, 就跳过
                if (!method.returnType.jsonable()) return

                kotlinResultBuilder.append(invokeResult.placeholder(method.name, javaClassSimpleName, method.name, method.formalParams.joinToString { "args[\"${it.second}\"] as! ${it.first}" }))
            }

            override fun exitClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                kotlinResultBuilder.append(classEnd)
            }
        }, tree)
    }
}


/**
 * Android端目标类以静态模式创建对象, 复杂接口
 */
object ComplicatedStaticAndroid : IAndroid {
    override val androidDartResult get() = dartResultBuilder.toString()
    override val kotlinResult get() = javaResultBuilder.toString()

    private val dartResultBuilder = StringBuilder()
    private val javaResultBuilder = StringBuilder()

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
                dartResultBuilder.append("    return _channel.invokeMethod('${method.name}', ${method.formalParams.toDartMap()});\n  }\n")
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
