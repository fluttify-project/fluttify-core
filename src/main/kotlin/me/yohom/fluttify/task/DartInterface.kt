package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.filterType
import me.yohom.fluttify.extensions.fromJson
import me.yohom.fluttify.extensions.simpleName
import me.yohom.fluttify.model.SDK
import me.yohom.fluttify.model.TypeType
import me.yohom.fluttify.tmpl.dart.enumeration.TypeEnumTmpl
import me.yohom.fluttify.tmpl.dart.type.type_functions.TypeFunctionsTmpl
import me.yohom.fluttify.tmpl.dart.type.type_interface.TypeInterfaceTmpl
import me.yohom.fluttify.tmpl.dart.type.type_ref.type_cast.TypeCastTmpl
import me.yohom.fluttify.tmpl.dart.type.type_ref.type_check.TypeCheckTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.TypeSdkTmpl
import me.yohom.fluttify.tmpl.dart.view.android_view.AndroidViewTmpl
import me.yohom.fluttify.tmpl.dart.view.uikit_view.UiKitViewTmpl
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction

/**
 * 生成Java文件的Dart接口文件
 */
open class AndroidDartInterface : FluttifyTask() {
    @InputFile
    val androidIrFile = "${project.projectDir}/ir/android/json_representation.json".file()

    @TaskAction
    fun process() {
        val sdk = androidIrFile.readText().fromJson<SDK>()

        // 处理View, 生成AndroidView
        sdk.libs
            .flatMap { it.types }
            .filter { it.isView() && !it.isObfuscated() }
            .forEach {
                val dartAndroidView = AndroidViewTmpl(it, ext).dartAndroidView()
                val androidViewFile =
                    "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/platformview/${it.name.simpleName()}.g.dart"

                androidViewFile.file().writeText(dartAndroidView)
            }

        // 处理普通类
        sdk.libs
            .flatMap { it.types }
            .filterType()
            .forEach {
                val resultDart = when (it.typeType) {
                    TypeType.Class, TypeType.Struct -> TypeSdkTmpl(it).dartClass()
                    TypeType.Enum -> TypeEnumTmpl(it).dartEnum()
                    TypeType.Interface -> TypeInterfaceTmpl(it, ext).dartInterface()
                    TypeType.Lambda -> ""
                    TypeType.Function -> ""
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
        sdk.libs
            .flatMap { it.types }
            .filter { it.isKnownFunction() }
            .run {
                val functionsFile =
                    "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/functions.g.dart"

                functionsFile.file().writeText(TypeFunctionsTmpl(this).dartFunctions())
            }

        val utilTmpl = this::class.java.getResource("/tmpl/dart/type_op.dart.tmpl").readText()
        val targetTypes = sdk.libs
            .flatMap { it.types }
            .filterType()
            .asSequence()
            .filterNot { it.isLambda() }
            .filterNot { it.isFunction() }
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
    @InputFile
    val iosIrFile = "${project.projectDir}/ir/ios/json_representation.json".file()

    @TaskAction
    fun process() {
        val sdk = iosIrFile.readText().fromJson<SDK>()

        // 处理View, 生成UiKitView
        sdk.libs
            .flatMap { it.types }
            .filter { it.isView() && !it.isObfuscated() }
            .forEach {
                val dartUiKitView = UiKitViewTmpl(it, ext).dartUiKitView()
                val uiKitViewFile =
                    "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/platformview/${it.name.simpleName()}.g.dart"

                uiKitViewFile.file().writeText(dartUiKitView)
            }

        // 处理普通类
        sdk.libs
            .flatMap { it.types }
            .filterType()
            .forEach {
                val resultDart = when (it.typeType) {
                    TypeType.Class, TypeType.Struct -> TypeSdkTmpl(it).dartClass()
                    TypeType.Enum -> TypeEnumTmpl(it).dartEnum()
                    TypeType.Interface -> TypeInterfaceTmpl(it, ext).dartInterface()
                    TypeType.Lambda -> ""
                    TypeType.Function -> "" // 函数要单独处理, 全部放到一个文件里去
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
        sdk.libs
            .flatMap { it.types }
            .filter { it.isKnownFunction() }
            .run {
                val functionsFile =
                    "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/functions.g.dart"

                functionsFile.file().writeText(TypeFunctionsTmpl(this).dartFunctions())
            }

        val utilTmpl = this::class.java.getResource("/tmpl/dart/type_op.dart.tmpl").readText()
        val targetTypes = sdk.libs
            .flatMap { it.types }
            .filterType()
            .asSequence()
            .filterNot { it.isLambda() }
            .filterNot { it.isFunction() }
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