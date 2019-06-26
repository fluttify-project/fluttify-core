package task.common

import OutputProject
import common.*
import common.extensions.*
import common.model.Variable
import parser.java.JavaParser
import parser.java.JavaParserBaseListener
import task.Task

/**
 * 生成Java文件的Dart接口
 *
 * 输入: Java文件
 * 输出: 生成接口后的Dart文件
 * 依赖: [DecompileClassTask]
 */
class DartInterfaceTask(private val javaFile: JAVA_FILE) : Task<JAVA_FILE, DART_FILE>(javaFile) {
    override fun process(): DART_FILE {
        val javaSource = javaFile.readText()

        val dartBuilder = StringBuilder()
        val methodList = mutableListOf<String>()

        javaSource.walkTree(object : JavaParserBaseListener() {

            override fun enterClassDeclaration(ctx: JavaParser.ClassDeclarationContext?) {
                ctx?.run {
                    dartBuilder.append(
                        Temps.Dart.classDeclaration.placeholder(
                            IDENTIFIER().text,
                            IDENTIFIER().text,
                            IDENTIFIER().text,
                            IDENTIFIER().text
                        )
                    )
                    dartBuilder.append(Temps.Dart.methodChannel)
                }
            }

            override fun enterConstructorDeclaration(ctx: JavaParser.ConstructorDeclarationContext?) {
                ctx?.run {
                    val className = ancestorOf(JavaParser.ClassDeclarationContext::class)?.IDENTIFIER()?.text ?: ""
                    if (!isPublic()) {
                        dartBuilder.appendln(Temps.Dart.privateConstructor.placeholder(className))
                    }
                }
            }

            override fun enterMethodDeclaration(ctx: JavaParser.MethodDeclarationContext?) {
                ctx?.run {
                    if (!isPublic() || name() in IGNORE_METHOD) return

                    val className = ancestorOf(JavaParser.ClassDeclarationContext::class)?.IDENTIFIER()?.text ?: ""
                    val params = formalParams().filter { it.type !in PRESERVED_CLASS }.toMutableList()
                    var methodName = name()
                    if (methodName in methodList) {
                        methodName = "${methodName}_${params.joinToString("") { it.type.toDartType().capitalize() }}"
                    }

                    if (returnType().jsonable()) {
                        dartBuilder.append(
                            Temps.Dart.interfaceMethodJsonable.placeholder(
                                if (isStatic()) "static " else "",
                                returnType().toDartType(),
                                methodName,
                                params.joinToString { "${it.type.toDartType()} ${it.name}" },
                                className,
                                methodName,
                                if (params.isEmpty() && isStatic()) "" else ", ",
                                if (isStatic()) params.toDartMap() else params.apply {
                                    add(
                                        Variable(
                                            "int",
                                            "refId"
                                        )
                                    )
                                }.toDartMap()
                            )
                        )
                    } else {
                        dartBuilder.append(
                            Temps.Dart.interfaceMethodRef.placeholder(
                                if (isStatic()) "static " else "",
                                returnType().toDartType(),
                                methodName,
                                params.joinToString { "${it.type.toDartType()} ${it.name}" },
                                className,
                                methodName,
                                if (params.isEmpty() && isStatic()) "" else ", ",
                                if (isStatic()) params.toDartMap() else params.apply {
                                    add(
                                        Variable(
                                            "int",
                                            "refId"
                                        )
                                    )
                                }.toDartMap(),
                                returnType().toDartType()
                            )
                        )
                    }


                    methodList.add(name())
                }
            }

            override fun exitClassDeclaration(ctx: JavaParser.ClassDeclarationContext?) {
                ctx?.run {
                    dartBuilder.append(Temps.Dart.classEnd)
                }
            }
        })

        return "${OutputProject.Dart.libDirPath}src/${javaFile.nameWithoutExtension.camel2Underscore()}.dart".file()
            .apply { writeText(dartBuilder.toString()) }
    }
}