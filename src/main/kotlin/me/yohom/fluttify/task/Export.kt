package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.file
import org.apache.commons.io.FileUtils
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * 需要引入的内容为android端的主类和模型类以及ios端的主类和模型类
 * todo 不应该把内部的android/ios文件export出去, 需要单独搞一个文件供内部import
 *
 * 输入: 目标工程文件夹
 * 输出: 加入export后的目标工程文件夹
 */
open class Export : DefaultTask() {
    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        val ext = project.extensions.getByType(FluttifyExtension::class.java)

        val dartSrcDir = "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/".file()
        val exportFile =
            "${project.projectDir}/output-project/${ext.outputProjectName}/lib/${ext.outputProjectName}.dart".file()

        val result = StringBuilder()
        FileUtils
            .iterateFiles(dartSrcDir, arrayOf("dart"), true)
            .forEach {
                result.append("export '${it.toRelativeString(exportFile).removePrefix("../")}';\n")
            }
        result.append("\n")

        exportFile.writeText(result.toString())
    }
}