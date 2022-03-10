package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Lib
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.SDK
import me.yohom.fluttify.model.XCConfig
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

private val tmpl by lazy { getResource("/tmpl/project/Doxyfile.tmpl").readText() }

open class AndroidXmlRepresentation : FluttifyTask() {
    @TaskAction
    fun process() {
        val doxyfile = "${project.projectDir}/Doxyfile".file()
        val outputDir = "${project.projectDir}/ir/android/".file()

        val replaced = tmpl
            .replace("#__INPUT_PLACEHOLDER__#", "${project.buildDir}/decompiled")
            .replace("#__OUTPUT_DIRECTORY_PLACEHOLDER__#", outputDir.path)
        doxyfile.writeText(replaced)

        val process = Runtime.getRuntime().exec("doxygen")
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
    }
}

open class IOSXmlRepresentation : FluttifyTask() {
    @TaskAction
    fun process() {
        val doxyfile = "${project.projectDir}/Doxyfile".file()
        val outputDir = "${project.projectDir}/ir/ios/".file()

        val replaced = tmpl
            .replace("#__INPUT_PLACEHOLDER__#", "${project.projectDir}/sdk/ios")
            .replace("#__OUTPUT_DIRECTORY_PLACEHOLDER__#", outputDir.path)
        doxyfile.writeText(replaced)

        val process = Runtime.getRuntime().exec("doxygen")
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
    }

}