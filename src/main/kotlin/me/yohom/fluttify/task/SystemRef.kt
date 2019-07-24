package me.yohom.fluttify.task

import me.yohom.fluttify.OutputProject.methodChannel
import me.yohom.fluttify.common.tmpl.Tmpl
import me.yohom.fluttify.common.extensions.file
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * 生成系统类的dart引用
 *
 * 输入: 无
 * 输出: 对应的dart类引用
 */
open class AndroidSystemRef : DefaultTask() {
    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        "${project.projectDir}/output-project/src/android/system_ref.dart"
            .file()
            .writeText(Tmpl.Dart.systemRefBuilder.replace("#__method_chanel__#", methodChannel))
    }
}