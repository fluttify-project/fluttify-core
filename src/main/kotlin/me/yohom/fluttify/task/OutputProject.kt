package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.FluttifyProject
import me.yohom.fluttify.common.PATH
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 生成初始的输出项目
 *
 * 输入: 生成项目的规格[FluttifyProject]
 * 输出: 项目路径[PATH]
 */
open class OutputProject : DefaultTask() {

    private val ext = project.extensions.getByType(FluttifyExtension::class.java)

    @Input
    var outputProjectPath = "${project.projectDir}/output-project/${ext.outputProjectName}"

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        val process = Runtime
            .getRuntime()
            .exec("flutter create --offline -a kotlin -i swift --template plugin --org ${ext.outputOrg} $outputProjectPath")
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
    }
}