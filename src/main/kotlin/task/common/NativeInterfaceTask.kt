package task.common

import Configs.outputOrg
import Configs.outputProjectName
import Jar
import OutputProject
import OutputProject.classSimpleName
import OutputProject.methodChannel
import common.*
import common.extensions.*
import common.model.Callback
import parser.java.JavaParser
import parser.java.JavaParserBaseListener
import task.Task

/**
 * Android端接口生成
 *
 * 输入: jar所在文件夹
 * 输出: 生成后的plugin文件
 * 依赖: [DecompileClassTask]
 */
class AndroidInterfaceTask(private val jarDir: DIR) : Task<DIR, KOTLIN_FILE>(jarDir) {
    override fun process(): KOTLIN_FILE {
        val resultBuilder = StringBuilder("")
        // import
        resultBuilder.append(importString())
        // 头部固定代码
        resultBuilder.append(headerString())

        // body
        jarDir.iterate("java") {
            if (!it.nameWithoutExtension.isObfuscated()) {
                resultBuilder.append(generateForFile(it))
            }
        }

        // 尾部
        resultBuilder.append(
            """
                    }
                }
        }
    }
}"""
        )

        return OutputProject.Android.kotlinFilePath.file().apply { writeText(resultBuilder.toString()) }
    }

    private fun importString(): String {
        val importBuilder = StringBuilder(
            """package $outputOrg.$outputProjectName
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.PluginRegistry.Registrar
"""
        )

        jarDir.iterate("java") {
            if (!it.nameWithoutExtension.isObfuscated()) {
                importBuilder.appendln(Jar.Decompiled.classes[it.nameWithoutExtension]?.name?.run { "import $this" }
                    ?: "")
            }
        }

        return importBuilder.toString()
    }

    private fun headerString(): String {
        return """
val REF_MAP = mutableMapOf<Int, Any>()

class ${classSimpleName}Plugin {
    companion object {
        @JvmStatic
        fun registerWith(registrar: Registrar) {
            registrar
                    .platformViewRegistry()
                    .registerViewFactory("$methodChannel", ${classSimpleName}Factory(registrar))

            val channel = MethodChannel(registrar.messenger(), "$methodChannel")
            channel.setMethodCallHandler { methodCall, methodResult ->
                val args = methodCall.arguments as? Map<String, *> ?: mapOf()
                when (methodCall.method) {"""
    }

    private fun generateForFile(javaFile: JAVA_FILE): String {
        val resultBuilder = StringBuilder("")
        val methodList = mutableListOf<String>()

        javaFile
            .readText()
            .walkTree(object : JavaParserBaseListener() {
                override fun enterMethodDeclaration(ctx: JavaParser.MethodDeclarationContext?) {
                    ctx?.run {
                        if (!isPublic()
                            || name() in IGNORE_METHOD
                            || formalParams().any { it.isUnknownType() || it.type.isObfuscated() }
                            || returnType().run { isUnknownType() || isObfuscated() }
                        ) return

                        val methodBuilder = StringBuilder("")

                        val className = ancestorOf(JavaParser.ClassDeclarationContext::class)?.IDENTIFIER()?.text ?: ""
                        val params = formalParams().filter { it.type !in PRESERVED_CLASS }.toMutableList()
                        var methodName = name()
                        // 处理java方法重载的情况
                        if (methodName in methodList) {
                            methodName =
                                "${methodName}_${params.joinToString("") { it.type.toDartType().capitalize() }}"
                        }

                        // 解析参数
                        methodBuilder.append(
                            Temps.Kotlin.PlatformView.methodBranchHeader.placeholder(
                                className,
                                methodName,
                                formalParams()
                                    .filter { !it.isCallback() }
                                    .joinToString("") {
                                        when {
                                            it.type.jsonable() -> {
                                                "\n\t\t\t\t\tval ${it.name} = args[\"${it.name}\"] as ${it.type.capitalize()}"
                                            }
                                            it.type in PRESERVED_MODEL -> {
                                                it.convertPreservedModel()
                                            }
                                            else -> {
                                                "\n\t\t\t\t\tval ${it.name} = REF_MAP[args[\"${it.name}\"] as Int] as ${it.type}"
                                            }
                                        }
                                    }
                            )
                        )

                        // 静态方法单独处理
                        if (isStatic()) {
                            // 返回类型是jsonable
                            when {
                                returnType() == "void" -> methodBuilder.append(
                                    Temps.Kotlin.PlatformView.staticReturnVoid.placeholder(
                                        className,
                                        methodName,
                                        formalParams().joinToString {
                                            if (!it.isCallback())
                                                it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                                returnType().jsonable() -> methodBuilder.append(
                                    Temps.Kotlin.PlatformView.staticReturnJsonable.placeholder(
                                        className,
                                        methodName,
                                        formalParams().joinToString {
                                            if (!it.isCallback())
                                                it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                                returnType().isJavaRefType() -> methodBuilder.append(
                                    Temps.Kotlin.PlatformView.staticReturnRef.placeholder(
                                        className,
                                        methodName,
                                        formalParams().joinToString {
                                            if (!it.isCallback())
                                                it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                            }
                            methodBuilder.append("\n\t\t\t}")
                        } else {
                            // 返回类型是jsonable
                            when {
                                // 返回void
                                returnType() == "void" -> methodBuilder.append(
                                    Temps.Kotlin.PlatformView.refReturnVoid.placeholder(
                                        className,
                                        methodName,
                                        formalParams().joinToString {
                                            if (!it.isCallback())
                                                it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                                returnType().jsonable() -> methodBuilder.append(
                                    Temps.Kotlin.PlatformView.refReturnJsonable.placeholder(
                                        className,
                                        methodName,
                                        formalParams().joinToString {
                                            if (!it.isCallback())
                                                it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                                // 返回类型是ref
                                else -> methodBuilder.append(
                                    Temps.Kotlin.PlatformView.refReturnRef.placeholder(
                                        className,
                                        methodName,
                                        formalParams().joinToString {
                                            if (!it.isCallback())
                                                it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                            }
                            methodBuilder.append("\n\t\t\t}")
                        }
                        resultBuilder.append(methodBuilder.toString())
                    }
                }
            })

        return resultBuilder.toString()
    }
}