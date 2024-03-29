package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.iterate
import org.gradle.api.tasks.TaskAction

/**
 * 需要引入的内容为android端的主类和模型类以及ios端的主类和模型类
 */
open class Export : FluttifyTask() {
    @TaskAction
    fun process() {
        val androidDartSrcDir = "${project.projectDir}/output-project/${ext.projectName}/lib/src/android/".file()
        val iosDartSrcDir = "${project.projectDir}/output-project/${ext.projectName}/lib/src/ios/".file()

        val androidExportFile = "${project.projectDir}/output-project/${ext.projectName}/lib/src/android/android.export.g.dart".file()
        val iosExportFile = "${project.projectDir}/output-project/${ext.projectName}/lib/src/ios/ios.export.g.dart".file()

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

        ext.pluginDependencies.forEach { (name, _) ->
            androidResult.appendln("export 'package:$name/$name.dart';")
            iosResult.appendln("export 'package:$name/$name.dart';")
        }

        ext.packageDependencies.forEach { (name, _) ->
            androidResult.appendln("export 'package:$name/$name.dart';")
            iosResult.appendln("export 'package:$name/$name.dart';")
        }

        androidResult.appendln("export '../facade/shared.g.dart';")
        iosResult.appendln("export '../facade/shared.g.dart';")

        androidExportFile.writeText(androidResult.toString())
        iosExportFile.writeText(iosResult.toString())
    }
}