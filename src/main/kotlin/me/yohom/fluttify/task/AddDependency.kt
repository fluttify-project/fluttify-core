package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.extensions.file
import org.apache.commons.io.FileUtils
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * 为生成android工程加入目标jar到libs文件夹
 * todo 避免拷贝unzip文件夹
 */
open class AndroidAddDependency : DefaultTask() {

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        val ext = project.extensions.getByType(FluttifyExtension::class.java)

        FileUtils.copyDirectory(
            ext.jarDir.file(),
            "${project.projectDir}/output-project/${ext.outputProjectName}/android/libs/".file()
        )
    }
}

/**
 * 为生成ios工程加入目标framework到文件夹
 *
 * todo 加入引入资源的选项 在podspec文件中加
 *
 *  # 需要引入的资源文件
 *  s.resource = "MAMapKit.framework/AMap.bundle"
 *
 */
open class IOSAddDependency : DefaultTask() {

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        val ext = project.extensions.getByType(FluttifyExtension::class.java)

        // 添加间接依赖到podspec中
        val podspecFile = "${project.projectDir}/output-project/${ext.outputProjectName}/ios/${ext.outputProjectName}.podspec".file()
        podspecFile.readText()
            .replace("#__frameworks__#", ext.iOSTransitiveFramework.joinToString(",\n\t\t") { "\"$it\"" })
            .replace("#__libraries__#", ext.iOSTransitiveTbd.joinToString(",\n\t\t") { "\"$it\"" })
            .run { podspecFile.writeText(this) }

        // 添加framework到工程中
        FileUtils.copyDirectory(
            ext.frameworkDir.file(),
            "${project.projectDir}/output-project/${ext.outputProjectName}/ios/".file()
        )
    }
}