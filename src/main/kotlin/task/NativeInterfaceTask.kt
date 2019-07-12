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
        val branchesBuilder = StringBuilder("")
        val platformViewRegisterBuilder = StringBuilder("")

        jarDir.iterate("java") {
            if (!it.nameWithoutExtension.isObfuscated() && !it.readText().isIgnore()) {
                branchesBuilder.append(generateForFile(it))
            }
        }

        jarDir.iterate("java") {
            if (it.readText().isView()) {
                if (it.readText().isView()) {
                    platformViewRegisterBuilder.appendln(registerPlatformFactory(it))
                    generatePlatformViewFactory(it)
                }
            }
        }
        // package
        val pluginClassString = Tmpl.Kotlin.pluginBuilder
            .replace("#__package_name__#", "$outputOrg.$outputProjectName")
            .replace("#__plugin_in_name__#", classSimpleName)
            .replace("#__method_channel__#", methodChannel)
            .replaceParagraph("#__dispatcher__#", branchesBuilder.toString())
            .replaceParagraph("#__platform_views__#", platformViewRegisterBuilder.toString())
            .replaceParagraph("#__handlers__#", methodHandlers.joinToString("\n"))

        return OutputProject.Android.kotlinFilePath.file().apply { writeText(pluginClassString) }
    }

    private fun generateForFile(javaFile: JAVA_FILE): String {
        val branchBuilder = StringBuilder("")
        val methodList = mutableListOf<String>()

        val content = javaFile.readText()

        // 如果类可以直接构造的话, 那么为其添加一个object creator方法
        if (!javaFile.nameWithoutExtension.isObfuscated()
            && content.publicNonDependencyConstructor()
            && !content.allMemberStatic()
            && !content.isAbstract()
        ) {
            branchBuilder.appendln(
                Tmpl.Kotlin.branchBuilder
                    .replace("#__class_name__#", "ObjectCreator")
                    .replace("#__method_name__#", "create${javaFile.javaType().name.replace(".", "_")}")
                    .replace(
                        "#__handler__#",
                        "methodResult.success(${javaFile.javaType().name}().apply { REF_MAP[hashCode()] = this }.hashCode())"
                    )
            )
        }

        content
            .walkTree(object : JavaParserBaseListener() {
                override fun enterFieldDeclaration(ctx: JavaParser.FieldDeclarationContext?) {
                    ctx?.run {
                        if (!isPublic()
                            || name().isObfuscated()
                            || type().run { isObfuscated() || isUnknownJavaType() || !jsonable() }
                            || isStatic()
                        ) return

                        val handlerMethodBuilder = StringBuilder()

                        val className = ancestorOf(JavaParser.ClassDeclarationContext::class)?.fullName() ?: ""

                        val setterMethodName = "set${name().capitalize()}"
                        val getterMethodName = "get${name().capitalize()}"

                        val setterHandlerMethodName =
                            "handle${javaFile.javaType().name.replace("$", ".").replace(".", "_")}_$setterMethodName"
                        val getterHandlerMethodName =
                            "handle${javaFile.javaType().name.replace("$", ".").replace(".", "_")}_$getterMethodName"

                        if (!isFinal()) {
                            handlerMethodBuilder.appendln(
                                Tmpl.Kotlin.setterBuilder
                                    .replace("#__setter_name__#", setterHandlerMethodName)
                                    .replace("#__field_name__#", name())
                                    .replace("#__field_type__#", type().capitalize().replace("[]", "Array"))
                                    .replace("#__class_name__#", className)
                            )

                            branchBuilder.appendln(
                                Tmpl.Kotlin.branchBuilder
                                    .replace("#__class_name__#", className)
                                    .replace("#__method_name__#", setterMethodName)
                                    .replace("#__handler__#", "$setterHandlerMethodName(registrar, args, methodResult)")
                            )
                        }

                        // Getter
                        // 返回void
                        handlerMethodBuilder.appendln(
                            Tmpl.Kotlin.getterBuilder
                                .replace("#__getter_name__#", getterHandlerMethodName)
                                .replace("#__field_name__#", name())
                                .replace("#__class_name__#", className)
                        )

                        branchBuilder.appendln(
                            Tmpl.Kotlin.branchBuilder
                                .replace("#__class_name__#", className)
                                .replace("#__method_name__#", getterMethodName)
                                .replace("#__handler__#", "$getterHandlerMethodName(registrar, args, methodResult)")
                        )

                        methodHandlers.add(handlerMethodBuilder.toString())

                        methodList.add(setterMethodName)
                        methodList.add(getterMethodName)
                    }
                }

                override fun enterMethodDeclaration(ctx: JavaParser.MethodDeclarationContext?) {
                    ctx?.run {
                        if (!isPublic()
                            || name() in IGNORE_METHOD
                            || formalParams().any { it.type.isUnknownJavaType() || it.type.isObfuscated() }
                            || returnType().run { isUnknownJavaType() || isObfuscated() }
                        ) return

                        val handlerMethodBuilder = StringBuilder("")

                        val className = ancestorOf(JavaParser.ClassDeclarationContext::class)?.fullName() ?: ""

                        val methodName = name()
                        // 目前先不处理重载的情况, dart端也不处理
                        if (methodName in methodList) {
                            return
                        }
                        val handlerMethodName =
                            "handle${javaFile.javaType().name.replace("$", ".").replace(".", "_")}_$methodName"

                        handlerMethodBuilder.append("\t\tprivate fun $handlerMethodName(registrar: Registrar, args: Map<String, Any>, methodResult: MethodChannel.Result) {")

                        // 解析参数
                        handlerMethodBuilder.append(
                            formalParams()
                                .filter { !it.type.isCallback() }
                                .joinToString("") {
                                    when {
                                        it.type.jsonable() -> {
                                            "\n\t\t\tval ${it.name} = args[\"${it.name}\"] as ${it.type.capitalize().replace(
                                                "[]",
                                                "Array"
                                            )}"
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
                                returnType() == "void" -> handlerMethodBuilder.append(
                                    Tmpl.Kotlin.PlatformView.staticReturnVoid.placeholder(
                                        className,
                                        // 方法体内调用的时候, 要用原始的方法名
                                        name(),
                                        formalParams().joinToString {
                                            if (!it.type.isCallback())
                                                if (it.type.isList()) "ArrayList(${it.name})" else it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                                returnType().jsonable() -> handlerMethodBuilder.append(
                                    Tmpl.Kotlin.PlatformView.staticReturnJsonable.placeholder(
                                        className,
                                        // 方法体内调用的时候, 要用原始的方法名
                                        name(),
                                        formalParams().joinToString {
                                            if (!it.type.isCallback())
                                                if (it.type.isList()) "ArrayList(${it.name})" else it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                                returnType().isJavaRefType() -> handlerMethodBuilder.append(
                                    Tmpl.Kotlin.PlatformView.staticReturnRef.placeholder(
                                        className,
                                        // 方法体内调用的时候, 要用原始的方法名
                                        name(),
                                        formalParams().joinToString {
                                            if (!it.type.isCallback())
                                                if (it.type.isList()) "ArrayList(${it.name})" else it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                            }
                            handlerMethodBuilder.appendln("\n\t\t}")
                        } else {
                            // 返回类型是jsonable
                            when {
                                // 返回void
                                returnType() == "void" -> handlerMethodBuilder.append(
                                    Tmpl.Kotlin.PlatformView.refReturnVoid.placeholder(
                                        className.replace("_", "."),
                                        // 方法体内调用的时候, 要用原始的方法名
                                        name(),
                                        formalParams().joinToString {
                                            if (!it.type.isCallback())
                                                if (it.type.isList()) "ArrayList(${it.name})" else it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                                returnType().jsonable() -> handlerMethodBuilder.append(
                                    Tmpl.Kotlin.PlatformView.refReturnJsonable.placeholder(
                                        className.replace("_", "."),
                                        // 方法体内调用的时候, 要用原始的方法名
                                        name(),
                                        formalParams().joinToString {
                                            if (!it.type.isCallback())
                                                if (it.type.isList()) "ArrayList(${it.name})" else it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                                // 返回类型是ref
                                else -> handlerMethodBuilder.append(
                                    Tmpl.Kotlin.PlatformView.refReturnRef.placeholder(
                                        className.replace("_", "."),
                                        // 方法体内调用的时候, 要用原始的方法名
                                        name(),
                                        formalParams().joinToString {
                                            if (!it.type.isCallback())
                                                if (it.type.isList()) "ArrayList(${it.name})" else it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                            }
                            handlerMethodBuilder.appendln("\n\t\t}")
                        }

                        // 添加到方法列表中, 准备handler方法的构造
                        methodHandlers.add(handlerMethodBuilder.toString())

                        // 添加branch代码
                        branchBuilder.appendln(
                            Tmpl.Kotlin.branchBuilder
                                .replace("#__class_name__#", className)
                                .replace("#__method_name__#", methodName)
                                .replace("#__handler__#", "$handlerMethodName(registrar, args, methodResult)")
                        )
                        // 添加到方法名列表中, 检测重载方法需要, 因为目前是忽略重载方法的
                        methodList.add(methodName)
                    }
                }
            })

        return branchBuilder.toString()
    }

    private fun registerPlatformFactory(viewFile: File): String {
        val javaTypeInfo = viewFile.javaType()
        return Tmpl.Kotlin.platformViewRegisterBuilder
            .replace("#__view_type__#", "$outputOrg/${javaTypeInfo.name}")
            .replace("#__factory_name__#", javaTypeInfo.name.simpleName())
    }

    private fun generatePlatformViewFactory(javaFile: JAVA_FILE) {
        "${OutputProject.Android.kotlinDirPath}${javaFile.nameWithoutExtension}Factory.kt".file().run {
            writeText(
                Tmpl.Kotlin.platformViewFactoryBuilder
                    .replace("#__package_name__#", "$outputOrg.$outputProjectName")
                    .replace("#__factory_name__#", javaFile.nameWithoutExtension)
                    .replace("#__native_view__#", javaFile.javaType().name)
            )
        }
    }
}

/**
 * iOS端接口生成
 *
 * 输入: framework文件夹
 * 输出: 对应的method channel文件
 * 依赖: [DecompileClassTask]
 */
class IOSInterfaceTask(private val frameworkDir: DIR) : Task<DIR, OBJC_FILE>(frameworkDir) {
    private val methodHandlers = mutableListOf<String>()

    override fun process(): OBJC_FILE {
        val branchesBuilder = StringBuilder("")
        val platformViewRegisterBuilder = StringBuilder("")

        frameworkDir.iterate("h") {
            if (!it.nameWithoutExtension.isObfuscated() && !it.readText().isIgnore()) {
                branchesBuilder.append(generateForFile(it))
            }
        }

        frameworkDir.iterate("h") {
            if (it.readText().isView()) {
                if (it.readText().isView()) {
                    platformViewRegisterBuilder.appendln(registerPlatformFactory(it))
                    generatePlatformViewFactory(it)
                }
            }
        }
        // package
        val pluginClassString = Tmpl.Swift.pluginBuilder
            .replace("#__package_name__#", "$outputOrg.$outputProjectName")
            .replace("#__plugin_in_name__#", classSimpleName)
            .replace("#__method_channel__#", methodChannel)
            .replaceParagraph("#__dispatcher__#", branchesBuilder.toString())
            .replaceParagraph("#__platform_views__#", platformViewRegisterBuilder.toString())
            .replaceParagraph("#__handlers__#", methodHandlers.joinToString("\n"))

        return OutputProject.iOS.swiftFilePath.file().apply { writeText(pluginClassString) }
    }

    private fun generateForFile(objcFile: OBJC_FILE): String {
        val branchBuilder = StringBuilder("")
        val methodList = mutableListOf<String>()

        val content = objcFile.readText()

        // 如果类可以直接构造的话, 那么为其添加一个object creator方法
        if (!objcFile.nameWithoutExtension.isObfuscated()
            && content.publicNonDependencyConstructor()
            && !content.allMemberStatic()
            && !content.isAbstract()
        ) {
            branchBuilder.appendln(
                Tmpl.Swift.branchBuilder
                    .replace("#__class_name__#", "ObjectCreator")
                    .replace("#__method_name__#", "create${objcFile.javaType().name.replace(".", "_")}")
                    .replace(
                        "#__handler__#",
                        "methodResult.success(${objcFile.javaType().name}().apply { REF_MAP[hashCode()] = this }.hashCode())"
                    )
            )
        }

        content
            .walkTree(object : JavaParserBaseListener() {
                override fun enterFieldDeclaration(ctx: JavaParser.FieldDeclarationContext?) {
                    ctx?.run {
                        if (!isPublic()
                            || name().isObfuscated()
                            || type().run { isObfuscated() || isUnknownJavaType() || !jsonable() }
                            || isStatic()
                        ) return

                        val handlerMethodBuilder = StringBuilder()

                        val className = ancestorOf(JavaParser.ClassDeclarationContext::class)?.fullName() ?: ""

                        val setterMethodName = "set${name().capitalize()}"
                        val getterMethodName = "get${name().capitalize()}"

                        val setterHandlerMethodName =
                            "handle${objcFile.javaType().name.replace("$", ".").replace(".", "_")}_$setterMethodName"
                        val getterHandlerMethodName =
                            "handle${objcFile.javaType().name.replace("$", ".").replace(".", "_")}_$getterMethodName"

                        if (!isFinal()) {
                            handlerMethodBuilder.appendln(
                                Tmpl.Swift.setterBuilder
                                    .replace("#__setter_name__#", setterHandlerMethodName)
                                    .replace("#__field_name__#", name())
                                    .replace("#__field_type__#", type().capitalize().replace("[]", "Array"))
                                    .replace("#__class_name__#", className)
                            )

                            branchBuilder.appendln(
                                Tmpl.Swift.branchBuilder
                                    .replace("#__class_name__#", className)
                                    .replace("#__method_name__#", setterMethodName)
                                    .replace("#__handler__#", "$setterHandlerMethodName(registrar, args, methodResult)")
                            )
                        }

                        // Getter
                        // 返回void
                        handlerMethodBuilder.appendln(
                            Tmpl.Swift.getterBuilder
                                .replace("#__getter_name__#", getterHandlerMethodName)
                                .replace("#__field_name__#", name())
                                .replace("#__class_name__#", className)
                        )

                        branchBuilder.appendln(
                            Tmpl.Swift.branchBuilder
                                .replace("#__class_name__#", className)
                                .replace("#__method_name__#", getterMethodName)
                                .replace("#__handler__#", "$getterHandlerMethodName(registrar, args, methodResult)")
                        )

                        methodHandlers.add(handlerMethodBuilder.toString())

                        methodList.add(setterMethodName)
                        methodList.add(getterMethodName)
                    }
                }

                override fun enterMethodDeclaration(ctx: JavaParser.MethodDeclarationContext?) {
                    ctx?.run {
                        if (!isPublic()
                            || name() in IGNORE_METHOD
                            || formalParams().any { it.type.isUnknownJavaType() || it.type.isObfuscated() }
                            || returnType().run { isUnknownJavaType() || isObfuscated() }
                        ) return

                        val handlerMethodBuilder = StringBuilder("")

                        val className = ancestorOf(JavaParser.ClassDeclarationContext::class)?.fullName() ?: ""

                        val methodName = name()
                        // 目前先不处理重载的情况, dart端也不处理
                        if (methodName in methodList) {
                            return
                        }
                        val handlerMethodName =
                            "handle${objcFile.javaType().name.replace("$", ".").replace(".", "_")}_$methodName"

                        handlerMethodBuilder.append("\t\tprivate fun $handlerMethodName(registrar: Registrar, args: Map<String, Any>, methodResult: MethodChannel.Result) {")

                        // 解析参数
                        handlerMethodBuilder.append(
                            formalParams()
                                .filter { !it.type.isCallback() }
                                .joinToString("") {
                                    when {
                                        it.type.jsonable() -> {
                                            "\n\t\t\tval ${it.name} = args[\"${it.name}\"] as ${it.type.capitalize().replace(
                                                "[]",
                                                "Array"
                                            )}"
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
                                returnType() == "void" -> handlerMethodBuilder.append(
                                    Tmpl.Swift.PlatformView.staticReturnVoid.placeholder(
                                        className,
                                        // 方法体内调用的时候, 要用原始的方法名
                                        name(),
                                        formalParams().joinToString {
                                            if (!it.type.isCallback())
                                                if (it.type.isList()) "ArrayList(${it.name})" else it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                                returnType().jsonable() -> handlerMethodBuilder.append(
                                    Tmpl.Swift.PlatformView.staticReturnJsonable.placeholder(
                                        className,
                                        // 方法体内调用的时候, 要用原始的方法名
                                        name(),
                                        formalParams().joinToString {
                                            if (!it.type.isCallback())
                                                if (it.type.isList()) "ArrayList(${it.name})" else it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                                returnType().isJavaRefType() -> handlerMethodBuilder.append(
                                    Tmpl.Swift.PlatformView.staticReturnRef.placeholder(
                                        className,
                                        // 方法体内调用的时候, 要用原始的方法名
                                        name(),
                                        formalParams().joinToString {
                                            if (!it.type.isCallback())
                                                if (it.type.isList()) "ArrayList(${it.name})" else it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                            }
                            handlerMethodBuilder.appendln("\n\t\t}")
                        } else {
                            // 返回类型是jsonable
                            when {
                                // 返回void
                                returnType() == "void" -> handlerMethodBuilder.append(
                                    Tmpl.Swift.PlatformView.refReturnVoid.placeholder(
                                        className.replace("_", "."),
                                        // 方法体内调用的时候, 要用原始的方法名
                                        name(),
                                        formalParams().joinToString {
                                            if (!it.type.isCallback())
                                                if (it.type.isList()) "ArrayList(${it.name})" else it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                                returnType().jsonable() -> handlerMethodBuilder.append(
                                    Tmpl.Swift.PlatformView.refReturnJsonable.placeholder(
                                        className.replace("_", "."),
                                        // 方法体内调用的时候, 要用原始的方法名
                                        name(),
                                        formalParams().joinToString {
                                            if (!it.type.isCallback())
                                                if (it.type.isList()) "ArrayList(${it.name})" else it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                                // 返回类型是ref
                                else -> handlerMethodBuilder.append(
                                    Tmpl.Swift.PlatformView.refReturnRef.placeholder(
                                        className.replace("_", "."),
                                        // 方法体内调用的时候, 要用原始的方法名
                                        name(),
                                        formalParams().joinToString {
                                            if (!it.type.isCallback())
                                                if (it.type.isList()) "ArrayList(${it.name})" else it.name
                                            else {
                                                Callback(className, methodName, it.type).toString()
                                            }
                                        }
                                    )
                                )
                            }
                            handlerMethodBuilder.appendln("\n\t\t}")
                        }

                        // 添加到方法列表中, 准备handler方法的构造
                        methodHandlers.add(handlerMethodBuilder.toString())

                        // 添加branch代码
                        branchBuilder.appendln(
                            Tmpl.Swift.branchBuilder
                                .replace("#__class_name__#", className)
                                .replace("#__method_name__#", methodName)
                                .replace("#__handler__#", "$handlerMethodName(registrar, args, methodResult)")
                        )
                        // 添加到方法名列表中, 检测重载方法需要, 因为目前是忽略重载方法的
                        methodList.add(methodName)
                    }
                }
            })

        return branchBuilder.toString()
    }

    private fun registerPlatformFactory(viewFile: File): String {
        val javaTypeInfo = viewFile.javaType()
        return Tmpl.Swift.platformViewRegisterBuilder
            .replace("#__view_type__#", "$outputOrg/${javaTypeInfo.name}")
            .replace("#__factory_name__#", javaTypeInfo.name.simpleName())
    }

    private fun generatePlatformViewFactory(javaFile: JAVA_FILE) {
        "${OutputProject.Android.kotlinDirPath}${javaFile.nameWithoutExtension}Factory.kt".file().run {
            writeText(
                Tmpl.Swift.platformViewFactoryBuilder
                    .replace("#__package_name__#", "$outputOrg.$outputProjectName")
                    .replace("#__factory_name__#", javaFile.nameWithoutExtension)
                    .replace("#__native_view__#", javaFile.javaType().name)
            )
        }
    }
}