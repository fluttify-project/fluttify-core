package task

import Configs
import Configs.outputOrg
import Configs.outputProjectName
import Jar
import OutputProject.Dart.androidDirPath
import OutputProject.Dart.iOSDirPath
import OutputProject.methodChannel
import common.*
import common.extensions.*
import common.model.Method
import common.model.TypeType
import common.model.Variable

/**
 * 生成Java文件的Dart接口文件
 *
 * 输入: Java文件
 * 输出: 生成接口后的Dart文件
 * 依赖: [DecompileClassTask]
 */
class AndroidDartInterfaceTask(private val javaFile: JAVA_FILE) : Task<JAVA_FILE, DART_FILE>(javaFile) {

    override fun process(): DART_FILE {
        val dartBuilder = StringBuilder()
        val androidViewBuilder = StringBuilder()

        // 生成java类对应的dart接口
        javaFile.javaType()
            .run {
                // 普通类
                if (typeType == TypeType.Class) {
                    val classString = Tmpl.Dart.classBuilder
                        // 导入当前所在包的所有文件
                        .replace("#__current_package__#", "$outputProjectName/$outputProjectName")
                        // 类名
                        .replace("#__class_name__#", name.toDartType())
                        // method channel名称
                        .replace("#__method_channel__#", methodChannel)
                        // getter 目前只支持jsonable的字段
                        .replaceParagraph("#__getters__#", fields
                            .filter {
                                it.isPublic == true
                                        && it.isStatic == false
                                        && !it.variable.type.run { isUnknownJavaType() || isObfuscated() || !jsonable() }
                            }
                            .distinctBy { it.variable.name }
                            .joinToString("\n") {
                                Tmpl.Dart.getterBuilder
                                    .replace("#__type__#", it.variable.type.toDartType())
                                    .replace("#__name__#", it.variable.name.capitalize())
                                    .replace(
                                        "#__getter_method__#",
                                        "${this.name}::get${it.variable.name.capitalize()}"
                                    )
                            })
                        // setter 只有不是final且public的字段需要加 目前只支持jsonable的字段
                        .replaceParagraph("#__setters__#", fields
                            .filter {
                                it.isPublic == true
                                        && it.isFinal == false
                                        && it.isStatic == false
                                        && !it.variable.type.run { isUnknownJavaType() || isObfuscated() || !jsonable() }
                            }
                            .distinctBy { it.variable.name }
                            .joinToString("\n") {
                                Tmpl.Dart.setterBuilder
                                    .replace("#__name__#", it.variable.name.capitalize())
                                    .replace("#__type__#", it.variable.type.toDartType())
                                    .replace("#__arg__#", it.variable.name)
                                    .replace(
                                        "#__setter_method__#",
                                        "${this.name}::set${it.variable.name.capitalize()}"
                                    )
                            })
                        // 方法们
                        .replaceParagraph("#__methods__#", methods
                            // 过滤掉混淆, 未知参数类型, 未知返回类型的方法
                            .filter {
                                !it.name.isObfuscated()
                                        && it.formalParams.all { !(it.type.isUnknownJavaType() || it.type.isObfuscated()) }
                                        && !it.returnType.run { isObfuscated() || isUnknownJavaType() }
                                        && it.name !in IGNORE_METHOD
                            }
                            .distinctBy { it.name }
                            .joinToString("\n") { method ->
                                Tmpl.Dart.methodBuilder
                                    // 是否静态
                                    .replace("#__static__#", if (method.isStatic) "static" else "")
                                    // 返回类型
                                    .replace("#__return_type__#", method.returnType.toDartType())
                                    // 方法名
                                    .replace("#__method__#", method.name)
                                    // 形参
                                    .replace(
                                        "#__formal_params__#",
                                        method.formalParams.joinToString { it.toDartString() })
                                    // 返回语句
                                    .replace("#__return_statement__#", returnString(method.returnType))
                                    // 方法体的调用语句
                                    .replaceParagraph(
                                        "#__invoke__#", invokeString(
                                            method.isStatic,
                                            name,
                                            method.name,
                                            method.formalParams
                                        )
                                    )
                                    // 方法体的回调语句
                                    .replaceParagraph(
                                        "#__callback__#", method.formalParams
                                            .filter { it.type.isCallback() }
                                            .flatMap { Jar.Decompiled.CLASSES[it.type]!!.methods }
                                            .takeIf { it.isNotEmpty() }
                                            ?.run {
                                                Tmpl.Dart.callbackBuilder
                                                    .replace(
                                                        "#__callback_channel__#",
                                                        "$name::${method.name}_Callback"
                                                    )
                                                    .replaceParagraph(
                                                        "#__cases__#", callbackString(
                                                            name,
                                                            method.name,
                                                            this
                                                        )
                                                    )
                                            } ?: ""
                                    )
                            })
                    dartBuilder.append(classString)
                }
                // 枚举类
                else if (typeType == TypeType.Enum) {
                    val classString = Tmpl.Dart.enumBuilder
                        // 类名
                        .replace("#__enum_name__#", name.toDartType())
                        // 枚举值
                        .replaceParagraph("#__enum_constant__#", this.fields.joinToString(",\n") { it.variable.type })
                    dartBuilder.append(classString)
                }

                // 碰到view类型的的类, 生成对应的PlatformView
                val androidViewString = if (superClass in listOf("android.view.View", "android.view.ViewGroup")) {
                    Tmpl.Dart.androidViewBuilder
                        // 导入当前所在包的所有文件
                        .replace("#__current_package__#", "$outputProjectName/$outputProjectName")
                        // PlatformView的简写类名
                        .replace("#__view_simple_name__#", name.simpleName())
                        // PlatformView的简写类名
                        .replace("#__view_type__#", name)
                        // PlatformView的类名
                        .replace("#__view__#", name.toDartType())
                        // 输出工程的组织名称
                        .replace("#__org__#", outputOrg)
                } else ""
                androidViewBuilder.append(androidViewString)
            }

        // 写入PlatformView文件
        if (androidViewBuilder.toString().isNotBlank()) {
            "${androidDirPath}android_${javaFile.javaType().name.simpleName().camel2Underscore()}.dart".file()
                .writeText(androidViewBuilder.toString())
        }

        return "$androidDirPath${javaFile
            .toRelativeString(Jar.Decompiled.rootDirPath.file())
            .substringBeforeLast(".")
            .replace("$", "_")}.dart"
            .file()
            .apply { writeText(dartBuilder.toString()) }
    }

    /**
     * 方法体拼接字符串
     */
    private fun invokeString(
        isStatic: Boolean,
        className: String,
        methodName: String,
        params: List<Variable>
    ): String {
        val resultBuilder = StringBuilder("")

        val actualParams = params
            .filter { !it.type.isCallback() }
            .toMutableList()
            .apply { if (!isStatic) add(Variable("int", "refId")) }
            .toDartMap {
                when {
                    it.type.isEnum() -> "${it.name}.index"
                    it.type.isList() -> "${it.name}.map((it) => it.refId).toList()"
                    it.type.jsonable() -> it.name
                    else -> "${it.name}.refId"
                }
            }

        resultBuilder.append(
            "final result = await _channel.invokeMethod('$className::$methodName', $actualParams);\n"
        )
        return resultBuilder.toString()
    }

    private fun callbackString(
        className: String,
        methodName: String,
        callbacks: List<Method>
    ): String {
        val resultBuilder = StringBuilder("")
        callbacks
            .distinctBy { it.name }
            .forEach { callback ->
                resultBuilder.appendln(
                    Tmpl.Dart.callbackCaseBuilder
                        .replace("#__callback_case__#", "$className::${methodName}_Callback::${callback.name}")
                        .replace("#__callback_handler__#", callback.name)
                        .replace("#__callback_args__#", callback.formalParams.joinToString {
                            if (it.type.jsonable()) {
                                "args['${it.name}']"
                            } else {
                                "${it.type.toDartType()}.withRefId(args['${it.name}'])"
                            }
                        })
                )
            }
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
                    "(result as List).cast<${returnType.genericType().toDartType()}>()"
                )
            } else {
                resultBuilder.append("result")
            }
        } else if (returnType.isEnum()) {
            resultBuilder.append("${returnType.toDartType()}.values[result]")
        } else {
            if (returnType.isList()) {
                resultBuilder.append(
                    "(result as List).map((it) => ${returnType.genericType().toDartType()}.withRefId(it))"
                )
            } else {
                resultBuilder.append("${returnType.toDartType()}.withRefId(result)")
            }
        }

        return resultBuilder.toString()
    }
}

/**
 * 生成Objc文件的Dart接口文件
 *
 * 输入: objc文件
 * 输出: 生成接口后的Dart文件
 * 依赖: [DecompileClassTask]
 */
class IOSDartInterfaceTask(private val objcFile: JAVA_FILE) : Task<OBJC_FILE, DART_FILE>(objcFile) {

    override fun process(): DART_FILE {
        val dartBuilder = StringBuilder("")
        val uikitViewBuilder = StringBuilder("")

        // 生成objc类对应的dart接口
        objcFile.objcType()
            .forEach { type ->
                // 普通类
                if (type.typeType == TypeType.Class) {
                    val classString = Tmpl.Dart.classBuilder
                        // 导入当前所在包的所有文件
                        .replace("#__current_package__#", "$outputProjectName/$outputProjectName")
                        // 类名
                        .replace("#__class_name__#", type.name.toDartType())
                        // method channel名称
                        .replace("#__method_channel__#", methodChannel)
                        // getter 目前只支持jsonable的字段
                        .replaceParagraph("#__getters__#", type.fields
                            .filter {
                                it.isPublic == true
                                        && it.isStatic == false
                                        && !it.variable.type.run { isUnknownJavaType() || isObfuscated() || !jsonable() }
                            }
                            .distinctBy { it.variable.name }
                            .joinToString("\n") {
                                Tmpl.Dart.getterBuilder
                                    .replace("#__type__#", it.variable.type.toDartType())
                                    .replace("#__name__#", it.variable.name.capitalize())
                                    .replace(
                                        "#__getter_method__#",
                                        "${type.name}::get${it.variable.name.capitalize()}"
                                    )
                            })
                        // setter 只有不是final且public的字段需要加 目前只支持jsonable的字段
                        .replaceParagraph("#__setters__#", type.fields
                            .filter {
                                it.isPublic == true
                                        && it.isFinal == false
                                        && it.isStatic == false
                                        && !it.variable.type.run { isUnknownJavaType() || isObfuscated() || !jsonable() }
                            }
                            .distinctBy { it.variable.name }
                            .joinToString("\n") {
                                Tmpl.Dart.setterBuilder
                                    .replace("#__name__#", it.variable.name.capitalize())
                                    .replace("#__type__#", it.variable.type.toDartType())
                                    .replace("#__arg__#", it.variable.name)
                                    .replace(
                                        "#__setter_method__#",
                                        "${type.name}::set${it.variable.name.capitalize()}"
                                    )
                            })
                        // 方法们
                        .replaceParagraph("#__methods__#", type.methods
                            // 过滤掉混淆, 未知参数类型, 未知返回类型的方法
                            .filter {
                                !it.name.isObfuscated()
                                        && it.formalParams.all { !(it.type.isUnknownObjcType() || it.type.isObfuscated()) }
                                        && !it.returnType.run { isObfuscated() || isUnknownObjcType() }
                                        && it.name !in IGNORE_METHOD
                            }
                            .distinctBy { it.name }
                            .joinToString("\n") { method ->
                                Tmpl.Dart.methodBuilder
                                    // 是否静态
                                    .replace("#__static__#", if (method.isStatic) "static" else "")
                                    // 返回类型
                                    .replace("#__return_type__#", method.returnType.toDartType())
                                    // 方法名
                                    .replace("#__method__#", method.name)
                                    // 形参
                                    .replace(
                                        "#__formal_params__#",
                                        method.formalParams.joinToString { it.toDartString() })
                                    // 返回语句
                                    .replace("#__return_statement__#", returnString(method.returnType))
                                    // 方法体的调用语句
                                    .replaceParagraph(
                                        "#__invoke__#", invokeString(
                                            method.isStatic,
                                            type.name,
                                            method.name,
                                            method.formalParams
                                        )
                                    )
                                    // 方法体的回调语句
                                    .replaceParagraph(
                                        "#__callback__#", method.formalParams
                                            .filter { it.type.isCallback() }
                                            .flatMap { Jar.Decompiled.CLASSES[it.type]!!.methods }
                                            .takeIf { it.isNotEmpty() }
                                            ?.run {
                                                Tmpl.Dart.callbackBuilder
                                                    .replace(
                                                        "#__callback_channel__#",
                                                        "${type.name}::${method.name}_Callback"
                                                    )
                                                    .replaceParagraph(
                                                        "#__cases__#", callbackString(
                                                            type.name,
                                                            method.name,
                                                            this
                                                        )
                                                    )
                                            } ?: ""
                                    )
                            })
                    dartBuilder.appendln(classString)
                }
                // 枚举类
                else if (type.typeType == TypeType.Enum) {
                    val classString = Tmpl.Dart.enumBuilder
                        // 类名
                        .replace("#__enum_name__#", type.name.toDartType())
                        // 枚举值
                        .replaceParagraph("#__enum_constant__#", type.fields.joinToString(",\n") { it.variable.type })
                    dartBuilder.appendln(classString)
                }

                // 碰到view类型的的类, 生成对应的PlatformView
                val uikitViewString = if (type.superClass == "UIView") {
                    Tmpl.Dart.uikitViewBuilder
                        // 导入当前所在包的所有文件
                        .replace("#__current_package__#", "$outputProjectName/$outputProjectName")
                        // PlatformView的简写类名
                        .replace("#__view_simple_name__#", type.name.simpleName())
                        // PlatformView的简写类名
                        .replace("#__view_type__#", type.name)
                        // PlatformView的类名
                        .replace("#__view__#", type.name.toDartType())
                        // 输出工程的组织名称
                        .replace("#__org__#", outputOrg)
                } else ""
                uikitViewBuilder.appendln(uikitViewString)
            }

        // 写入PlatformView文件
        if (uikitViewBuilder.toString().isNotBlank()) {
            "${iOSDirPath}ios_${objcFile.nameWithoutExtension}.dart".file()
                .writeText(uikitViewBuilder.toString())
        }

        // 去掉重复的import
        val imports = dartBuilder.lines().filter { it.startsWith("import") }.distinct().joinToString("\n")
        val withoutImports = dartBuilder.lines().filter { !it.startsWith("import") }.joinToString("\n")

        val result = "$imports\n$withoutImports"
        return "$iOSDirPath${objcFile
            .toRelativeString(Configs.frameworkDirPath.file())
            .substringBeforeLast(".")
            .replace("$", "_")}.dart"
            .file()
            .apply { writeText(result) }
    }

    /**
     * 方法体拼接字符串
     */
    private fun invokeString(
        isStatic: Boolean,
        className: String,
        methodName: String,
        params: List<Variable>
    ): String {
        val resultBuilder = StringBuilder("")

        val actualParams = params
            .filter { !it.type.isCallback() }
            .toMutableList()
            .apply { if (!isStatic) add(Variable("int", "refId")) }
            .toDartMap {
                when {
                    it.type.isEnum() -> "${it.name}.index"
                    it.type.isList() -> "${it.name}.map((it) => it.refId).toList()"
                    it.type.jsonable() -> it.name
                    else -> "${it.name}.refId"
                }
            }

        resultBuilder.append(
            "final result = await _channel.invokeMethod('$className::$methodName', $actualParams);\n"
        )
        return resultBuilder.toString()
    }

    private fun callbackString(
        className: String,
        methodName: String,
        callbacks: List<Method>
    ): String {
        val resultBuilder = StringBuilder("")
        callbacks
            .distinctBy { it.name }
            .forEach { callback ->
                resultBuilder.appendln(
                    Tmpl.Dart.callbackCaseBuilder
                        .replace("#__callback_case__#", "$className::${methodName}_Callback::${callback.name}")
                        .replace("#__callback_handler__#", callback.name)
                        .replace("#__callback_args__#", callback.formalParams.joinToString {
                            if (it.type.jsonable()) {
                                "args['${it.name}']"
                            } else {
                                "${it.type.toDartType()}.withRefId(args['${it.name}'])"
                            }
                        })
                )
            }
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
                    "(result as List).cast<${returnType.genericType().toDartType()}>()"
                )
            } else {
                resultBuilder.append("result")
            }
        } else if (returnType.isEnum()) {
            resultBuilder.append("${returnType.toDartType()}.values[result]")
        } else {
            if (returnType.isList()) {
                resultBuilder.append(
                    "(result as List).map((it) => ${returnType.genericType().toDartType()}.withRefId(it))"
                )
            } else {
                resultBuilder.append("${returnType.toDartType()}.withRefId(result)")
            }
        }

        return resultBuilder.toString()
    }
}