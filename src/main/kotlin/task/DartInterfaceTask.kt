package task

import Configs.outputOrg
import Configs.outputProjectName
import Jar
import OutputProject.Dart.androidDirPath
import OutputProject.methodChannel
import common.DART_FILE
import common.IGNORE_METHOD
import common.JAVA_FILE
import common.Tmpl
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
class DartInterfaceTask(private val javaFile: JAVA_FILE) : Task<JAVA_FILE, DART_FILE>(javaFile) {

    override fun process(): DART_FILE {
        val dartBuilder = StringBuilder()
        val androidViewBuilder = StringBuilder()

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
                        // 方法们
                        .replaceParagraph("#__methods__#", methods
                            // 过滤掉混淆, 未知参数类型, 未知返回类型的方法
                            .filter {
                                !it.name.isObfuscated()
                                        && it.formalParams.all { !(it.type.isUnknownType() || it.type.isObfuscated()) }
                                        && !it.returnType.run { isObfuscated() || isUnknownType() }
                                        && it.name !in IGNORE_METHOD
                            }
                            .distinctBy { it.name }
                            .joinToString("\n") {
                                Tmpl.Dart.methodBuilder
                                    // 返回类型
                                    .replace("#__return_type__#", it.returnType.toDartType())
                                    // 方法名
                                    .replace("#__method__#", it.name)
                                    // 形参
                                    .replace(
                                        "#__formal_params__#",
                                        it.formalParams.joinToString { it.toDartString() })
                                    // 返回语句
                                    .replace("#__return_statement__#", returnString(it.returnType))
                                    // 方法体的语句
                                    .replaceParagraph(
                                        "#__statements__#", methodBodyString(
                                            it.isStatic,
                                            name,
                                            it.name,
                                            it.formalParams,
                                            it.formalParams
                                                .filter { it.type.isCallback() }
                                                .flatMap { Jar.Decompiled.CLASSES[it.type]!!.methods }
                                        )
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
                        .replaceParagraph("#__enum_constant__#", this.fields.joinToString(",\n") { it.type })
                    dartBuilder.append(classString)
                }

                val androidViewString = if (superClass in listOf("View", "ViewGroup")) {
                    Tmpl.Dart.androidViewBuilder
                        // 导入当前所在包的所有文件
                        .replace("#__current_package__#", "$outputProjectName/$outputProjectName")
                        // PlatformView的简写类名
                        .replace("#__view_simple_name__#", name.simpleName())
                        // PlatformView的类名
                        .replace("#__view__#", name.toDartType())
                        // 输出工程的组织名称
                        .replace("#__org__#", outputOrg)
                } else ""
                androidViewBuilder.append(androidViewString)
            }

        if (androidViewBuilder.toString().isNotBlank()) {
            "${androidDirPath}android_${javaFile.javaType().name.simpleName().camel2Underscore()}.dart".file()
                .writeText(androidViewBuilder.toString())
        }

        return "$androidDirPath${javaFile.toRelativeString(Jar.Decompiled.rootDirPath.file()).substringBeforeLast(
            "."
        ).replace("$", "_")}.dart".file()
            .apply { writeText(dartBuilder.toString()) }
    }

    /**
     * 方法体拼接字符串
     */
    private fun methodBodyString(
        isStatic: Boolean,
        className: String,
        methodName: String,
        params: List<Variable>,
        callbacks: List<Method>
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

        callbacks
            .distinctBy { it.name }
            .forEachIndexed { index, lambda ->
                if (index == 0) {
                    resultBuilder.append(
                        """MethodChannel('$className::${methodName}_Callback' + refId.toString())
                        .setMethodCallHandler((methodCall) { 
                            final args = methodCall.arguments as Map; 
                            final refId = args['refId'] as int; 
                            if (refId != this.refId) return;

                            switch (methodCall.method) {"""
                    )
                }

                resultBuilder.append(
                    """
            case '$className::${methodName}_Callback::${lambda.name}':
              if (${lambda.name} != null) {
                ${lambda.name}(${lambda.formalParams.joinToString {
                        if (it.type.jsonable()) {
                            "args['${it.name}']"
                        } else {
                            "${it.type.toDartType()}.withRefId(args['${it.name}'])"
                        }
                    }});
              }
              break;"""
                )

                if (index == callbacks.distinctBy { it.name }.lastIndex) {
                    resultBuilder.append("""default: break; } });""")
                }
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