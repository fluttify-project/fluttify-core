package me.yohom.fluttify.task

import com.fasterxml.jackson.databind.ObjectMapper
import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.common.extensions.iterate
import me.yohom.fluttify.common.extensions.javaType
import me.yohom.fluttify.common.model.Platform
import me.yohom.fluttify.common.model.SDK
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

open class AndroidJsonRepresentation : DefaultTask() {
    private val sdk = SDK()

    @InputDirectory
    var sdkDir = "${project.projectDir}/sdk/android/".file()

    @InputDirectory
    var sdkSourceDir = "${project.buildDir}/decompiled/".file()

    @OutputFile
    var jsonFile = "${project.projectDir}/ir/android/json_representation.json".file()

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        // 获取sdk的名称 目前假设sdk中只存在一个jar
        sdk.name = sdkDir.list()?.firstOrNull { it.endsWith(".jar") } ?: throw IllegalArgumentException("没有jar")
        sdk.platform = Platform.Android
        sdkSourceDir.iterate("java") {
            sdk.types.add(it.javaType())
        }

        ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(jsonFile, sdk)
    }

}