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
        val jrFile = "${project.projectDir}/jr/${ext.outputProjectName}.android.json".file()

        // 依赖插件的jr文件们, 过滤掉没有对应fluttify工程的插件
        val dependenciesJrFiles = ext.pluginDependencies
            .filterKeys { key -> project.projectDir.parentFile.listFiles()?.map { it.name }?.contains(key) == true }
            .map { "${project.projectDir.parent}/${it.key}/jr/${it.key}.android.json".file() }

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

        // 把依赖插件的libs都添加到当前插件的jr文件中去, 并标注为依赖
        sdk.libs.addAll(
            dependenciesJrFiles
                .map { it.readText().fromJson<SDK>() }
                .flatMap { it.libs }
                .map { it.apply { isDependency = true } }
        )

        jrFile.writeText(sdk.toJson())
    }
}

open class IOSJsonRepresentation : FluttifyTask() {
    @InputDirectory
    val frameworkDir = "${project.projectDir}/sdk/ios/".file()

    private val sdk = SDK()

    @TaskAction
    fun process() {
        val jrFile = "${project.projectDir}/jr/${ext.outputProjectName}.ios.json".file()

        // 依赖插件的jr文件们, 过滤掉没有对应fluttify工程的插件
        val dependenciesJrFiles = ext.pluginDependencies
            .filterKeys { project.projectDir.parentFile.listFiles()?.map { it.name }?.contains(it) == true }
            .map { "${project.projectDir.parent}/${it.key}/jr/${it.key}.ios.json".file() }

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

        // 把依赖插件的libs都添加到当前插件的jr文件中去, 并标注为依赖
        sdk.libs.addAll(
            dependenciesJrFiles
                .map { it.readText().fromJson<SDK>() }
                .flatMap { it.libs }
                .map { it.apply { isDependency = true } }
        )

        jrFile.writeText(sdk.toJson())
    }

}