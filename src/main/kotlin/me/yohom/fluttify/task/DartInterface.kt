package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.common.extensions.filterType
import me.yohom.fluttify.common.extensions.fromJson
import me.yohom.fluttify.common.extensions.simpleName
import me.yohom.fluttify.common.model.SDK
import me.yohom.fluttify.common.model.TypeType
import me.yohom.fluttify.common.tmpl.dart.clazz.ClassTmpl
import me.yohom.fluttify.common.tmpl.dart.enumeration.EnumTmpl
import me.yohom.fluttify.common.tmpl.dart.view.AndroidViewTmpl
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * 生成Java文件的Dart接口文件
 *
 * 输入: Java文件
 * 输出: 生成接口后的Dart文件
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
                    "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/${it.name.simpleName()}.dart"

                androidViewFile.file().writeText(dartAndroidView)
            }

        // 处理普通类
        sdk.libs
            .flatMap { it.types }
            .filterType()
            .forEach {
                val resultDart = when (it.typeType) {
                    TypeType.Class -> ClassTmpl(it, ext).dartClass()
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
    }

}

/**
 * 生成Objc文件的Dart接口文件
 *
 * 输入: objc文件
 * 输出: 生成接口后的Dart文件
 */
open class IOSDartInterface : DefaultTask() {
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
                    "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/${it.name.simpleName()}.dart"

                androidViewFile.file().writeText(dartAndroidView)
            }

        // 处理普通类
        sdk.libs
            .flatMap { it.types }
            .filterType()
            .forEach {
                val resultDart = when (it.typeType) {
                    TypeType.Class -> ClassTmpl(it, ext).dartClass()
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
    }
}