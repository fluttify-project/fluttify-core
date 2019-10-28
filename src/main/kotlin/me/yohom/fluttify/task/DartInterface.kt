package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.filterType
import me.yohom.fluttify.extensions.fromJson
import me.yohom.fluttify.extensions.simpleName
import me.yohom.fluttify.model.SDK
import me.yohom.fluttify.model.TypeType
import me.yohom.fluttify.tmpl.dart.type.type_enum.TypeEnumTmpl
import me.yohom.fluttify.tmpl.dart.type.type_functions.TypeFunctionsTmpl
import me.yohom.fluttify.tmpl.dart.type.type_interface.TypeInterfaceTmpl
import me.yohom.fluttify.tmpl.dart.type.type_ref.type_cast.TypeCastTmpl
import me.yohom.fluttify.tmpl.dart.type.type_ref.type_check.TypeCheckTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.TypeSdkTmpl
import me.yohom.fluttify.tmpl.dart.view.android_view.AndroidViewTmpl
import me.yohom.fluttify.tmpl.dart.view.uikit_view.UiKitViewTmpl
import org.gradle.api.tasks.TaskAction

/**
 * 生成Java文件的Dart接口文件
 */
open class AndroidDartInterface : FluttifyTask() {
    @TaskAction
    fun process() {
        val jrFile = "${project.projectDir}/jr/${ext.outputProjectName}.android.json".file()
        val sdk = jrFile.readText().fromJson<SDK>()

        // 生成前先删除之前的文件
        "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/".file().deleteRecursively()

        // 处理View, 生成AndroidView
        sdk.directLibs
            .flatMap { it.types }
            .filter { it.isView() && !it.isObfuscated() }
            .forEach {
                val dartAndroidView = AndroidViewTmpl(it).dartAndroidView()
                val androidViewFile =
                    "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/platformview/${it.name.simpleName()}.g.dart"

                androidViewFile.file().writeText(dartAndroidView)
            }

        // 处理普通类
        sdk.directLibs
            .flatMap { it.types }
            .filterType()
            .forEach {
                val resultDart = when (it.typeType) {
                    TypeType.Class, TypeType.Struct -> TypeSdkTmpl(it).dartClass()
                    TypeType.Enum -> TypeEnumTmpl(it).dartEnum()
                    TypeType.Interface -> TypeInterfaceTmpl(it, ext).dartInterface()
                    TypeType.Lambda -> ""
                    TypeType.Function -> ""
                    TypeType.Alias -> ""
                    null -> ""
                }

                if (resultDart.isNotBlank()) {
                    val resultFile =
                        "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/${it.name.replace(
                            ".",
                            "/"
                        )}.g.dart"

                    resultFile.file().writeText(resultDart)
                }
            }

        // 处理所有的函数 但是java其实没有顶层函数, 所以这里的结果一定是空字符串
        sdk.directLibs
            .flatMap { it.types }
            .filter { it.isKnownFunction() }
            .run {
                val functionsFile =
                    "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/functions.g.dart"

                functionsFile.file().writeText(TypeFunctionsTmpl(this).dartFunctions())
            }

        val utilTmpl = this::class.java.getResource("/tmpl/dart/type_op.dart.tmpl").readText()
        val targetTypes = sdk.directLibs
            .filterNot { it.isDependency }
            .flatMap { it.types }
            .filterType()
            .asSequence()
            .filterNot { it.isLambda() }
            .filterNot { it.isFunction() }
            .filterNot { it.isAlias() }
            .distinctBy { it.name }
            .filter { !it.isInterface() && !it.isEnum() }
        // 类型检查
        val typeChecks = targetTypes.joinToString("\n") { TypeCheckTmpl(it, me.yohom.fluttify.ext).dartTypeCheck() }
        // 类型造型
        val typeCasts = targetTypes.joinToString("\n") { TypeCastTmpl(it, me.yohom.fluttify.ext).dartTypeCast() }
        utilTmpl
            .replace("#__current_package__#", ext.outputProjectName)
            .replace("#__type_check__#", typeChecks)
            .replace("#__type_cast__#", typeCasts)
            .run { "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/type_op.g.dart".file().writeText(this) }
    }

}

/**
 * 生成Objc文件的Dart接口文件
 */
open class IOSDartInterface : FluttifyTask() {
    @TaskAction
    fun process() {
        val jrFile = "${project.projectDir}/jr/${ext.outputProjectName}.ios.json".file()
        val sdk = jrFile.readText().fromJson<SDK>()

        // 生成前先删除之前的文件
        "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/".file().deleteRecursively()

        // 处理View, 生成UiKitView
        sdk.directLibs
            .flatMap { it.types }
            .filter { it.isView() && !it.isObfuscated() }
            .forEach {
                val dartUiKitView = UiKitViewTmpl(it).dartUiKitView()
                val uiKitViewFile =
                    "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/platformview/${it.name.simpleName()}.g.dart"

                uiKitViewFile.file().writeText(dartUiKitView)
            }

        // 处理普通类
        sdk.directLibs
            .flatMap { it.types }
            .filterType()
            .forEach {
                val resultDart = when (it.typeType) {
                    TypeType.Class, TypeType.Struct -> TypeSdkTmpl(it).dartClass()
                    TypeType.Enum -> TypeEnumTmpl(it).dartEnum()
                    TypeType.Interface -> TypeInterfaceTmpl(it, ext).dartInterface()
                    TypeType.Lambda -> ""
                    TypeType.Function -> "" // 函数要单独处理, 全部放到一个文件里去
                    TypeType.Alias -> ""
                    null -> ""
                }

                if (resultDart.isNotBlank()) {
                    val resultFile =
                        "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/${it.name.replace(
                            ".",
                            "/"
                        )}.g.dart"

                    resultFile.file().writeText(resultDart)
                }
            }

        // 处理所有的函数
        sdk.directLibs
            .flatMap { it.types }
            .filter { it.isKnownFunction() }
            .run {
                val functionsFile =
                    "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/functions.g.dart"

                functionsFile.file().writeText(TypeFunctionsTmpl(this).dartFunctions())
            }

        val utilTmpl = this::class.java.getResource("/tmpl/dart/type_op.dart.tmpl").readText()
        val targetTypes = sdk.directLibs
            .filterNot { it.isDependency }
            .flatMap { it.types }
            .filterType()
            .asSequence()
            .filterNot { it.isLambda() }
            .filterNot { it.isFunction() }
            .filterNot { it.isAlias() }
            .distinctBy { it.name }
            .filter { !it.isInterface() && !it.isEnum() }
        // 类型检查
        val typeChecks = targetTypes.joinToString("\n") { TypeCheckTmpl(it, me.yohom.fluttify.ext).dartTypeCheck() }
        // 类型造型
        val typeCasts = targetTypes.joinToString("\n") { TypeCastTmpl(it, me.yohom.fluttify.ext).dartTypeCast() }
        utilTmpl
            .replace("#__current_package__#", ext.outputProjectName)
            .replace("#__type_check__#", typeChecks)
            .replace("#__type_cast__#", typeCasts)
            .run { "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/type_op.g.dart".file().writeText(this) }
    }
}