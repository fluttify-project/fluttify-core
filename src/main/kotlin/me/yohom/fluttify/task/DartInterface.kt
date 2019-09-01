package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.common.extensions.filterType
import me.yohom.fluttify.common.extensions.fromJson
import me.yohom.fluttify.common.extensions.simpleName
import me.yohom.fluttify.common.model.SDK
import me.yohom.fluttify.common.model.TypeType
import me.yohom.fluttify.common.tmpl.dart.clazz.ref_class.RefClassTmpl
import me.yohom.fluttify.common.tmpl.dart.clazz.sdk_class.SdkClassTmpl
import me.yohom.fluttify.common.tmpl.dart.enumeration.EnumTmpl
import me.yohom.fluttify.common.tmpl.dart.view.AndroidViewTmpl
import me.yohom.fluttify.common.tmpl.dart.view.UiKitViewTmpl
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * 生成Java文件的Dart接口文件
 */
open class AndroidDartInterface : DefaultTask() {
    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        val ext = project.extensions.getByType(FluttifyExtension::class.java)
        val sdk = "${project.projectDir}/ir/android/json_representation.json".file().readText().fromJson<SDK>()

        // 处理View, 生成AndroidView
        sdk.libs
            .flatMap { it.types }
            .filter { it.isView() }
            .forEach {
                val dartAndroidView = AndroidViewTmpl(it, ext).dartAndroidView()
                val androidViewFile =
                    "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/platformview/${it.name.simpleName()}.dart"

                androidViewFile.file().writeText(dartAndroidView)
            }

        // 处理普通类
        sdk.libs
            .flatMap { it.types }
            .filterType()
            .forEach {
                val resultDart = when (it.typeType) {
                    TypeType.Class, TypeType.Struct -> SdkClassTmpl(it, ext).dartClass()
                    TypeType.Enum -> EnumTmpl(it).dartEnum()
                    TypeType.Interface -> ""
                    TypeType.Lambda -> ""
                    null -> ""
                }

                if (resultDart.isNotBlank()) {
                    val resultFile =
                        "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/${it.name.replace(
                            ".",
                            "/"
                        )}.dart"

                    resultFile.file().writeText(resultDart)
                }
            }

        // 在Ref类中为每个类生成类型检查和转型方法
        RefClassTmpl(sdk, ext).dartRefClass().run {
            "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/ref.dart".file()
                .writeText(this)
        }
    }

}

/**
 * 生成Objc文件的Dart接口文件
 */
open class IOSDartInterface : DefaultTask() {
    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        val ext = project.extensions.getByType(FluttifyExtension::class.java)
        val sdk = "${project.projectDir}/ir/ios/json_representation.json".file().readText().fromJson<SDK>()

        // 处理View, 生成UiKitView
        sdk.libs
            .flatMap { it.types }
            .filter { it.isView() }
            .forEach {
                val dartUiKitView = UiKitViewTmpl(it, ext).dartUiKitView()
                val uiKitViewFile =
                    "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/platformview/${it.name.simpleName()}.dart"

                uiKitViewFile.file().writeText(dartUiKitView)
            }

        // 处理普通类
        sdk.libs
            .flatMap { it.types }
            .filterType()
            .forEach {
                val resultDart = when (it.typeType) {
                    TypeType.Class, TypeType.Struct -> SdkClassTmpl(
                        it,
                        ext
                    ).dartClass()
                    TypeType.Enum -> EnumTmpl(it).dartEnum()
                    TypeType.Interface -> ""
                    TypeType.Lambda -> ""
                    null -> ""
                }

                if (resultDart.isNotBlank()) {
                    val resultFile =
                        "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/${it.name.replace(
                            ".",
                            "/"
                        )}.dart"

                    resultFile.file().writeText(resultDart)
                }
            }

        // 在Ref类中为每个类生成类型检查和转型方法
        RefClassTmpl(sdk, ext).dartRefClass().run {
            "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/ref.dart".file()
                .writeText(this)
        }
    }
}