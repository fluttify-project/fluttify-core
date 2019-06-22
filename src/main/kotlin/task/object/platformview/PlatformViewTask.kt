package task.`object`.platformview

import Configs.outputOrg
import Configs.outputProjectName
import Jar
import OutputProject
import common.JAVA_FILE
import common.KOTLIN_FILE
import common.Temps
import common.extensions.*
import parser.java.JavaParser
import parser.java.JavaParserBaseListener
import task.Task
import task.common.AndroidRecognizeModelTask
import java.io.File

/**
 * 生成PlatformView类, 并输出到文件
 *
 * 输入: 目标原生View类
 * 输出: 生成内容后的PlatformView文件
 * 依赖: [AndroidRecognizeModelTask]
 */
class AndroidPlatformViewTask(private val mainClassFile: JAVA_FILE) :
    Task<JAVA_FILE, KOTLIN_FILE>(mainClassFile) {
    override fun process(): KOTLIN_FILE {
        val javaSource = mainClassFile.readText()
        val kotlinResultBuilder = StringBuilder()

        File(OutputProject.Android.kotlinFilePath).run { if (!exists()) mkdirs() }

        javaSource.walkTree(object : JavaParserBaseListener() {
            override fun enterCompilationUnit(ctx: JavaParser.CompilationUnitContext?) {
                kotlinResultBuilder.append(Temps.Kotlin.packageImport.placeholder("$outputOrg.$outputProjectName"))
            }

            override fun enterClassDeclaration(ctx: JavaParser.ClassDeclarationContext?) {
                kotlinResultBuilder.append(Temps.Kotlin.PlatformView.classDeclaration.placeholder(OutputProject.classSimpleName))
                kotlinResultBuilder.append(
                    Temps.Kotlin.PlatformView.channel.placeholder(
                        "$outputOrg.$outputProjectName",
                        OutputProject.classSimpleName
                    )
                )
                kotlinResultBuilder.append(Temps.Kotlin.PlatformView.getViewDispose)
                kotlinResultBuilder.append(Temps.Kotlin.onMethodCall)
            }

            override fun enterMethodDeclaration(method: JavaParser.MethodDeclarationContext?) {
                // 跳过私有, 废弃方法
                if (method.run { isPrivate() || isDeprecated() }) return
                // 跳过含有`非model参数`的方法
                if (!method.formalParams().all { it.type.isJavaModelType() }) return

                kotlinResultBuilder.append(
                    Temps.Kotlin.PlatformView.methodBranch.placeholder(
                        method.name(),
                        method.formalParams().joinToString("") {
                            when {
                                it.type.jsonable() -> {
                                    "\n\t\t\t\tval ${it.name} = args[\"${it.name}\"] as ${it.type}"
                                }
                                Jar.Decompiled.classes[it.type]?.isModel == true -> {
                                    "\n\t\t\t\tval ${it.name} = mapper.readValue(args[\"${it.name}\"] as String, ${it.type}::class.java)"
                                }
                                else -> ""
                            }
                        },
                        method.name(),
                        method.formalParams().joinToString { it.name },
                        if (method?.returnType().jsonable()) "result" else "mapper.convertValue(result, Map::class.java)"
                    )
                )
            }

            override fun exitClassDeclaration(ctx: JavaParser.ClassDeclarationContext?) {
                kotlinResultBuilder.append(Temps.Kotlin.whenElse)
                kotlinResultBuilder.append(Temps.Kotlin.classEnd)
            }
        })
        return OutputProject
            .Android
            .platformViewFilePath
            .file()
            .apply { writeText(kotlinResultBuilder.toString()) }
    }
}