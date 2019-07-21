package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.file
import org.apache.commons.io.FileUtils
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * 为生成android工程加入目标jar到libs文件夹
 *
 * 输入: 没有加入jar的生成工程
 * 输出: 加入了jar的生成工程
 */
open class AddAndroidDependency : DefaultTask() {

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        val extension = project.extensions.getByType(FluttifyExtension::class.java)

        FileUtils.copyDirectory(
            "${extension.jarFile.file().parent}/".file(),
            "${project.projectDir}/output-project/${extension.outputProjectName}/android/libs/".file()
        )
    }
}