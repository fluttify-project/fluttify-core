package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.common.extensions.fromJson
import me.yohom.fluttify.common.extensions.isObfuscated
import me.yohom.fluttify.common.extensions.simpleName
import me.yohom.fluttify.common.model.SDK
import me.yohom.fluttify.common.tmpl.dart.AndroidViewTmpl
import me.yohom.fluttify.common.tmpl.dart.ClassTmpl
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
            .filter { it.superClass in listOf("android.view.View", "android.view.ViewGroup") }
            .forEach {
                val dartAndroidView = AndroidViewTmpl(it, ext).dartAndroidView()
                val androidViewFile = "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/${it.name.simpleName()}.dart"

                androidViewFile.file().writeText(dartAndroidView)
            }

        // 处理普通类
        sdk.libs
            .flatMap { it.types }
            .filter { !it.name.simpleName().isObfuscated() }
            .forEach {
                val dartClass = ClassTmpl(it, ext).dartClass()
                val classFile = "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/${it.name.replace(".", "/")}.dart"

                classFile.file().writeText(dartClass)
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

    }
}