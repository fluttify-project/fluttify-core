package generator.statik

import Configs.outputOrg
import Configs.outputProjectName
import common.*
import common.template.*
import generator.IAndroid
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import parser.java8.Java8BaseListener
import parser.java8.Java8Lexer
import parser.java8.Java8Parser
import preprocess.Analyzer.jarSourcePath
import preprocess.Analyzer.javaClassSimpleName
import preprocess.Analyzer.mainJavaClassPath
import preprocess.Analyzer.methodChannelName
import preprocess.Analyzer.pluginClassSimpleName

private val lexer = Java8Lexer(CharStreams.fromFileName(mainJavaClassPath))
private val parser = Java8Parser(CommonTokenStream(lexer))
private val tree = parser.compilationUnit()
private val walker = ParseTreeWalker()

/**
 * Android端目标类以静态模式创建对象
 *
 * 简单接口: 接口参数和返回类型都为可以直接json序列化的接口
 */
object StaticJsonableAndroid : IAndroid {
    override val androidDartResult get() = dartResultBuilder.toString()
    override val kotlinResult get() = kotlinResultBuilder.toString()

    private val dartResultBuilder = StringBuilder()
    private val kotlinResultBuilder = StringBuilder()

    override fun generateAndroidDart() {
        walker.walk(object : Java8BaseListener() {
            override fun enterCompilationUnit(ctx: Java8Parser.CompilationUnitContext?) {
                dartResultBuilder.append(dartPackageImportTemp)
            }

            override fun enterClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                dartResultBuilder.append(dartClassDeclarationTemp.placeholder("${pluginClassSimpleName}Android"))
                dartResultBuilder.append(methodChannelTemp.placeholder(methodChannelName))
            }

            override fun enterMethodDeclaration(ctx: Java8Parser.MethodDeclarationContext?) {
                val method = MethodExtractor(ctx!!)

                // 如果参数中有无法直接json序列化的, 就跳过
                if (method.formalParams.any { !it.first.jsonable() }) return
                // 如果返回类型无法直接json序列化的, 就跳过
                if (!method.returnType.jsonable()) return
                // 跳过不是静态的方法
                if (!method.modifiers.contains("static")) return
                // 跳过私有方法
                if (method.modifiers.contains("private")) return

                dartResultBuilder.append(
                    invokeMethodTemp.placeholder(
                        method.returnType,
                        method.name,
                        method.formalParams.joinToString { "${it.first} ${it.second}" },
                        method.name,
                        if (method.formalParams.isEmpty()) "" else ", ",
                        method.formalParams.toDartMap()
                    )
                )
            }

            override fun exitClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                dartResultBuilder.append(dartClassEnd)
            }
        }, tree)
    }

    override fun generateKotlin() {
        walker.walk(object : Java8BaseListener() {
            override fun enterCompilationUnit(ctx: Java8Parser.CompilationUnitContext?) {
                kotlinResultBuilder.append(kotlinPackageImportTemp.placeholder("$outputOrg.$outputProjectName"))
            }

            override fun enterClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                kotlinResultBuilder.append(kotlinClassDeclarationTemp.placeholder(pluginClassSimpleName))
                kotlinResultBuilder.append(companionObjectTemp.placeholder(methodChannelName, pluginClassSimpleName))
                kotlinResultBuilder.append(kotlinOnMethodCall)
            }

            override fun enterMethodDeclaration(ctx: Java8Parser.MethodDeclarationContext?) {
                val method = MethodExtractor(ctx!!)

                // 如果参数中有无法直接json序列化的, 就跳过
                if (method.formalParams.any { !it.first.jsonable() }) return
                // 如果返回类型无法直接json序列化的, 就跳过
                if (!method.returnType.jsonable()) return
                // 跳过不是静态的方法
                if (!method.modifiers.contains("static")) return
                // 跳过私有方法
                if (method.modifiers.contains("private")) return

                kotlinResultBuilder.append(
                    kotlinJsonableInvokeResultTemp.placeholder(
                        method.name,
                        javaClassSimpleName,
                        method.name,
                        method.formalParams.joinToString { "args[\"${it.second}\"] as ${it.first}" })
                )
            }

            override fun exitClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                kotlinResultBuilder.append(kotlinWhenElse)
                kotlinResultBuilder.append(kotlinClassEnd)
            }
        }, tree)
    }
}

/**
 * Android端目标类以静态模式创建对象
 *
 * 复杂接口: 接口参数/返回类型为无法直接json序列化的类型, 且不依赖其他对象(即没有`有参数`构造器)的类
 */
object StaticModelAndroid : IAndroid {
    override val androidDartResult get() = dartResultBuilder.toString()
    override val kotlinResult get() = kotlinResultBuilder.toString()

    private val dartResultBuilder = StringBuilder()
    private val kotlinResultBuilder = StringBuilder()

    override fun generateAndroidDart() {
        walker.walk(object : Java8BaseListener() {
            override fun enterCompilationUnit(ctx: Java8Parser.CompilationUnitContext?) {
                dartResultBuilder.append(dartPackageImportTemp)
            }

            override fun enterClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                dartResultBuilder.append(dartClassDeclarationTemp.placeholder("${pluginClassSimpleName}Android"))
                dartResultBuilder.append(methodChannelTemp.placeholder(methodChannelName))
            }

            override fun enterMethodDeclaration(ctx: Java8Parser.MethodDeclarationContext?) {
                val method = MethodExtractor(ctx!!)

//                if (!isStaticModelMethod(method)) return

                dartResultBuilder.append(
                    invokeMethodTemp.placeholder(
                        method.returnType,
                        method.name,
                        method.formalParams.joinToString { "${it.first} ${it.second}" },
                        method.name,
                        if (method.formalParams.isEmpty()) "" else ", ",
                        method.formalParams.toDartMap()
                    )
                )
            }

            override fun exitClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                dartResultBuilder.append(dartClassEnd)
            }
        }, tree)
    }

    override fun generateKotlin() {
        walker.walk(object : Java8BaseListener() {
            override fun enterCompilationUnit(ctx: Java8Parser.CompilationUnitContext?) {
                kotlinResultBuilder.append(kotlinPackageImportTemp.placeholder("$outputOrg.$outputProjectName"))
            }

            override fun enterClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                kotlinResultBuilder.append(kotlinClassDeclarationTemp.placeholder(pluginClassSimpleName))
                kotlinResultBuilder.append(companionObjectTemp.placeholder(methodChannelName, pluginClassSimpleName))
                kotlinResultBuilder.append(kotlinOnMethodCall)
            }

            override fun enterMethodDeclaration(ctx: Java8Parser.MethodDeclarationContext?) {
                val method = MethodExtractor(ctx!!)

                // 跳过不是静态的方法
                if (!method.modifiers.contains("static")) return
                // 跳过私有和废弃方法
                if (method.modifiers.run { contains("private") || contains("@Deprecated") }) return
                // 跳过`不是所有参数都是jsonable`的和`有非model参数`的方法
                if (!method.formalParams.all { it.first.jsonable() }
                    && method.formalParams.any { !it.first.findPath(jarSourcePath).isModel() })
                    return

                kotlinResultBuilder.append(
                    kotlinModelInvokeResultTemp.placeholder(
                        method.name,
                        method.formalParams.joinToString("") {
                            when {
                                it.first.jsonable() -> {
                                    "\n\t\t\t\tval ${it.second} = args[\"${it.second}\"] as ${it.first}"
                                }
                                it.first.findPath(jarSourcePath).isModel() -> {
                                    "\n\t\t\t\tval ${it.second} = mapper.readValue(args[\"${it.second}\"] as String, ${it.first}::class.java)"
                                }
                                else -> ""
                            }
                        },
                        javaClassSimpleName,
                        method.name,
                        method.formalParams.joinToString { it.second },
                        if (method.returnType.jsonable()) "result" else "mapper.convertValue(result, Map::class.java)"
                    )
                )
            }

            override fun exitClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                kotlinResultBuilder.append(kotlinWhenElse)
                kotlinResultBuilder.append(kotlinClassEnd)
            }
        }, tree)
    }

    private fun isStaticModelMethod(method: MethodExtractor): Boolean {
        // 跳过不是静态的方法
        if (!method.modifiers.contains("static")) return false
        // 跳过私有方法
        if (method.modifiers.contains("private")) return false
        // 如果参数和返回类型有一个不是model的话, 就跳过
        if (method.formalParams.any { !it.first.findPath(jarSourcePath).isModel() }) return false
        return true
    }
}
