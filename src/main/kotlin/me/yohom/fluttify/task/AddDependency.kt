package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.file
import org.apache.commons.io.FileUtils
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * 为生成android工程加入目标jar到libs文件夹
 */
open class AndroidAddDependency : DefaultTask() {

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        val ext = project.extensions.getByType(FluttifyExtension::class.java)

        FileUtils.copyDirectory(
            "${ext.jarFile.file().parent}/".file(),
            "${project.projectDir}/output-project/${ext.outputProjectName}/android/libs/".file()
        )
    }
}

/**
 * 为生成ios工程加入目标framework到文件夹
 */
open class IOSAddDependency : DefaultTask() {

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        val ext = project.extensions.getByType(FluttifyExtension::class.java)

        FileUtils.copyDirectory(
            ext.frameworkDir.file(),
            "${project.projectDir}/output-project/${ext.outputProjectName}/ios/".file()
        )
    }
}