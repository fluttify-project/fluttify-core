package generator.statik

import Configs.outputOrg
import Configs.outputProjectName
import builtparser.JavaParser
import common.Temps
import common.extensions.*
import generator.IAndroid
import parser.java8.Java8BaseListener
import parser.java8.Java8Parser
import preprocess.Jar
import preprocess.OutputProject

private val parser = JavaParser(Jar.Decompiled.mainClassPath)

/**
 * Android端目标类以静态模式创建对象
 *
 * 复杂接口: 接口参数/返回类型为无法直接json序列化的类型, 且不依赖其他对象(即没有`有参数`构造器)的类
 */
object StaticAndroid : IAndroid {
    override val androidDartResult get() = dartResultBuilder.toString()
    override val kotlinResult get() = kotlinResultBuilder.toString()

    private val dartResultBuilder = StringBuilder()
    private val kotlinResultBuilder = StringBuilder()

    override fun generateAndroidDart() {
        parser.walkTree(object : Java8BaseListener() {
            override fun enterCompilationUnit(ctx: Java8Parser.CompilationUnitContext?) {
                dartResultBuilder.append(Temps.Dart.packageImport)
            }

            override fun enterClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                dartResultBuilder.append(Temps.Dart.classDeclaration.placeholder("${OutputProject.classSimpleName}Android"))
                dartResultBuilder.append(Temps.Dart.methodChannel.placeholder(OutputProject.methodChannel))
            }

            override fun enterMethodDeclaration(method: Java8Parser.MethodDeclarationContext?) {
                // 跳过实例方法
                if (method.isInstanceMethod()) return
                // 跳过私有和废弃方法
                if (method.run { isPrivate() || isDeprecated() }) return
                // 跳过含有`非model参数`的方法
                if (!method.formalParams().all { it.first.isModel() }) return

                dartResultBuilder.append(
                    Temps.Dart.invokeMethod.placeholder(
                        method.returnType(),
                        method.name(),
                        method.formalParams().joinToString { "${it.first} ${it.second}" },
                        method.name(),
                        if (method.formalParams().isEmpty()) "" else ", ",
                        method.formalParams().toDartMap()
                    )
                )
            }

            override fun exitClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                dartResultBuilder.append(Temps.Dart.classEnd)
            }
        })
    }

    override fun generateKotlin() {
        parser.walkTree(object : Java8BaseListener() {
            override fun enterCompilationUnit(ctx: Java8Parser.CompilationUnitContext?) {
                kotlinResultBuilder.append(Temps.Kotlin.packageImport.placeholder("$outputOrg.$outputProjectName"))
            }

            override fun enterClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                kotlinResultBuilder.append(Temps.Kotlin.classDeclaration.placeholder(OutputProject.classSimpleName))
                kotlinResultBuilder.append(
                    Temps.Kotlin.companionObject.placeholder(
                        OutputProject.methodChannel,
                        OutputProject.classSimpleName
                    )
                )
                kotlinResultBuilder.append(Temps.Kotlin.onMethodCall)
            }

            override fun enterMethodDeclaration(method: Java8Parser.MethodDeclarationContext?) {
                // 跳过实例方法
                if (method.isInstanceMethod()) return
                // 跳过私有和废弃方法
                if (method.run { isPrivate() || isDeprecated() }) return
                // 跳过含有`非model参数`的方法
                if (!method.formalParams().all { it.first.isModel() }) return

                kotlinResultBuilder.append(
                    Temps.Kotlin.methodResult.placeholder(
                        method.name(),
                        method.formalParams().joinToString("") {
                            when {
                                it.first.jsonable() -> {
                                    "\n\t\t\t\tval ${it.second} = args[\"${it.second}\"] as ${it.first}"
                                }
                                it.first.isModel() -> {
                                    "\n\t\t\t\tval ${it.second} = mapper.readValue(args[\"${it.second}\"] as String, ${it.first}::class.java)"
                                }
                                else -> ""
                            }
                        },
                        Jar.Decompiled.mainClassSimpleName,
                        method.name(),
                        method.formalParams().joinToString { it.second },
                        if (method.returnType().jsonable()) "result" else "mapper.convertValue(result, Map::class.java)"
                    )
                )
            }

            override fun exitClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                kotlinResultBuilder.append(Temps.Kotlin.whenElse)
                kotlinResultBuilder.append(Temps.Kotlin.classEnd)
            }
        })
    }
}
