package task

import Configs.outputOrg
import Configs.outputProjectName
import common.DART_FILE
import common.JAVA_FILE
import common.KOTLIN_FILE
import common.Temps
import common.extensions.*
import parser.java.JavaParser
import parser.java.JavaParserBaseListener
import preprocess.Jar
import preprocess.OutputProject
import java.io.File

/**
 * 生成Android端Dart静态方法的MethodChannel
 *
 * 输入: 主Java类文件
 * 输出: 对应Dart的MethodChannel文件
 * 依赖: [UnzipTask]
 */
class AndroidDartStaticMethodTask(private val mainClassFile: JAVA_FILE) : Task<JAVA_FILE, DART_FILE>(mainClassFile) {
    override fun process(): DART_FILE {
        val javaSource = mainClassFile.readText()
        val dartResultBuilder = StringBuilder()

        File(OutputProject.Dart.androidDartPath).run { if (!exists()) mkdirs() }

        javaSource.walkTree(object : JavaParserBaseListener() {
            override fun enterCompilationUnit(ctx: JavaParser.CompilationUnitContext?) {
                dartResultBuilder.append(Temps.Dart.packageImport)
            }

            override fun enterClassDeclaration(ctx: JavaParser.ClassDeclarationContext?) {
                dartResultBuilder.append(Temps.Dart.classDeclaration.placeholder("${OutputProject.classSimpleName}Android"))
                dartResultBuilder.append(Temps.Dart.methodChannel.placeholder(OutputProject.methodChannel))
            }

            override fun enterMethodDeclaration(method: JavaParser.MethodDeclarationContext?) {
                // 跳过实例,私有,废弃方法
                if (method.run { isInstanceMethod() || isPrivate() || isDeprecated() }) return
                // 跳过含有`非model参数`的方法
                if (!method.formalParams().all { it.type.isModelType() }) return

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

            override fun exitClassDeclaration(ctx: JavaParser.ClassDeclarationContext?) {
                dartResultBuilder.append(Temps.Dart.classEnd)
            }
        })
        return File("${OutputProject.Dart.androidDartPath}/${mainClassFile.nameWithoutExtension.camel2Underscore()}.dart")
            .apply {
                if (!exists()) createNewFile()
                writeText(dartResultBuilder.toString())
            }
    }
}

/**
 * 生成Android端Kotlin静态方法的MethodChannel
 *
 * 输入: 主Java类文件
 * 输出: 对应Kotlin的MethodChannel文件
 * 依赖: [UnzipTask]
 */
class AndroidKotlinStaticMethodTask(private val mainClassFile: JAVA_FILE) : Task<JAVA_FILE, KOTLIN_FILE>(mainClassFile) {
    override fun process(): KOTLIN_FILE {
        val javaSource = mainClassFile.readText()
        val kotlinResultBuilder = StringBuilder()

        File(OutputProject.Android.kotlinPath).run { if (!exists()) mkdirs() }

        javaSource.walkTree(object : JavaParserBaseListener() {
            override fun enterCompilationUnit(ctx: JavaParser.CompilationUnitContext?) {
                kotlinResultBuilder.append(Temps.Kotlin.packageImport.placeholder("$outputOrg.$outputProjectName"))
            }

            override fun enterClassDeclaration(ctx: JavaParser.ClassDeclarationContext?) {
                kotlinResultBuilder.append(Temps.Kotlin.classDeclaration.placeholder(OutputProject.classSimpleName))
                kotlinResultBuilder.append(
                    Temps.Kotlin.companionObject.placeholder(
                        OutputProject.methodChannel,
                        OutputProject.classSimpleName
                    )
                )
                kotlinResultBuilder.append(Temps.Kotlin.onMethodCall)
            }

            override fun enterMethodDeclaration(method: JavaParser.MethodDeclarationContext?) {
                // 跳过实例, 私有, 废弃方法
                if (method.run { isInstanceMethod() || isPrivate() || isDeprecated() }) return
                // 跳过含有`非model参数`的方法
                if (!method.formalParams().all { it.type.isModelType() }) return

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

            override fun exitClassDeclaration(ctx: JavaParser.ClassDeclarationContext?) {
                kotlinResultBuilder.append(Temps.Kotlin.whenElse)
                kotlinResultBuilder.append(Temps.Kotlin.classEnd)
            }
        })
        return File(OutputProject.Android.kotlinPath)
            .apply {
                if (!exists()) createNewFile()
                writeText(kotlinResultBuilder.toString())
            }
    }
}