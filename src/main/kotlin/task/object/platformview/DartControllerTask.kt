package task.`object`.platformview

import Jar
import OutputProject
import common.DART_FILE
import common.IGNORE_METHOD
import common.JAVA_FILE
import common.Temps
import common.extensions.*
import common.model.Variable
import parser.java.JavaParser
import parser.java.JavaParserBaseListener
import task.Task

/**
 * 从主类生成Dart端的PlatformViewController类
 *
 * 输入: 主类文件
 * 输出: 生成内容后的PlatformViewController Dart文件
 * 依赖: [AndroidKotlinPluginTask]
 */
class AndroidDartControllerTask(private val mainClassFile: JAVA_FILE) :
    Task<JAVA_FILE, DART_FILE>(mainClassFile) {
    override fun process(): DART_FILE {
        val javaSource = mainClassFile.readText()

        generate(javaSource, OutputProject.Dart.androidDartControllerFilePath.file())

        return OutputProject
            .Dart
            .androidDartControllerFilePath
            .file()
    }

    private fun generate(javaSource: String, targetFile: DART_FILE) {
        val dartResultBuilder = StringBuilder()

        javaSource.walkTree(object : JavaParserBaseListener() {
            override fun enterCompilationUnit(ctx: JavaParser.CompilationUnitContext?) {
                dartResultBuilder.append(Temps.Dart.packageImport)
            }

            override fun enterClassDeclaration(ctx: JavaParser.ClassDeclarationContext?) {
                ctx?.run {
                    if (ctx.IDENTIFIER().text == Jar.Decompiled.mainClassSimpleName) {
                        dartResultBuilder.append(Temps.Dart.AndroidView.androidViewController)
                    } else {
                        dartResultBuilder.append(
                            Temps.Dart.AndroidView.androidViewRef.placeholder(
                                ctx.IDENTIFIER().text,
                                ctx.IDENTIFIER().text
                            )
                        )
                    }
                }
            }

            override fun enterMethodDeclaration(ctx: JavaParser.MethodDeclarationContext?) {
                ctx?.run {
                    // 跳过非公有, 废弃方法
                    if (!isPublic() || isDeprecated() || name() in IGNORE_METHOD) return
                    // 跳过含有`非model参数`的方法
                    if (!formalParams().all { it.type.isJavaModelType() }) return

                    val className = ancestorOf(JavaParser.ClassDeclarationContext::class)?.IDENTIFIER()?.text ?: ""

                    // 当前所在类不是主类
                    if (ctx.ancestorOf(JavaParser.ClassDeclarationContext::class)
                            ?.IDENTIFIER()
                            ?.text != Jar.Decompiled.mainClassSimpleName
                    ) {
                        if (returnType()?.jsonable() == true) {
                            dartResultBuilder.append(
                                Temps.Dart.AndroidView.jsonInJsonOut.placeholder(
                                    returnType().toDartType(),
                                    name(),
                                    formalParams().joinToString { "${it.type.toDartType()} ${it.name}" },
                                    className,
                                    name(),
                                    ", ",
                                    formalParams()
                                        .toMutableList()
                                        .apply { add(Variable("int", "refId")) }
                                        .toDartMap()
                                )
                            )
                        } else if (returnType()?.isJavaModelType() == true) {
                            dartResultBuilder.append(
                                Temps.Dart.AndroidView.modelInModelOut.placeholder(
                                    returnType().toDartType(),
                                    name(),
                                    formalParams().joinToString { "${it.type.toDartType()} ${it.name}" },
                                    className,
                                    name(),
                                    ", ",
                                    formalParams()
                                        .toMutableList()
                                        .apply { add(Variable("int", "refId")) }
                                        .toDartMap(),
                                    returnType().toDartType()
                                )
                            )
                        } else if (returnType()?.isJavaRefType() == true) {
                            dartResultBuilder.append(
                                Temps.Dart.AndroidView.modelInRefOut.placeholder(
                                    returnType().toDartType(),
                                    name(),
                                    formalParams().joinToString { "${it.type.toDartType()} ${it.name}" },
                                    className,
                                    name(),
                                    ", ",
                                    formalParams()
                                        .toMutableList()
                                        .apply { add(Variable("int", "refId")) }
                                        .toDartMap(),
                                    returnType().toDartType()
                                )
                            )

                            // 如果返回类是引用类型, 那么需要递归进行
                            Jar
                                .Decompiled
                                .classes[returnType()]
                                ?.run {
                                    generate(
                                        path.file().readText(),
                                        (OutputProject.Dart.androidDirPath + simpleName.camel2Underscore() + ".dart").file()
                                    )
                                }
                        } else {
                            ""
                        }
                    }
                    // 当前类是主类
                    else {
                        if (returnType()?.jsonable() == true) {
                            dartResultBuilder.append(
                                Temps.Dart.AndroidView.jsonInJsonOut.placeholder(
                                    returnType().toDartType(),
                                    name(),
                                    formalParams().joinToString { "${it.type.toDartType()} ${it.name}" },
                                    className,
                                    name(),
                                    if (formalParams().isEmpty()) "" else ", ",
                                    formalParams().toDartMap()
                                )
                            )
                        } else if (returnType()?.isJavaModelType() == true) {
                            dartResultBuilder.append(
                                Temps.Dart.AndroidView.modelInModelOut.placeholder(
                                    returnType().toDartType(),
                                    name(),
                                    formalParams().joinToString { "${it.type.toDartType()} ${it.name}" },
                                    className,
                                    name(),
                                    if (formalParams().isEmpty()) "" else ", ",
                                    formalParams().toDartMap(),
                                    returnType().toDartType()
                                )
                            )
                        } else if (returnType()?.isJavaRefType() == true) {
                            dartResultBuilder.append(
                                Temps.Dart.AndroidView.modelInRefOut.placeholder(
                                    returnType().toDartType(),
                                    name(),
                                    formalParams().joinToString { "${it.type.toDartType()} ${it.name}" },
                                    className,
                                    name(),
                                    if (formalParams().isEmpty()) "" else ", ",
                                    formalParams().toDartMap(),
                                    returnType().toDartType()
                                )
                            )

                            // 如果返回类是引用类型, 那么需要递归进行
                            Jar
                                .Decompiled
                                .classes[returnType()]
                                ?.run {
                                    generate(
                                        path.file().readText(),
                                        (OutputProject.Dart.androidDirPath + simpleName.camel2Underscore() + ".dart").file()
                                    )
                                }
                        } else {
                            ""
                        }
                    }
                }
            }

            // 生成类的结尾
            override fun exitClassDeclaration(ctx: JavaParser.ClassDeclarationContext?) {
                dartResultBuilder.append(Temps.Dart.classEnd)
            }
        })

        targetFile.writeText(dartResultBuilder.toString())
    }

}