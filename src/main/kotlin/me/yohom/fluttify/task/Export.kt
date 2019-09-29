package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.iterate
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

        val androidDartSrcDir = "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/".file()
        val iosDartSrcDir = "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/".file()

        val androidExportFile =
            "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/android.export.dart".file()
        val iosExportFile =
            "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/ios.export.dart".file()

        val androidResult = StringBuilder()
        val iosResult = StringBuilder()

        androidDartSrcDir.iterate("dart") {
            val relativePath = it.toRelativeString(androidExportFile).removePrefix("../")
            if (relativePath.isNotBlank()) androidResult.appendln("export '${relativePath}';")
        }
        iosDartSrcDir.iterate("dart") {
            val relativePath = it.toRelativeString(iosExportFile).removePrefix("../")
            if (relativePath.isNotBlank()) iosResult.appendln("export '${relativePath}';")
        }

        androidExportFile.writeText(androidResult.toString())
        iosExportFile.writeText(iosResult.toString())
    }
}