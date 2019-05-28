package generator.factory

import Configs.mainObjcClass
import common.MethodExtractor
import common.jsonable
import common.toDartMap
import generator.IIOS
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import parser.objc.ObjectiveCLexer
import parser.objc.ObjectiveCParser
import parser.objc.ObjectiveCParserBaseListener
import preprocess.Analyzer.mainObjcClassPath
import preprocess.Analyzer.methodChannelName

/**
 * iOS端目标类以工厂模式创建对象
 */
object FactoryIOS: IIOS {
    override val iOSDartResult get() = dartResultBuilder.toString()
    override val swiftResult get() = swiftResultBuilder.toString()

    private val dartResultBuilder = StringBuilder()
    private val swiftResultBuilder = StringBuilder()

    private val lexer = ObjectiveCLexer(CharStreams.fromFileName(mainObjcClassPath))
    private val tokens = CommonTokenStream(lexer)
    private val parser = ObjectiveCParser(tokens)
    private val tree = parser.translationUnit()
    private val walker = ParseTreeWalker()

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
                dartResultBuilder.append("    return _channel.invokeMethod('${method.name}', ${method.formalParams.toDartMap()});\n  }\n")
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