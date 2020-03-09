package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.fromJson
import me.yohom.fluttify.model.SDK
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler

/**
 * 计算价格
 */
open class Cost : FluttifyTask() {
    @TaskAction
    fun decompile() {
        val androidJrFile = "${project.projectDir}/jr/${ext.projectName}.android.json".file()
        val androidSDK = androidJrFile.readText().fromJson<SDK>()

        val iosJrFile = "${project.projectDir}/jr/${ext.projectName}.ios.json".file()
        val iosSDK = iosJrFile.readText().fromJson<SDK>()

        val cost = androidSDK
            .allFilteredMethods
            .union(iosSDK.allFilteredMethods)
            .count() * ext.unitPrice

        println("此次插件生成耗费 $cost 元.")
    }
}