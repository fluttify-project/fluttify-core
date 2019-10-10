package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import org.gradle.api.tasks.TaskAction
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 生成初始的输出项目
 */
open class OutputProject : FluttifyTask() {
    @TaskAction
    fun process() {
        val ext = project.extensions.getByType(FluttifyExtension::class.java)
        val outputProjectPath = "${project.projectDir}/output-project/${ext.outputProjectName}"

        val process = Runtime
            .getRuntime()
            .exec("flutter create --no-pub -a ${ext.androidLanguage} -i ${ext.iOSLanguage} --androidx --template plugin --org ${ext.outputOrg} $outputProjectPath")
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
    }
}