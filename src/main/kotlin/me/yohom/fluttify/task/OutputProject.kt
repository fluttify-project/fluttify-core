package me.yohom.fluttify.task

import org.gradle.api.tasks.TaskAction
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 生成初始的输出项目
 */
open class OutputProject : FluttifyTask() {
    @TaskAction
    fun process() {
        val outputProjectPath = "${project.projectDir}/output-project/${ext.projectName}"

        val cmdBuilder = StringBuilder("flutter create")
        cmdBuilder.append("--no-pub")
        cmdBuilder.append("-a java -i objc")
        cmdBuilder.append("--verbose")
        cmdBuilder.append("--platforms=${ext.availablePlatform.joinToString(",")}")
        cmdBuilder.append("--template=plugin")
        cmdBuilder.append("--org ${ext.org}")
        cmdBuilder.append(outputProjectPath)

        val process = Runtime.getRuntime().exec(cmdBuilder.toString())
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
    }
}