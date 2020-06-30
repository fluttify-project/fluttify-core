package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import org.gradle.api.tasks.TaskAction
import org.gradle.jvm.tasks.Jar
import java.io.File

/**
 * 打包Jar任务
 */
open class PackagingJar : Jar() {
    val ext: FluttifyExtension
        get() = project.extensions.getByType(FluttifyExtension::class.java)

    override fun getGroup() = "fluttify"

    @TaskAction
    fun jar() {
        val projectDir = project.projectDir
        val projectName = ext.projectName
        val packageSubDir = ext.org.replace(".", "/")

        val packageDir = "$projectDir/output-project/$projectName/android/src/main/java/$packageSubDir/$projectName"
        include("$packageDir/sub_handler/**")
////        archiveFileName.set("test.jar")
////        destinationDirectory.set(File(packageDir))
//        val config = project.configurations.create("fatJar")
//        from(packageDir) {
//            config. .collect { it.isDirectory() ? it : zipTree(it) }
//        }
    }
}

/**
 * 打包framework任务
 */
open class PackagingFramework : FluttifyTask() {

    @TaskAction
    fun framework() {
    }
}