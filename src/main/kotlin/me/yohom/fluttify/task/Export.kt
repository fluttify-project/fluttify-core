package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.iterate
import org.gradle.api.tasks.TaskAction

/**
 * 需要引入的内容为android端的主类和模型类以及ios端的主类和模型类
 */
open class Export : FluttifyTask() {
//    @OutputFiles
//    val exportFiles = listOf(
//        "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/android.export.dart".file(),
//        "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/ios.export.dart".file()
//    )

    @TaskAction
    fun process() {
        val androidDartSrcDir = "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/".file()
        val iosDartSrcDir = "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/".file()

        val androidExportFile = "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/android/android.export.dart".file()
        val iosExportFile = "${project.projectDir}/output-project/${ext.outputProjectName}/lib/src/ios/ios.export.dart".file()

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