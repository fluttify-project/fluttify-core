package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.file
import org.apache.commons.io.FileUtils
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File

/**
 * 为生成android工程加入目标jar到libs文件夹
 * todo 避免拷贝unzip文件夹 已完成 待测试
 */
open class AndroidAddDependency : FluttifyTask() {
    @InputFile
    val jarDir: File = ext.jarDir.file()

    @OutputDirectory
    val libDir: File = "${project.projectDir}/output-project/${ext.outputProjectName}/android/libs/".file()

    @TaskAction
    fun process() {
        FileUtils.copyDirectory(jarDir, libDir) { it.name != "unzip" }
    }
}

/**
 * 为生成ios工程加入目标framework到文件夹
 */
open class IOSAddDependency : FluttifyTask() {
    @InputFile
    val frameworkFile : File = ext.frameworkDir.file()

    @OutputDirectory
    val targetDir: File = "${project.projectDir}/output-project/${ext.outputProjectName}/ios/".file()

    @TaskAction
    fun process() {
        // 添加间接依赖到podspec中
        val podspecFile = "${project.projectDir}/output-project/${ext.outputProjectName}/ios/${ext.outputProjectName}.podspec".file()
        podspecFile.readText()
            .replace("#__frameworks__#", ext.iOSTransitiveFramework.joinToString { "\"$it\"" })
            .replace("#__libraries__#", ext.iOSTransitiveTbd.joinToString { "\"$it\"" })
            .replace("#__resources__#", ext.iOSResource.joinToString { "\"$it\"" })
            .run { podspecFile.writeText(this) }

        // 添加framework到工程中
        FileUtils.copyDirectory(frameworkFile, targetDir)
    }
}