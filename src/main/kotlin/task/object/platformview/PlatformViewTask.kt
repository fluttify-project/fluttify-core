package task.`object`.platformview

import Jar
import OutputProject
import common.*
import common.extensions.*
import parser.java.JavaParser
import parser.java.JavaParserBaseListener
import task.Task
import java.io.File

/**
 * 生成PlatformView类, 并输出到文件
 *
 * 输入: 目标原生View类
 * 输出: 生成内容后的Kotlin PlatformView文件
 * 依赖: [AndroidRecognizeModelTask]
 */
class AndroidKotlinPlatformViewTask(private val mainClassFile: JAVA_FILE) :
    Task<JAVA_FILE, KOTLIN_FILE>(mainClassFile) {
    override fun process(): KOTLIN_FILE {
        val javaSource = mainClassFile.readText()
        val kotlinResultBuilder = StringBuilder()

        File(OutputProject.Android.kotlinFilePath).run { if (!exists()) mkdirs() }

        // 生成类的开头
        javaSource.walkTree(object : JavaParserBaseListener() {
            override fun enterCompilationUnit(ctx: JavaParser.CompilationUnitContext?) {
                kotlinResultBuilder.append(Temps.Kotlin.packageImport)
            }

            override fun enterClassDeclaration(ctx: JavaParser.ClassDeclarationContext?) {
                kotlinResultBuilder.append(Temps.Kotlin.PlatformView.classDeclaration)
                kotlinResultBuilder.append(Temps.Kotlin.PlatformView.channel)
                kotlinResultBuilder.append(Temps.Kotlin.PlatformView.getViewDispose)
                kotlinResultBuilder.append(Temps.Kotlin.onMethodCall)
            }
        })

        // 生成method handler 需要递归进行
        generate(javaSource, kotlinResultBuilder)

        // 生成类的结尾
        javaSource.walkTree(object : JavaParserBaseListener() {
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

    private fun generate(javaSource: String, kotlinResultBuilder: StringBuilder) {
        javaSource.walkTree(object : JavaParserBaseListener() {
            override fun enterMethodDeclaration(method: JavaParser.MethodDeclarationContext?) {
                method?.run {
                    // 跳过忽略的方法
                    if (name() in IGNORE_METHOD) return
                    // 跳过非公有, 废弃, 重载方法
                    if (!isPublic() || isDeprecated() || isOverride()) return
                    // 跳过含有`非model参数`的方法
                    if (!formalParams().all { it.type.isJavaModelType() }) return

                    val className = ancestorOf(JavaParser.ClassDeclarationContext::class)?.IDENTIFIER()?.text ?: ""

                    // 条件分支的头, 每种情况都是一样的
                    kotlinResultBuilder.append(
                        Temps.Kotlin.PlatformView.methodBranchHeader.placeholder(
                            className,
                            name(),
                            formalParams().joinToString("") {
                                when {
                                    it.type.jsonable() -> {
                                        "\n\t\t\t\tval ${it.name} = args[\"${it.name}\"] as ${it.type.capitalize()}"
                                    }
                                    Jar.Decompiled.classes[it.type]?.isModel == true -> {
                                        "\n\t\t\t\tval ${it.name} = mapper.readValue(args[\"${it.name}\"] as String, ${it.type}::class.java)"
                                    }
                                    it.type in PRESERVED_MODEL -> {
                                        it.convertPreservedModel()
                                    }
                                    else -> ""
                                }
                            }
                        )
                    )

                    // 静态方法单独处理
                    if (isStatic()) {
                        // 返回类型是model
                        if (returnType().isJavaModelType()) {
                            kotlinResultBuilder.append(
                                Temps.Kotlin.PlatformView.staticReturnModel.placeholder(
                                    className,
                                    name(),
                                    formalParams().joinToString { it.name },
                                    if (returnType().jsonable()) "result" else "mapper.convertValue(result, Map::class.java)"
                                )
                            )
                            kotlinResultBuilder.append("\n\t\t\t}")
                        } else if (returnType() == "void") {
                            kotlinResultBuilder.append(
                                Temps.Kotlin.PlatformView.staticReturnVoid.placeholder(
                                    className,
                                    name(),
                                    formalParams().joinToString { it.name }
                                )
                            )
                            kotlinResultBuilder.append("\n\t\t\t}")
                        } else if (returnType().isJavaRefType()) {
                            kotlinResultBuilder.append(
                                Temps.Kotlin.PlatformView.staticReturnRef.placeholder(
                                    className,
                                    name(),
                                    formalParams().joinToString { it.name }
                                )
                            )
                            kotlinResultBuilder.append("\n\t\t\t}")
                        }
                        return
                    }

                    // 说明是主类上的调用, 不需要使用objectId去取对象
                    if (className == Jar.Decompiled.mainClassSimpleName) {
                        // 返回类型是model
                        if (returnType().isJavaModelType()) {
                            kotlinResultBuilder.append(
                                Temps.Kotlin.PlatformView.viewReturnModel.placeholder(
                                    name(),
                                    formalParams().joinToString { it.name },
                                    if (returnType().jsonable()) "result" else "mapper.convertValue(result, Map::class.java)"
                                )
                            )
                            kotlinResultBuilder.append("\n\t\t\t}")
                        }
                        // 返回void
                        else if (returnType() == "void") {
                            kotlinResultBuilder.append(
                                Temps.Kotlin.PlatformView.viewReturnVoid.placeholder(
                                    name(),
                                    formalParams().joinToString { it.name }
                                )
                            )
                            kotlinResultBuilder.append("\n\t\t\t}")
                        }
                        // 返回类型是ref
                        else if (returnType().isJavaRefType()) {
                            kotlinResultBuilder.append(Temps.Kotlin.PlatformView.viewReturnRef.placeholder(
                                name(),
                                formalParams().joinToString { it.name }
                            ))
                            kotlinResultBuilder.append("\n\t\t\t}")

                            Jar
                                .Decompiled
                                .classes[returnType()]
                                ?.path
                                ?.file()
                                ?.readText()
                                ?.run { generate(this, kotlinResultBuilder) }
                        } else {
                            ""
                        }
                    } else {
                        // 返回类型是model
                        if (returnType().isJavaModelType()) {
                            kotlinResultBuilder.append(
                                Temps.Kotlin.PlatformView.refReturnModel.placeholder(
                                    className,
                                    name(),
                                    formalParams().joinToString { it.name },
                                    if (returnType().jsonable()) "result" else "mapper.convertValue(result, Map::class.java)"
                                )
                            )

                            kotlinResultBuilder.append("\n\t\t\t}")
                        }
                        // 返回void
                        else if (returnType() == "void") {
                            kotlinResultBuilder.append(
                                Temps.Kotlin.PlatformView.refReturnVoid.placeholder(
                                    className,
                                    name(),
                                    formalParams().joinToString { it.name }
                                )
                            )
                            kotlinResultBuilder.append("\n\t\t\t}")
                        }
                        // 返回类型是ref
                        else if (returnType().isJavaRefType()) {
                            kotlinResultBuilder.append(
                                Temps.Kotlin.PlatformView.refReturnRef.placeholder(
                                    className,
                                    name(),
                                    formalParams().joinToString { it.name },
                                    if (returnType().jsonable()) "result" else "mapper.convertValue(result, Map::class.java)"
                                )
                            )

                            kotlinResultBuilder.append("\n\t\t\t}")

                            Jar
                                .Decompiled
                                .classes[returnType()]
                                ?.path
                                ?.file()
                                ?.readText()
                                ?.run { generate(this, kotlinResultBuilder) }
                        } else {
                            ""
                        }
                    }

                }
            }
        })
    }
}

/**
 * 生成PlatformView的Dart类, 并输出到文件
 *
 * 输入: 目标原生View类
 * 输出: 生成内容后的Dart PlatformView文件
 * 依赖: [AndroidRecognizeModelTask]
 */
class AndroidDartPlatformViewTask(private val dartPlatformViewFile: JAVA_FILE) :
    Task<JAVA_FILE, DART_FILE>(dartPlatformViewFile) {
    override fun process(): DART_FILE {
        val dartResultBuilder = StringBuilder()

        dartResultBuilder.append(Temps.Dart.AndroidView.androidView)

        return dartPlatformViewFile
            .apply { writeText(dartResultBuilder.toString()) }
    }
}

