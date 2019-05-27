package generator.ios

import generator.common.toDartMap
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import parser.objc.ObjectiveCLexer
import parser.objc.ObjectiveCParser
import parser.objc.ObjectiveCParserBaseListener

object iOS {
    val dartResult get() = dartResultBuilder.toString()
    val swiftResult get() = swiftResultBuilder.toString()

    private val dartResultBuilder = StringBuilder()
    private val swiftResultBuilder = StringBuilder()

    private val lexer = ObjectiveCLexer(CharStreams.fromFileName("/Users/yohom/Github/Util/Kotlin/fluttify/src/TbitBluetooth.temp"))
    private val tokens = CommonTokenStream(lexer)
    private val parser = ObjectiveCParser(tokens)
    private val tree = parser.translationUnit()
    private val walker = ParseTreeWalker()

    fun generateDart() {
        walker.walk(object : ObjectiveCParserBaseListener() {
            override fun enterClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
                dartResultBuilder.append("class ${ctx?.className?.text}IOS {\n")
                dartResultBuilder.append("  final _channel = MethodChannel('test_ios_channel');\n")
            }

            override fun enterMethodDeclaration(ctx: ObjectiveCParser.MethodDeclarationContext?) {
                val method = MethodExtractor(ctx!!)

                // 如果参数中有无法直接json序列化的, 就跳过
                if (method.formalParams.any { !it.first.jsonable() }) return
                // 如果返回类型无法直接json序列化的, 就跳过
                if (!method.returnType.jsonable()) return

                dartResultBuilder.append("\n  Future<${method.returnType}> ${method.name}(${method.formalParams.joinToString { "${it.first} ${it.second}" }}) {\n")
                dartResultBuilder.append("    _channel.invokeMethod('${method.name}', ${method.formalParams.toDartMap()});\n  }\n")
            }

            override fun exitClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
                dartResultBuilder.append("}")
            }
        }, tree)
    }

    fun generateSwift() {
        walker.walk(object : ObjectiveCParserBaseListener() {
            lateinit var className: String

            override fun enterClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
                className = ctx?.className?.text ?: ""
                swiftResultBuilder.append("class Swift${className}FlutterPlugin : NSObject, FlutterPlugin {\n")
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

                swiftResultBuilder.append("\t  case \"${method.name}\": result($className.${method.name}(${method.formalParams.joinToString { "args[\"${it.second}\"] as! ${it.first}" }}))\n")
            }

            override fun exitClassInterface(ctx: ObjectiveCParser.ClassInterfaceContext?) {
                swiftResultBuilder.append("    }\n")
                swiftResultBuilder.append("  }\n")
                swiftResultBuilder.append("}")
            }

            private fun staticRegister(): String {
                return """
                    public static func register(with registrar: FlutterPluginRegistrar) {
                        let channel = FlutterMethodChannel(name: "tbitble_flutter", binaryMessenger: registrar.messenger())
                        let instance = SwiftTbitbleFlutterPlugin()
                        registrar.addMethodCallDelegate(instance, channel: channel)
                      }
                """.trimIndent()
            }
        }, tree)
    }
}