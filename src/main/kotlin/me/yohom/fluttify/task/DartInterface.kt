package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.common.extensions.fromJson
import me.yohom.fluttify.common.model.SDK
import me.yohom.fluttify.common.tmpl.dart.AndroidViewTmpl
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

        sdk.libs
            .flatMap { it.types }
            .filter { it.superClass in listOf("android.view.View", "android.view.ViewGroup") }
            .forEach {
                val dartAndroidView = AndroidViewTmpl(it, ext).dartAndroidView()

                println(dartAndroidView)
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