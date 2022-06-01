package me.yohom.fluttify.task

import me.yohom.fluttify.SYSTEM_TYPE
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.TypeType
import me.yohom.fluttify.tmpl.dart.type.type_constants.TypeConstantsTmpl
import me.yohom.fluttify.tmpl.dart.type.type_enum.TypeEnumTmpl
import me.yohom.fluttify.tmpl.dart.type.type_functions.TypeFunctionsTmpl
import me.yohom.fluttify.tmpl.dart.type.type_interface.TypeInterfaceTmpl
import me.yohom.fluttify.tmpl.dart.type.type_ref.type_cast.TypeCastTmpl
import me.yohom.fluttify.tmpl.dart.type.type_ref.type_check.DependencyTypeCheckTmpl
import me.yohom.fluttify.tmpl.dart.type.type_ref.type_check.TypeCheckTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.TypeExtensionTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.TypeSdkTmpl
import me.yohom.fluttify.tmpl.dart.view.android_view.AndroidViewTmpl
import me.yohom.fluttify.tmpl.dart.view.uikit_view.UiKitViewTmpl
import org.gradle.api.tasks.TaskAction

open class CommonObjects : FluttifyTask() {
    private val tmpl by lazy { getResource("/tmpl/dart/shared.dart.tmpl").readText() }

    @TaskAction
    fun process() {
        val content = tmpl.replaceGlobal()
        // 删除旧版本的文件
        "${project.projectDir}/output-project/${ext.projectName}/lib/src/facade/objects.g.dart".file().delete()
        "${project.projectDir}/output-project/${ext.projectName}/lib/src/facade/shared.g.dart".file().writeText(content)
    }
}

/**
 * 生成Java文件的Dart接口文件
 */
open class AndroidDartInterface : FluttifyTask() {
    @TaskAction
    fun process() {
        // 旧版json解析
        val jrFile = "${project.projectDir}/jr/${ext.projectName}.android.json".file()
        val sdk = jrFile.readText().parseSDK()
//        val irDir = "${project.projectDir}/ir/android/xml/".file()
//        val sdk = irDir.parseSDK()

        // 生成前先删除之前的文件
        "${project.projectDir}/output-project/${ext.projectName}/lib/src/android/".file().deleteRecursively()

        // 处理View, 生成AndroidView
        sdk.allTypes
            .filter { it.isView }
            .forEach {
                val dartAndroidView = AndroidViewTmpl(it)
                val viewName = it.name.replace("$", ".").simpleName()
                val androidViewFile =
                    "${project.projectDir}/output-project/${ext.projectName}/lib/src/android/platformview/${viewName}.g.dart"

                androidViewFile.file().writeText(dartAndroidView)
            }

        // 处理普通类
        sdk.allTypes
            .filterType()
            .forEach {
                val resultDart = when (it.typeType) {
                    TypeType.Class, TypeType.Struct -> TypeSdkTmpl(it)
//                    TypeType.Extension  -> TypeExtensionTmpl(it)
                    TypeType.Extension  -> ""
                    TypeType.Enum -> TypeEnumTmpl(it)
                    TypeType.Interface -> TypeInterfaceTmpl(it)
                    TypeType.Lambda -> ""
                    TypeType.Function -> ""
                    TypeType.Alias -> ""
                    null -> ""
                }

                if (resultDart.isNotBlank()) {
                    val fileName = it.name.replace("$", ".").replace(".", "/")
                    val resultFile =
                        "${project.projectDir}/output-project/${ext.projectName}/lib/src/android/${fileName}.g.dart"

                    resultFile.file().writeText(resultDart)
                }
            }

        // 顶层常量类
        sdk.directLibs
            .flatMap { it.topLevelConstants }
            .run {
                val resultDart = TypeConstantsTmpl(this)

                if (resultDart.isNotBlank()) {
                    val resultFile =
                        "${project.projectDir}/output-project/${ext.projectName}/lib/src/android/constants.g.dart"

                    resultFile.file().writeText(resultDart)
                }
            }

        // 处理所有的函数 但是java其实没有顶层函数, 所以这里的结果一定是空字符串
        sdk.allTypes
            .filterType()
            .filter { it.isKnownFunction && it.formalParams.all { !it.variable.isLambda() } }
            .distinctBy { it.name }
            .run {
                val functionsFile =
                    "${project.projectDir}/output-project/${ext.projectName}/lib/src/ios/functions.g.dart"

                functionsFile.file().writeText(TypeFunctionsTmpl(this))
            }

        val typeOpTmpl = getResource("/tmpl/dart/type_op.dart.tmpl").readText()
        val targetTypes = sdk.directLibs
            .flatMap { it.types }
            .union(SYSTEM_TYPE.filter { it.platform == Platform.Android }) // 造型需要把系统类加上
            .toList()
            .filterType()
            .asSequence()
            .filterNot { it.isLambda }
            .filterNot { it.isFunction }
            .filterNot { it.typeType == TypeType.Extension }
            .filterNot { it.isAlias() }
            .filterNot { it.isEnum }
            .filterNot { ext.android.exclude.classes.contains(it.name) }
            .filterNot { it.name == "android.view.SurfaceHolder.Callback" }
            .filterNot { it.name == "android.view.View.OnClickListener" }
            .filterNot { it.name == "android.view.View.OnTouchListener" }
            .filterNot { it.name == "java.lang.Object" }
            .filterNot { it.name == "java.lang.Void" }
            .filterNot { it.name.isVoid() }
            .distinctBy { it.name }
        // 类型检查
        val typeChecks = targetTypes.joinToString(" ") { TypeCheckTmpl(it) }
        // 插件依赖类型检查
        val dependencyTypeChecks = ext.pluginDependencies
            .keys
            .filter { it.endsWith("fluttify") }
            .joinToString(" ") { DependencyTypeCheckTmpl(it, sdk.platform) }
        // 类型造型
        val typeCasts = targetTypes.joinToString(" ") { TypeCastTmpl(it) }
        typeOpTmpl
            .replace("#__platform_import__#", "import 'package:${ext.projectName}/src/android/android.export.g.dart';")
            .replaceParagraph(
                "#__foundation__#",
                ext.foundationVersion.keys.joinToString("\n") { "import 'package:$it/$it.dart';" })
            .replaceParagraph(
                "#__dependency__#",
                ext.pluginDependencies.keys.joinToString("\n") { "import 'package:$it/$it.dart';" })
            .replace("#__plugin_name__#", ext.projectName.underscore2Camel())
            .replaceParagraph("#__dependency_type_cast__#", dependencyTypeChecks)
            .replace("#__platform__#", "Android")
            .replaceParagraph("#__type_check__#", typeChecks)
            .replaceParagraph("#__type_cast__#", typeCasts)
            .run {
                "${project.projectDir}/output-project/${ext.projectName}/lib/src/android/type_op.g.dart".file()
                    .writeText(this)
            }
    }
}

/**
 * 生成Objc文件的Dart接口文件
 */
open class IOSDartInterface : FluttifyTask() {
    @TaskAction
    fun process() {
// 旧版json解析
        val jrFile = "${project.projectDir}/jr/${ext.projectName}.ios.json".file()
        val sdk = jrFile.readText().parseSDK()
//        val irDir = "${project.projectDir}/ir/ios/xml/".file()
//        val sdk = irDir.parseSDK()

        // 生成前先删除之前的文件
        "${project.projectDir}/output-project/${ext.projectName}/lib/src/ios/".file().deleteRecursively()

        // 处理View, 生成UiKitView
        sdk.allTypes
            .filter { it.isView }
            .forEach {
                val dartUiKitView = UiKitViewTmpl(it)
                val uiKitViewFile =
                    "${project.projectDir}/output-project/${ext.projectName}/lib/src/ios/platformview/${it.name.simpleName()}.g.dart"

                uiKitViewFile.file().writeText(dartUiKitView)
            }

        // 处理普通类
        sdk.allTypes
            .filterType()
            .forEach {
                val resultDart = when (it.typeType) {
                    TypeType.Class, TypeType.Struct -> TypeSdkTmpl(it)
//                    TypeType.Extension  -> TypeExtensionTmpl(it) // 暂时先使用原先的合并扩展的方案
                    TypeType.Extension -> ""
                    TypeType.Enum -> TypeEnumTmpl(it)
                    TypeType.Interface -> TypeInterfaceTmpl(it)
                    TypeType.Lambda -> ""
                    TypeType.Function -> "" // 函数要单独处理, 全部放到一个文件里去
                    TypeType.Alias -> ""
                    null -> ""
                }

                if (resultDart.isNotBlank()) {
                    val resultFile =
                        "${project.projectDir}/output-project/${ext.projectName}/lib/src/ios/${it.name.replace(".", "/")}.g.dart"
                    resultFile.file().writeText(resultDart)
                }
            }

        // 顶层常量类
        sdk.directLibs
            .flatMap { it.topLevelConstants }
            .run {
                val resultDart = TypeConstantsTmpl(this)

                if (resultDart.isNotBlank()) {
                    val resultFile =
                        "${project.projectDir}/output-project/${ext.projectName}/lib/src/ios/constants.g.dart"

                    resultFile.file().writeText(resultDart)
                }
            }

        // 处理所有的函数
        sdk.directLibs
            .flatMap { it.types }
            .filterType()
            .filter { it.isKnownFunction && it.formalParams.all { !it.variable.isLambda() } }
            .distinctBy { it.name }
            .run {
                val functionsFile =
                    "${project.projectDir}/output-project/${ext.projectName}/lib/src/ios/functions.g.dart"

                functionsFile.file().writeText(TypeFunctionsTmpl(this))
            }

        val typeOpTmpl = this::class.java.getResource("/tmpl/dart/type_op.dart.tmpl")!!.readText()
        val targetTypes = sdk.directLibs
            .flatMap { it.types }
            .union(SYSTEM_TYPE.filter { it.platform == Platform.iOS }) // 造型需要把系统类加上
            .toList()
            .filterType()
            .asSequence()
            .filterNot { it.isLambda }
            .filterNot { it.isFunction }
            .filterNot { it.isExtension}
            .filterNot { it.isAlias() }
            .filterNot { it.isEnum }
            .filterNot { ext.ios.exclude.classes.contains(it.name) }
            .filterNot { it.name == "NSObject" }
            .filterNot { it.name.isVoid() }
            .distinctBy { it.name }
            .filter { if (ext.foundationVersion.keys.contains("core_location_fluttify")) true else !it.name.startsWith("CL") }
        // 类型检查
        val typeChecks = targetTypes.joinToString(" ") { TypeCheckTmpl(it) }
        // 插件依赖类型检查
        val dependencyTypeChecks = ext.pluginDependencies
            .keys
            .filter { it.endsWith("fluttify") }
            .joinToString(" ") { DependencyTypeCheckTmpl(it, sdk.platform) }
        // 类型造型
        val typeCasts = targetTypes.joinToString(" ") { TypeCastTmpl(it) }
        typeOpTmpl
            .replace("#__platform_import__#", "import 'package:${ext.projectName}/src/ios/ios.export.g.dart';")
            .replaceParagraph(
                "#__foundation__#",
                ext.foundationVersion.keys.joinToString("\n") { "import 'package:$it/$it.dart';" })
            .replaceParagraph(
                "#__dependency__#",
                ext.pluginDependencies.keys.joinToString("\n") { "import 'package:$it/$it.dart';" })
            .replace("#__plugin_name__#", ext.projectName.underscore2Camel())
            .replace("#__platform__#", "IOS")
            .replaceParagraph("#__type_check__#", typeChecks)
            .replaceParagraph("#__dependency_type_cast__#", dependencyTypeChecks)
            .replaceParagraph("#__type_cast__#", typeCasts)
            .run {
                "${project.projectDir}/output-project/${ext.projectName}/lib/src/ios/type_op.g.dart".file()
                    .writeText(this)
            }
    }

}