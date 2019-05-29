package generator.statik

import Configs.mainObjcClass
import common.MethodExtractor
import common.jsonable
import common.placeholder
import common.template.*
import common.toDartMap
import generator.IiOS
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import parser.objc.ObjectiveCLexer
import parser.objc.ObjectiveCParser
import parser.objc.ObjectiveCParserBaseListener
import preprocess.Analyzer.mainObjcClassPath
import preprocess.Analyzer.methodChannelName
import preprocess.Analyzer.pluginClassSimpleName

private val lexer = ObjectiveCLexer(CharStreams.fromFileName(mainObjcClassPath))
private val tokens = CommonTokenStream(lexer)
private val parser = ObjectiveCParser(tokens)
private val tree = parser.translationUnit()
private val walker = ParseTreeWalker()

/**
 * iOS端目标类以静态模式创建对象, 简单接口
 */
object SimpleStaticIOS: IiOS {
    override val iOSDartResult get() = dartResultBuilder.toString()
    override val swiftResult get() = swiftResultBuilder.toString()

    private val dartResultBuilder = StringBuilder()
    private val swiftResultBuilder = StringBuilder()

    override fun generateIOSDart() {
        walker.walk(object : ObjectiveCParserBaseListener() {
            override fun enterTranslationUnit(ctx: ObjectiveCParser.TranslationUnitContext?) {
                dartResultBuilder.append(dartPackageImportTemp)
            }

            override fun enterClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
                dartResultBuilder.append(dartClassDeclarationTemp.placeholder("${pluginClassSimpleName}Android"))
                dartResultBuilder.append(methodChannelTemp.placeholder(methodChannelName))
            }

            override fun enterMethodDeclaration(ctx: ObjectiveCParser.MethodDeclarationContext?) {
                val method = MethodExtractor(ctx!!)

                // 如果参数中有无法直接json序列化的, 就跳过
                if (method.formalParams.any { !it.first.jsonable() }) return
                // 如果返回类型无法直接json序列化的, 就跳过
                if (!method.returnType.jsonable()) return

                dartResultBuilder.append(invokeMethodTemp.placeholder(
                    method.returnType,
                    method.name,
                    method.formalParams.joinToString { "${it.first} ${it.second}" },
                    method.name,
                    if (method.formalParams.isEmpty()) "" else ", ",
                    method.formalParams.toDartMap()
                ))
            }

            override fun exitClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
                dartResultBuilder.append(dartClassEnd)
            }
        }, tree)
    }

    override fun generateSwift() {
        walker.walk(object : ObjectiveCParserBaseListener() {
            override fun enterTranslationUnit(ctx: ObjectiveCParser.TranslationUnitContext?) {
                swiftResultBuilder.append(swiftPackageImportTemp)
            }

            override fun enterClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
                swiftResultBuilder.append(swiftClassDeclarationTemp.placeholder(pluginClassSimpleName))
                swiftResultBuilder.append(registerTemp.placeholder(methodChannelName, pluginClassSimpleName))
                swiftResultBuilder.append(swiftOnMethodCall)
            }

            override fun enterClassMethodDeclaration(ctx: ObjectiveCParser.ClassMethodDeclarationContext?) {
                val method = MethodExtractor(ctx!!)

                // 如果参数中有无法直接json序列化的, 就跳过
                if (method.formalParams.any { !it.first.jsonable() }) return
                // 如果返回类型无法直接json序列化的, 就跳过
                if (!method.returnType.jsonable()) return

                swiftResultBuilder.append(swiftInvokeResultTemp.placeholder(
                    method.name,
                    mainObjcClass,
                    method.name,
                    method.formalParams.joinToString { "args[\"${it.second}\"] as! ${it.first}" }
                ))
            }

            override fun exitClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
                swiftResultBuilder.append(swiftClassEnd)
            }
        }, tree)
    }
}

/**
 * iOS端目标类以静态模式创建对象, 复杂接口
 */
object ComplicatedStaticIOS: IiOS {
    override val iOSDartResult get() = dartResultBuilder.toString()
    override val swiftResult get() = swiftResultBuilder.toString()

    private val dartResultBuilder = StringBuilder()
    private val swiftResultBuilder = StringBuilder()

    override fun generateIOSDart() {
        walker.walk(object : ObjectiveCParserBaseListener() {
            override fun enterClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
                dartResultBuilder.append("class ${mainObjcClass}IOS {\n")
                dartResultBuilder.append("  final _channel = MethodChannel('$methodChannelName');\n")
            }

            override fun enterMethodDeclaration(ctx: ObjectiveCParser.MethodDeclarationContext?) {
                val method = MethodExtractor(ctx!!)

                // 如果参数中有无法直接json序列化的, 就跳过
                if (method.formalParams.any { !it.first.jsonable() }) return
                // 如果返回类型无法直接json序列化的, 就跳过
                if (!method.returnType.jsonable()) return

                dartResultBuilder.append("\n  static Future<${method.returnType}> ${method.name}(${method.formalParams.joinToString { "${it.first} ${it.second}" }}) {\n")
                dartResultBuilder.append("    return _channel.invokeMethodTemp('${method.name}', ${method.formalParams.toDartMap()});\n  }\n")
            }

            override fun exitClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
                dartResultBuilder.append("}")
            }
        }, tree)
    }

    override fun generateSwift() {
        walker.walk(object : ObjectiveCParserBaseListener() {
            override fun enterClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
                swiftResultBuilder.append("class Swift${mainObjcClass}FlutterPlugin : NSObject, FlutterPlugin {\n")
                swiftResultBuilder.append("  ${staticRegister()}\n")
                swiftResultBuilder.append("\n  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {\n")
                swiftResultBuilder.append("    let args = call.arguments as! Dictionary<String, Any>\n\n")
                swiftResultBuilder.append("    switch call.method {\n")
            }

            override fun enterMethodDeclaration(ctx: ObjectiveCParser.MethodDeclarationContext?) {
                val method = MethodExtractor(ctx!!)

                // 如果参数中有无法直接json序列化的, 就跳过
                if (method.formalParams.any { !it.first.jsonable() }) return
                // 如果返回类型无法直接json序列化的, 就跳过
                if (!method.returnType.jsonable()) return

                swiftResultBuilder.append("\t  case \"${method.name}\": result($mainObjcClass.${method.name}(${method.formalParams.joinToString { "args[\"${it.second}\"] as! ${it.first}" }}))\n")
            }

            override fun exitClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
                swiftResultBuilder.append("    }\n")
                swiftResultBuilder.append("  }\n")
                swiftResultBuilder.append("}")
            }

            private fun staticRegister(): String {
                return """
                    public static func register(with registrar: FlutterPluginRegistrar) {
                        let channel = FlutterMethodChannel(name: "$methodChannelName", binaryMessenger: registrar.messenger())
                        let instance = Swift${mainObjcClass}FlutterPlugin()
                        registrar.addMethodCallDelegate(instance, channel: channel)
                      }
                """.trimIndent()
            }
        }, tree)
    }
}