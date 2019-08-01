package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.JAVA_FILE
import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.common.extensions.fromJson
import me.yohom.fluttify.common.extensions.simpleName
import me.yohom.fluttify.common.extensions.underscore2Camel
import me.yohom.fluttify.common.model.SDK
import me.yohom.fluttify.common.tmpl.kotlin.platformviewfactory.PlatformViewFactoryTmpl
import me.yohom.fluttify.common.tmpl.kotlin.plugin.PluginTmpl
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File

/**
 * Android端接口生成
 *
 * 输入: java文件
 * 输出: 对应的method channel文件
 */
open class AndroidKotlinInterface : DefaultTask() {

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        val ext = project.extensions.getByType(FluttifyExtension::class.java)
        val pluginOutputFile =
            "${project.projectDir}/output-project/${ext.outputProjectName}/android/src/main/kotlin/${ext.outputOrg.replace(
                ".",
                "/"
            )}/${ext.outputProjectName}/${ext.outputProjectName.underscore2Camel(true)}Plugin.kt"

//        val branchesBuilder = StringBuilder("")
//        val platformViewRegisterBuilder = StringBuilder("")
//
//        // 生成所有方法的分支
//        project.projectDir.iterate("java") {
//            if (!it.nameWithoutExtension.isObfuscated() && !it.readText().isIgnore()) {
//                branchesBuilder.append(generateForFile(it))
//            }
//        }
//
//        // 注册所有的View
//        project.projectDir.iterate("java") {
//            if (it.readText().isView()) {
//                if (it.readText().isView()) {
//                    platformViewRegisterBuilder.appendln(registerPlatformFactory(it))
//                    generatePlatformViewFactory(it)
//                }
//            }
//        }
//
//        // package
//        val pluginClassString = Tmpl.Kotlin.pluginBuilder
//            .replace("#__package_name__#", "$outputOrg.$outputProjectName")
//            .replace("#__plugin_in_name__#", classSimpleName)
//            .replace("#__method_channel__#", methodChannel)
//            .replaceParagraph("#__dispatcher__#", branchesBuilder.toString())
//            .replaceParagraph("#__register_platform_views__#", platformViewRegisterBuilder.toString())
//            .replaceParagraph("#__handlers__#", methodHandlers.joinToString("\n"))

        val sdk = "${project.projectDir}/ir/android/json_representation.json".file().readText().fromJson<SDK>()

        // 生成主plugin文件
        sdk.libs.forEach {
            PluginTmpl(it, ext)
                .kotlinPlugin()
                .run {
                    pluginOutputFile.file().writeText(this)
                }
        }

        // 生成PlatformViewFactory文件
        sdk.libs
            .flatMap { it.types }
            .filter { it.isView() }
            .forEach {
                val factoryOutputFile =
                    "${project.projectDir}/output-project/${ext.outputProjectName}/android/src/main/kotlin/${ext.outputOrg.replace(
                        ".",
                        "/"
                    )}/${ext.outputProjectName}/${it.name.simpleName()}Factory.kt".file()

                PlatformViewFactoryTmpl(it, ext)
                    .kotlinPlatformViewFactory()
                    .run {
                        factoryOutputFile.writeText(this)
                    }
            }
    }

    private fun generateForFile(javaFile: JAVA_FILE): String {
        return ""
//        val branchBuilder = StringBuilder("")
//        val methodList = mutableListOf<String>()
//
//        val javaSource = javaFile.readText()
//
//        // 如果类可以直接构造的话, 那么为其添加一个object creator方法
//        if (!javaFile.nameWithoutExtension.isObfuscated()
//            && javaSource.javaPublicNonDependencyConstructor()
//            && !javaSource.javaAllMemberStatic()
//            && !javaSource.isAbstract()
//        ) {
//            branchBuilder.appendln(
//                Tmpl.Kotlin.branchBuilder
//                    .replace("#__class_name__#", "ObjectCreator")
//                    .replace("#__method_name__#", "create${javaFile.javaType().name.replace(".", "_")}")
//                    .replace(
//                        "#__handler__#",
//                        "methodResult.success(${javaFile.javaType().name}().apply { REF_MAP[hashCode()] = this }.hashCode())"
//                    )
//            )
//        }
//
//        javaSource
//            .walkTree(object : JavaParserBaseListener() {
//                override fun enterFieldDeclaration(ctx: JavaParser.FieldDeclarationContext?) {
//                    ctx?.run {
//                        if (!isPublic()
//                            || name().isObfuscated()
//                            || typeName().run { isObfuscated() || isUnknownJavaType() || !jsonable() }
//                            || isStatic()
//                        ) return
//
//                        val handlerMethodBuilder = StringBuilder()
//
//                        val className = ancestorOf(JavaParser.ClassDeclarationContext::class)?.fullName() ?: ""
//
//                        val setterMethodName = "set${name().capitalize()}"
//                        val getterMethodName = "get${name().capitalize()}"
//
//                        val setterHandlerMethodName =
//                            "handle${javaFile.javaType().name.replace("$", ".").replace(".", "_")}_$setterMethodName"
//                        val getterHandlerMethodName =
//                            "handle${javaFile.javaType().name.replace("$", ".").replace(".", "_")}_$getterMethodName"
//
//                        if (!isFinal()) {
//                            handlerMethodBuilder.appendln(
//                                Tmpl.Kotlin.setterBuilder
//                                    .replace("#__setter_name__#", setterHandlerMethodName)
//                                    .replace("#__field_name__#", name())
//                                    .replace("#__field_type__#", typeName().capitalize().replace("[]", "Array"))
//                                    .replace("#__class_name__#", className)
//                            )
//
//                            branchBuilder.appendln(
//                                Tmpl.Kotlin.branchBuilder
//                                    .replace("#__class_name__#", className)
//                                    .replace("#__method_name__#", setterMethodName)
//                                    .replace("#__handler__#", "$setterHandlerMethodName(registrar, args, methodResult)")
//                            )
//                        }
//
//                        // Getter
//                        // 返回void
//                        handlerMethodBuilder.appendln(
//                            Tmpl.Kotlin.getterBuilder
//                                .replace("#__getter_name__#", getterHandlerMethodName)
//                                .replace("#__field_name__#", name())
//                                .replace("#__class_name__#", className)
//                        )
//
//                        branchBuilder.appendln(
//                            Tmpl.Kotlin.branchBuilder
//                                .replace("#__class_name__#", className)
//                                .replace("#__method_name__#", getterMethodName)
//                                .replace("#__handler__#", "$getterHandlerMethodName(registrar, args, methodResult)")
//                        )
//
//                        methodHandlers.add(handlerMethodBuilder.toString())
//
//                        methodList.add(setterMethodName)
//                        methodList.add(getterMethodName)
//                    }
//                }
//
//                override fun enterMethodDeclaration(ctx: JavaParser.MethodDeclarationContext?) {
//                    ctx?.run {
//                        if (!isPublic()
//                            || name() in IGNORE_METHOD
//                            || formalParams().any { it.typeName.name.isUnknownJavaType() || it.typeName.isObfuscated() }
//                            || returnType().run { isUnknownJavaType() || isObfuscated() }
//                        ) return
//
//                        val handlerMethodBuilder = StringBuilder("")
//
//                        val className = ancestorOf(JavaParser.ClassDeclarationContext::class)?.fullName() ?: ""
//
//                        val methodName = name()
//                        // 目前先不处理重载的情况, dart端也不处理
//                        if (methodName in methodList) {
//                            return
//                        }
//                        val handlerMethodName =
//                            "handle${javaFile.javaType().name.replace("$", ".").replace(".", "_")}_$methodName"
//
//                        handlerMethodBuilder.append("\t\tprivate fun $handlerMethodName(registrar: Registrar, args: Map<String, Any>, methodResult: MethodChannel.Result) {")
//
//                        // 解析参数
//                        handlerMethodBuilder.append(
//                            formalParams()
//                                .filter { !it.typeName.isCallback() }
//                                .joinToString("") {
//                                    when {
//                                        it.typeName.jsonable() -> {
//                                            "\n\t\t\tval ${it.name} = args[\"${it.name}\"] as ${it.typeName.name.capitalize().replace(
//                                                "[]",
//                                                "Array"
//                                            )}"
//                                        }
//                                        it.typeName in PRESERVED_MODEL -> {
//                                            it.convertPreservedModel()
//                                        }
//                                        it.typeName.isEnum() -> {
//                                            "\n\t\t\tval ${it.name} = ${it.typeName}.values()[args[\"${it.name}\"] as Int]"
//                                        }
//                                        else -> {
//                                            "\n\t\t\tval ${it.name} = REF_MAP[args[\"${it.name}\"] as Int] as ${it.typeName}"
//                                        }
//                                    }
//                                }
//                        )
//
//                        // 静态方法单独处理
//                        if (isStatic()) {
//                            // 返回类型是jsonable
//                            when {
//                                returnType() == "void" -> handlerMethodBuilder.append(
//                                    Tmpl.Kotlin.PlatformView.staticReturnVoid.placeholder(
//                                        className,
//                                        // 方法体内调用的时候, 要用原始的方法名
//                                        name(),
//                                        formalParams().joinToString {
//                                            if (!it.typeName.isJavaCallback())
//                                                if (it.typeName.isList()) "ArrayList(${it.name})" else it.name
//                                            else {
//                                                Callback(className, methodName, it.typeName).toString()
//                                            }
//                                        }
//                                    )
//                                )
//                                returnType().jsonable() -> handlerMethodBuilder.append(
//                                    Tmpl.Kotlin.PlatformView.staticReturnJsonable.placeholder(
//                                        className,
//                                        // 方法体内调用的时候, 要用原始的方法名
//                                        name(),
//                                        formalParams().joinToString {
//                                            if (!it.typeName.isCallback())
//                                                if (it.typeName.isList()) "ArrayList(${it.name})" else it.name
//                                            else {
//                                                Callback(className, methodName, it.typeName).toString()
//                                            }
//                                        }
//                                    )
//                                )
//                                returnType().isJavaRefType() -> handlerMethodBuilder.append(
//                                    Tmpl.Kotlin.PlatformView.staticReturnRef.placeholder(
//                                        className,
//                                        // 方法体内调用的时候, 要用原始的方法名
//                                        name(),
//                                        formalParams().joinToString {
//                                            if (!it.typeName.isJavaCallback())
//                                                if (it.typeName.isList()) "ArrayList(${it.name})" else it.name
//                                            else {
//                                                Callback(className, methodName, it.typeName).toString()
//                                            }
//                                        }
//                                    )
//                                )
//                            }
//                            handlerMethodBuilder.appendln("\n\t\t}")
//                        } else {
//                            // 返回类型是jsonable
//                            when {
//                                // 返回void
//                                returnType() == "void" -> handlerMethodBuilder.append(
//                                    Tmpl.Kotlin.PlatformView.refReturnVoid.placeholder(
//                                        className.replace("_", "."),
//                                        // 方法体内调用的时候, 要用原始的方法名
//                                        name(),
//                                        formalParams().joinToString {
//                                            if (!it.typeName.isJavaCallback())
//                                                if (it.typeName.isList()) "ArrayList(${it.name})" else it.name
//                                            else {
//                                                Callback(className, methodName, it.typeName).toString()
//                                            }
//                                        }
//                                    )
//                                )
//                                returnType().jsonable() -> handlerMethodBuilder.append(
//                                    Tmpl.Kotlin.PlatformView.refReturnJsonable.placeholder(
//                                        className.replace("_", "."),
//                                        // 方法体内调用的时候, 要用原始的方法名
//                                        name(),
//                                        formalParams().joinToString {
//                                            if (!it.typeName.isJavaCallback())
//                                                if (it.typeName.isList()) "ArrayList(${it.name})" else it.name
//                                            else {
//                                                Callback(className, methodName, it.typeName).toString()
//                                            }
//                                        }
//                                    )
//                                )
//                                // 返回类型是ref
//                                else -> handlerMethodBuilder.append(
//                                    Tmpl.Kotlin.PlatformView.refReturnRef.placeholder(
//                                        className.replace("_", "."),
//                                        // 方法体内调用的时候, 要用原始的方法名
//                                        name(),
//                                        formalParams().joinToString {
//                                            if (!it.typeName.isCallback())
//                                                if (it.typeName.isList()) "ArrayList(${it.name})" else it.name
//                                            else {
//                                                Callback(className, methodName, it.typeName).toString()
//                                            }
//                                        }
//                                    )
//                                )
//                            }
//                            handlerMethodBuilder.appendln("\n\t\t}")
//                        }
//
//                        // 添加到方法列表中, 准备handler方法的构造
//                        methodHandlers.add(handlerMethodBuilder.toString())
//
//                        // 添加branch代码
//                        branchBuilder.appendln(
//                            Tmpl.Kotlin.branchBuilder
//                                .replace("#__class_name__#", className)
//                                .replace("#__method_name__#", methodName)
//                                .replace("#__handler__#", "$handlerMethodName(registrar, args, methodResult)")
//                        )
//                        // 添加到方法名列表中, 检测重载方法需要, 因为目前是忽略重载方法的
//                        methodList.add(methodName)
//                    }
//                }
//            })
//
//        return branchBuilder.toString()
    }

    private fun registerPlatformFactory(viewFile: File): String {
        return ""
//        val javaTypeInfo = viewFile.javaType()
//        return Tmpl.Kotlin.platformViewRegisterBuilder
//            .replace("#__view_type__#", "$outputOrg/${javaTypeInfo.name}")
//            .replace("#__factory_name__#", javaTypeInfo.name.simpleName())
    }

    private fun generatePlatformViewFactory(javaFile: JAVA_FILE) {
//        "${OutputProject.Android.kotlinDirPath}${javaFile.nameWithoutExtension}Factory.kt".file().run {
//            writeText(
//                Tmpl.Kotlin.platformViewFactoryBuilder
//                    .replace("#__package_name__#", "$outputOrg.$outputProjectName")
//                    .replace("#__factory_name__#", javaFile.nameWithoutExtension)
//                    .replace("#__native_view__#", javaFile.javaType().name)
//            )
//        }
    }

}

/**
 * iOS端接口生成
 *
 * 输入: framework文件夹
 * 输出: 对应的method channel文件
 */
open class IOSSwiftInterface : DefaultTask() {

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
    }
}