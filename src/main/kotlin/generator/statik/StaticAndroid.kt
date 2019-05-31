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
 * 简单接口: 接口参数和返回类型都为可以直接json序列化的接口
 */
object StaticJsonableAndroid : IAndroid {
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
                // 如果参数中有无法直接json序列化的, 就跳过
                if (method.formalParams().any { !it.first.jsonable() }) return
                // 如果返回类型无法直接json序列化的, 就跳过
                if (!method.returnType().jsonable()) return
                // 跳过`不是静态`|`私有`的方法
                if (!method.isStatic() || method.isPrivate()) return

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
                    Temps.Kotlin.companionObject.placeholder(OutputProject.methodChannel, OutputProject.classSimpleName)
                )
                kotlinResultBuilder.append(Temps.Kotlin.onMethodCall)
            }

            override fun enterMethodDeclaration(method: Java8Parser.MethodDeclarationContext?) {
                // 如果参数中有无法直接json序列化的, 就跳过
                if (method.formalParams().any { !it.first.jsonable() }) return
                // 如果返回类型无法直接json序列化的, 就跳过
                if (!method.returnType().jsonable()) return
                // 跳过`不是静态`|`私有`的方法
                if (!method.isStatic() || method.isPrivate()) return

                kotlinResultBuilder.append(
                    Temps.Kotlin.jsonableInvokeResult.placeholder(
                        method.name(),
                        Jar.Decompiled.mainClassSimpleName,
                        method.name(),
                        method.formalParams().joinToString { "args[\"${it.second}\"] as ${it.first}" })
                )
            }

            override fun exitClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                kotlinResultBuilder.append(Temps.Kotlin.whenElse)
                kotlinResultBuilder.append(Temps.Kotlin.classEnd)
            }
        })
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
        parser.walkTree(object : Java8BaseListener() {
            override fun enterCompilationUnit(ctx: Java8Parser.CompilationUnitContext?) {
                dartResultBuilder.append(Temps.Dart.packageImport)
            }

            override fun enterClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                dartResultBuilder.append(Temps.Dart.classDeclaration.placeholder("${OutputProject.classSimpleName}Android"))
                dartResultBuilder.append(Temps.Dart.methodChannel.placeholder(OutputProject.methodChannel))
            }

            override fun enterMethodDeclaration(method: Java8Parser.MethodDeclarationContext?) {
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
                // 跳过不是静态的方法
                if (!method.isStatic()) return
                // 跳过私有和废弃方法
                if (method.run { isPrivate() || isDeprecated() }) return
                // 跳过`不是所有参数都是jsonable`的和`有非model参数`的方法
                if (!method.formalParams().all { it.first.jsonable() }
                    && method.formalParams().any { Jar.Decompiled.classes[it.first]?.isModel == true })
                    return

                kotlinResultBuilder.append(
                    Temps.Kotlin.modelInvokeResult.placeholder(
                        method.name(),
                        method.formalParams().joinToString("") {
                            when {
                                it.first.jsonable() -> {
                                    "\n\t\t\t\tval ${it.second} = args[\"${it.second}\"] as ${it.first}"
                                }
                                Jar.Decompiled.classes[it.first]?.isModel ?: false -> {
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
