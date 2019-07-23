package me.yohom.fluttify.task

import com.fasterxml.jackson.databind.ObjectMapper
import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.common.extensions.iterate
import me.yohom.fluttify.common.extensions.javaType
import me.yohom.fluttify.common.model.Lib
import me.yohom.fluttify.common.model.Platform
import me.yohom.fluttify.common.model.SDK
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction

open class AndroidJsonRepresentation : DefaultTask() {
    private val sdk = SDK()

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        val jsonFile = "${project.projectDir}/ir/android/json_representation.json".file()

        sdk.platform = Platform.Android

        "${project.buildDir}/decompiled/".file()
            .listFiles()
            ?.forEach {
                val lib = Lib().apply { name = it.nameWithoutExtension }
                it.iterate("java") { javaFile ->
                    lib.types.add(javaFile.javaType())
                }
                sdk.libs.add(lib)
            }
        ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(jsonFile, sdk)
    }
}

open class IOSJsonRepresentation : DefaultTask() {
    private val sdk = SDK()

    @InputDirectory
    var sdkSourceDir = "${project.projectDir}/sdk/ios/".file()

    @OutputFile
    var jsonFile = "${project.projectDir}/ir/ios/json_representation.json".file()

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
//        val sdkDir = project.extensions.getByType(FluttifyExtension::class.java).jarFile.file()
//        // 获取sdk的名称 目前假设sdk中只存在一个jar
//        sdk.name = sdkDir.list()?.firstOrNull { it.endsWith(".jar") } ?: throw IllegalArgumentException("没有jar")
//        sdk.platform = Platform.Android
//        sdkSourceDir.iterate("java") {
//            sdk.types.add(it.javaType())
//        }
//
//        ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(jsonFile, sdk)
    }

}