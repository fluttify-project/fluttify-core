package task.common

import Jar
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

            override fun enterMethodDeclaration(ctx: JavaParser.MethodDeclarationContext?) {
                ctx?.run {
                    if (!isPublic()
                        || name() in IGNORE_METHOD
                        || formalParams().any { it.isUnknownType() || it.type.isObfuscated() }
                        || returnType().run { isUnknownType() || isObfuscated() }
                    ) return

                    val methodBuilder = StringBuilder()

                    val className = ancestorOf(JavaParser.ClassDeclarationContext::class)?.IDENTIFIER()?.text ?: ""
                    val params = formalParams().filter { it.type !in PRESERVED_CLASS }.toMutableList()
                    var methodName = name()
                    // 处理java方法重载的情况
                    if (methodName in methodList) {
                        methodName = "${methodName}_${params.joinToString("") { it.type.toDartType().capitalize() }}"
                    }

                    // 0. 方法修饰
                    methodBuilder.append("\n")
                    methodBuilder.append(if (isStatic()) "static " else "")
                    // 1. 返回类型
                    methodBuilder.append("Future<${returnType().toDartType()}>")
                    methodBuilder.append(" ")
                    // 2. 方法名
                    methodBuilder.append(methodName)
                    methodBuilder.append("(")
                    // 3. 形参
                    methodBuilder.append(formalParamsString(params))
                    methodBuilder.append(")")
                    methodBuilder.append(" async {")
                    // 4. 方法体
                    methodBuilder.append(methodBodyString(className, methodName, params))
                    // 5. 返回值
                    methodBuilder.append(returnString(returnType().toDartType()))
                    methodBuilder.append("}")

                    dartBuilder.append(methodBuilder.toString())
                    methodList.add(name())
                }
            }

            override fun exitClassDeclaration(ctx: JavaParser.ClassDeclarationContext?) {
                ctx?.run {
                    dartBuilder.append(Temps.Dart.classEnd)
                }
            }

            override fun enterEnumDeclaration(ctx: JavaParser.EnumDeclarationContext?) {
                ctx?.run {
                    dartBuilder.append("enum ${IDENTIFIER().text.toDartType()} {")
                }
            }

            override fun enterEnumConstant(ctx: JavaParser.EnumConstantContext?) {
                ctx?.run {
                    dartBuilder.append("${IDENTIFIER().text},")
                }
            }

            override fun exitEnumDeclaration(ctx: JavaParser.EnumDeclarationContext?) {
                ctx?.run {
                    dartBuilder.append("}")
                }
            }
        })

        return "${OutputProject.Dart.androidDirPath}${javaFile.toRelativeString(Jar.Decompiled.rootDirPath.file()).substringBeforeLast(
            "."
        ).replace("$", "_")}.dart".file()
            .apply { writeText(dartBuilder.toString()) }
    }

    /**
     * 形参列表拼接字符串
     */
    private fun formalParamsString(params: List<Variable>): String {
        return params
            .filter { !it.isUnknownType() }
            .joinToString { variable ->
                Jar.Decompiled.classes[variable.type]?.path?.file()?.readText()?.run {
                    // 如果参数是回调类, 那么把类拆成lambda, 并作为参数传入
                    if (isCallback()) {
                        val result = StringBuilder()

                        walkTree(object : JavaParserBaseListener() {
                            override fun enterInterfaceDeclaration(ctx: JavaParser.InterfaceDeclarationContext?) {
                                ctx?.run {
                                    val lambdas = interface2lambdas()
                                    if (lambdas.isNotEmpty()) {
                                        result.append(lambdas.joinToString(prefix = "{", postfix = ",}"))
                                    }
                                }
                            }
                        })

                        result.toString()
                    }
                    // 普通Ref类
                    else {
                        "${variable.type.toDartType()} ${variable.name}"
                    }
                } ?: "${variable.type.toDartType()} ${variable.name}" // jsonable类
            }
    }

    /**
     * 方法体拼接字符串
     */
    private fun methodBodyString(className: String, methodName: String, params: List<Variable>): String {
        val resultBuilder = StringBuilder("")

        val removeCallbackParam = params.filter { !it.isCallback() }

        val actualParams = removeCallbackParam.toDartMap {
            when {
                it.type.isList() -> "${it.name}.map((it) => it.refId).toList()"
                it.type.jsonable() -> it.name
                it.isEnum() -> "${it.name}.index"
                else -> "${it.name}.refId"
            }
        }

        resultBuilder.append(
            "final result = await _channel.invokeMethod('${className.toDartType()}::$methodName', $actualParams);"
        )

        return resultBuilder.toString()
    }

    /**
     * 返回值拼接字符串
     */
    private fun returnString(returnType: String): String {
        val resultBuilder = StringBuilder("")

        if (returnType.jsonable()) {
            if (returnType.isList()) {
                resultBuilder.append(
                    "return (result as List).cast<${returnType.genericType().toDartType()}>();"
                )
            } else {
                resultBuilder.append("return result;")
            }
        } else if (returnType.isEnum()) {
            resultBuilder.append("return ${returnType.toDartType()}.values[result];")
        } else {
            if (returnType.isList()) {
                resultBuilder.append(
                    "return (result as List).map((it) => ${returnType.genericType().toDartType()}.withRefId(it));"
                )
            } else {
                resultBuilder.append("return ${returnType.toDartType()}.withRefId(result);")
            }
        }

        return resultBuilder.toString()
    }
}