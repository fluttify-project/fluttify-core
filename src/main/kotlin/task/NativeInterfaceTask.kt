package task

import Configs.outputOrg
import Configs.outputProjectName
import OutputProject
import OutputProject.classSimpleName
import OutputProject.methodChannel
import common.*
import common.extensions.*
import common.model.Callback
import parser.java.JavaParser
import parser.java.JavaParserBaseListener
import java.io.File

/**
 * Android端接口生成
 *
 * 输入: java文件
 * 输出: 对应的method channel文件
 * 依赖: [DecompileClassTask]
 */
class AndroidInterfaceTask(private val jarDir: DIR) : Task<DIR, KOTLIN_FILE>(jarDir) {
    private val methodHandlers = mutableListOf<String>()

    override fun process(): KOTLIN_FILE {
        val resultBuilder = StringBuilder("")
        // package
        resultBuilder.appendln(packageString())
        // import
        resultBuilder.appendln(importList().joinToString("\n"))
        // REF_MAP
        resultBuilder.appendln(refMapString())
        // 头部固定代码
        resultBuilder.append(headerString())

        // body
        jarDir.iterate("java") {
            if (!it.nameWithoutExtension.isObfuscated() && !it.readText().isIgnore()) {
                resultBuilder.append(generateForFile(it))
            }
        }
        resultBuilder.append(Temps.Kotlin.whenElse)
        resultBuilder.append(
            """
                    }
                }
        """
        )

        jarDir.iterate("java") {
            if (it.readText().isView()) {
                if (it.readText().isView()) {
                    resultBuilder.appendln(registerPlatformFactory(it))
                    generatePlatformView(it)
                }
            }
        }
        resultBuilder.append("\t\t}\n\n")

        resultBuilder.append(methodHandlers.joinToString("\n"))

        // 尾部
        resultBuilder.append(
            """
    }
}"""
        )

        return OutputProject.Android.kotlinFilePath.file().apply { writeText(resultBuilder.toString()) }
    }

    private fun packageString(): String {
        return "package $outputOrg.$outputProjectName"
    }

    private fun importList(): List<String> {
        return listOf(
            "import io.flutter.plugin.common.MethodChannel",
            "import io.flutter.plugin.common.PluginRegistry.Registrar"
        )
    }

    private fun refMapString(): String {
        return "val REF_MAP = mutableMapOf<Int, Any>()"
    }

    private fun headerString(): String {
        return """
@Suppress("FunctionName", "UsePropertyAccessSyntax", "RedundantUnitReturnType", "UNUSED_PARAMETER", "SpellCheckingInspection", "ConvertToStringTemplate", "DEPRECATION", "UNUSED_VARIABLE")
class ${classSimpleName}Plugin {
    companion object {
        @JvmStatic
        fun registerWith(registrar: Registrar) {
            val channel = MethodChannel(registrar.messenger(), "$methodChannel")
            channel.setMethodCallHandler { methodCall, methodResult ->
                val args = methodCall.arguments as? Map<String, Any> ?: mapOf()
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
                            || formalParams().any { it.type.isUnknownType() || it.type.isObfuscated() }
                            || returnType().run { isUnknownType() || isObfuscated() }
                        ) return

                        val methodBuilder = StringBuilder("")

                        val className = ancestorOf(JavaParser.ClassDeclarationContext::class)?.fullName() ?: ""
                        val params = formalParams().filter { it.type !in PRESERVED_CLASS }.toMutableList()
                        var methodName = name()
                        // 处理java方法重载的情况
                        if (methodName in methodList) {
                            methodName =
                                "${methodName}_${params.joinToString("") { it.type.toDartType().capitalize() }}"
                        }
                        val handlerMethodName =
                            "handle${javaFile.javaTypeInfo().name.replace("$", ".").replace(".", "_")}_$methodName"

                        methodBuilder.append("\t\tprivate fun $handlerMethodName(registrar: Registrar, args: Map<String, Any>, methodResult: MethodChannel.Result) {")

                        // 解析参数
                        methodBuilder.append(
                            formalParams()
                                .filter { !it.type.isCallback() }
                                .joinToString("") {
                                    when {
                                        it.type.jsonable() -> {
                                            "\n\t\t\tval ${it.name} = args[\"${it.name}\"] as ${it.type.capitalize().replace("[]", "Array")}"
                                        }
                                        it.type in PRESERVED_MODEL -> {
                                            it.convertPreservedModel()
                                        }
                                        it.type.isEnum() -> {
                                            "\n\t\t\tval ${it.name} = ${it.type}.values()[args[\"${it.name}\"] as Int]"
                                        }
                                        else -> {
                                            "\n\t\t\tval ${it.name} = REF_MAP[args[\"${it.name}\"] as Int] as ${it.type}"
                                        }
                                    }
                                }
                        )

                        // 静态方法单独处理
                        if (isStatic()) {
                            // 返回类型是jsonable
                            when {
                                returnType() == "void" -> methodBuilder.append(
                                    Temps.Kotlin.PlatformView.staticReturnVoid.placeholder(
                                        className,
                                        // 方法体内调用的时候, 要用原始的方法名
                                        name(),
                                        formalParams().joinToString {
                                            if (!it.type.isCallback())
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
                                        // 方法体内调用的时候, 要用原始的方法名
                                        name(),
                                        formalParams().joinToString {
                                            if (!it.type.isCallback())
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
                                        // 方法体内调用的时候, 要用原始的方法名
                                        name(),
                                        formalParams().joinToString {
                                            if (!it.type.isCallback())
                                                it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                            }
                            methodBuilder.appendln("\n\t\t}")
                        } else {
                            // 返回类型是jsonable
                            when {
                                // 返回void
                                returnType() == "void" -> methodBuilder.append(
                                    Temps.Kotlin.PlatformView.refReturnVoid.placeholder(
                                        className.replace("_", "."),
                                        // 方法体内调用的时候, 要用原始的方法名
                                        name(),
                                        formalParams().joinToString {
                                            if (!it.type.isCallback())
                                                it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                                returnType().jsonable() -> methodBuilder.append(
                                    Temps.Kotlin.PlatformView.refReturnJsonable.placeholder(
                                        className.replace("_", "."),
                                        // 方法体内调用的时候, 要用原始的方法名
                                        name(),
                                        formalParams().joinToString {
                                            if (!it.type.isCallback())
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
                                        className.replace("_", "."),
                                        // 方法体内调用的时候, 要用原始的方法名
                                        name(),
                                        formalParams().joinToString {
                                            if (!it.type.isCallback())
                                                it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                            }
                            methodBuilder.appendln("\n\t\t}")
                        }
                        methodHandlers.add(methodBuilder.toString())

                        resultBuilder.append(
                            Temps.Kotlin.PlatformView.methodBranchHeader.placeholder(
                                className,
                                methodName,
                                "$handlerMethodName(registrar, args, methodResult)"
                            )
                        )
                        methodList.add(methodName)
                    }
                }
            })

        return resultBuilder.toString()
    }

    private fun registerPlatformFactory(viewFile: File): String {
        val javaTypeInfo = viewFile.javaTypeInfo()
        return """
            registrar
                    .platformViewRegistry()
                    .registerViewFactory("$outputOrg/${javaTypeInfo.name}", ${javaTypeInfo.name.simpleName()}Factory(registrar))
        """
    }

    private fun generatePlatformView(javaFile: JAVA_FILE) {
        val platformViewSource =
            Temps.Kotlin.PlatformView.factory.placeholder(javaFile.nameWithoutExtension, javaFile.javaTypeInfo().name)

        "${OutputProject.Android.kotlinDirPath}${javaFile.nameWithoutExtension}Factory.kt".file().run {
            writeText(platformViewSource)
        }
    }
}