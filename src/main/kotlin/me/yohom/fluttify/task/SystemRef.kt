package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.OutputProject.methodChannel
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
    private val tmpl = this::class.java.getResource("/tmpl/dart/system_ref.dart.tmpl").readText()

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        val ext = project.extensions.getByType(FluttifyExtension::class.java)
        "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/system_ref.dart"
            .file()
            .writeText(tmpl.replace("#__method_chanel__#", methodChannel))
    }
}