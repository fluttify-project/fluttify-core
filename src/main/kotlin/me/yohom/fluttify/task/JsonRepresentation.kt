package me.yohom.fluttify.task

import me.yohom.fluttify.common.extensions.*
import me.yohom.fluttify.common.model.Lib
import me.yohom.fluttify.common.model.Platform
import me.yohom.fluttify.common.model.SDK
import org.gradle.api.DefaultTask
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
                    val type = javaFile.javaType()
                    if (!type.name.isObfuscated() && type.isPublic) {
                        lib.types.add(javaFile.javaType())
                    }
                }
                sdk.libs.add(lib)
            }

        jsonFile.writeText(sdk.toJson())
    }
}

open class IOSJsonRepresentation : DefaultTask() {
    private val sdk = SDK()

    override fun getGroup() = "fluttify"

    @TaskAction
    fun process() {
        val jsonFile = "${project.projectDir}/ir/ios/json_representation.json".file()

        sdk.platform = Platform.iOS

        "${project.projectDir}/sdk/ios/".file()
            .listFiles()
            ?.forEach {
                val lib = Lib().apply { name = it.nameWithoutExtension }
                it.iterate("h") { objcFile ->
                    lib.types.addAll(objcFile.objcType())
                }
                sdk.libs.add(lib)
            }
        jsonFile.writeText(sdk.toJson())
    }

}