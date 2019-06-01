package generator.statik

import Configs.outputOrg
import Configs.outputProjectName
import common.Temps
import common.extensions.*
import generator.IAndroid
import parser.java8.Java8BaseListener
import parser.java8.Java8Parser
import preprocess.Jar
import preprocess.OutputProject

private val javaSource = Jar.Decompiled.mainClassPath.toFile().readText()

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
        javaSource.walkTree(object : Java8BaseListener() {
            override fun enterCompilationUnit(ctx: Java8Parser.CompilationUnitContext?) {
                dartResultBuilder.append(Temps.Dart.packageImport)
            }

            override fun enterClassDeclaration(ctx: Java8Parser.ClassDeclarationContext?) {
                dartResultBuilder.append(Temps.Dart.classDeclaration.placeholder("${OutputProject.classSimpleName}Android"))
                dartResultBuilder.append(Temps.Dart.methodChannel.placeholder(OutputProject.methodChannel))
            }

            override fun enterMethodDeclaration(method: Java8Parser.MethodDeclarationContext?) {
                // 跳过实例,私有,废弃方法
                if (method.run { isInstanceMethod() || isPrivate() || isDeprecated() }) return
                // 跳过含有`非model参数`的方法
                if (!method.formalParams().all { it.type.isModel() }) return

                method.formalParams().forEach {
                    // 如果参数类型是model, 却不能直接序列化, 那么就需要为其生成相应的dart类
                    if (it.type.run { isModel() && !jsonable() }) {

                    }
                }

                dartResultBuilder.append(
                    Temps.Dart.invokeMethod.placeholder(
                        method.returnType(),
                        method.name(),
                        method.formalParams().joinToString { "${it.type} ${it.name}" },
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
        javaSource.walkTree(object : Java8BaseListener() {
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
                // 跳过实例,私有,废弃方法
                if (method.run { isInstanceMethod() || isPrivate() || isDeprecated() }) return
                // 跳过含有`非model参数`的方法
                if (!method.formalParams().all { it.type.isModel() }) return

                kotlinResultBuilder.append(
                    Temps.Kotlin.methodResult.placeholder(
                        method.name(),
                        method.formalParams().joinToString("") {
                            when {
                                it.type.jsonable() -> {
                                    "\n\t\t\t\tval ${it.name} = args[\"${it.name}\"] as ${it.type}"
                                }
                                it.type.isModel() -> {
                                    "\n\t\t\t\tval ${it.name} = mapper.readValue(args[\"${it.name}\"] as String, ${it.type}::class.java)"
                                }
                                else -> ""
                            }
                        },
                        Jar.Decompiled.mainClassSimpleName,
                        method.name(),
                        method.formalParams().joinToString { it.name },
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
