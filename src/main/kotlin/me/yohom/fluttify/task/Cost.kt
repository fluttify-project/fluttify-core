package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.fromJson
import me.yohom.fluttify.model.SDK
import org.gradle.api.tasks.TaskAction

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

        val methodCount = androidSDK
            .allFilteredMethods
            .union(iosSDK.allFilteredMethods)
            .count()
        val propertyCount = androidSDK
            .allProperties
            .union(iosSDK.allProperties)
            .count()
        val constantCount = androidSDK
            .allConstants
            .union(iosSDK.allConstants)
            .count()

        val cost = String.format("%.1f", (methodCount + propertyCount + constantCount) * ext.unitPrice)
        println("此次编译共生成${methodCount}个方法, ${propertyCount}个属性, ${constantCount}个常量, 共计 $cost 元.")
    }
}