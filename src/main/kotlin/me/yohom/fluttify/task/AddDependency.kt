package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.file
import org.apache.commons.io.FileUtils
import org.gradle.api.tasks.TaskAction
import java.io.File

/**
 * 为生成android工程加入目标jar/aar到libs文件夹
 */
open class AndroidAddDependency : FluttifyTask() {
    @TaskAction
    fun process() {
        val archiveDir: File = ext.archiveDir.file()
        val libDir: File = "${project.projectDir}/output-project/${ext.outputProjectName}/android/libs/".file()

        FileUtils.copyDirectory(archiveDir, libDir) { it.extension in listOf("jar", "aar") && it.length() > 0 }
    }
}

/**
 * 为生成ios工程加入目标framework到文件夹
 */
open class IOSAddDependency : FluttifyTask() {
    @TaskAction
    fun process() {
        val frameworkDir: File = ext.frameworkDir.file()
        val targetDir: File = "${project.projectDir}/output-project/${ext.outputProjectName}/ios/".file()

        // 添加间接依赖到podspec中
        val podspecFile =
            "${project.projectDir}/output-project/${ext.outputProjectName}/ios/${ext.outputProjectName}.podspec".file()
        podspecFile.readText()
            .replace("#__frameworks__#", ext.iOSTransitiveFramework.joinToString { "\"$it\"" })
            .replace("#__libraries__#", ext.iOSTransitiveTbd.joinToString { "\"$it\"" })
            .replace("#__resources__#", ext.iOSResource.joinToString { "\"$it\"" })
            .run { podspecFile.writeText(this) }

        // 添加framework到工程中
        FileUtils.copyDirectory(frameworkDir, targetDir)
    }
}