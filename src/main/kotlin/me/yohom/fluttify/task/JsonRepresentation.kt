package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Lib
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.SDK
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.TaskAction

open class AndroidJsonRepresentation : FluttifyTask() {
    @InputDirectory
    val decompiledDir = "${project.buildDir}/decompiled/".file()

    private val sdk = SDK()

    @TaskAction
    fun process() {
        val jrFile = "${project.projectDir}/jr/android/${ext.outputProjectName}.android.json".file()

        sdk.platform = Platform.Android

        decompiledDir
            .listFiles()
            ?.filter { it.isDirectory }
            ?.forEach {
                val lib = Lib().apply { name = it.nameWithoutExtension }
                it.iterate("java") { javaFile ->
                    lib.types.add(javaFile.javaType())
                }
                sdk.libs.add(lib)
            }

        jrFile.writeText(sdk.toJson())
    }
}

open class IOSJsonRepresentation : FluttifyTask() {
    @InputDirectory
    val frameworkDir = "${project.projectDir}/sdk/ios/".file()

    private val sdk = SDK()

    @TaskAction
    fun process() {
        val jrFile = "${project.projectDir}/jr/ios/${ext.outputProjectName}.ios.json".file()

        sdk.platform = Platform.iOS

        frameworkDir
            .listFiles()
            ?.filter { it.isDirectory }
            ?.forEach {
                val lib = Lib().apply { name = it.nameWithoutExtension }
                it.iterate("h") { objcFile ->
                    lib.types.addAll(objcFile.objcType())
                }
                sdk.libs.add(lib)
            }
        jrFile.writeText(sdk.toJson())
    }

}