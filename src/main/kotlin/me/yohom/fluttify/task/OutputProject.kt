package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.PATH
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 生成初始的输出项目
 *
 * 输入: 生成项目的规格
 * 输出: 项目路径[PATH]
 */
open class OutputProject : DefaultTask() {

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        val ext = project.extensions.getByType(FluttifyExtension::class.java)
        val outputProjectPath = "${project.projectDir}/output-project/${ext.outputProjectName}"

        val process = Runtime
            .getRuntime()
            .exec("flutter create --offline -a kotlin -i swift --template plugin --org ${ext.outputOrg} $outputProjectPath")
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
    }
}