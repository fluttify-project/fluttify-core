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

        val process = Runtime
            .getRuntime()
            .exec("flutter create --no-pub -a java -i objc --verbose --platforms=android,ios --template=plugin --org ${ext.org} $outputProjectPath")
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
    }
}