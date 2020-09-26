package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Lib
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.SDK
import me.yohom.fluttify.model.XCConfig
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.File

open class AndroidJsonRepresentation : FluttifyTask() {
    @InputDirectory
    val decompiledDir = "${project.buildDir}/decompiled/".file()

    private val sdk = SDK()

    @TaskAction
    fun process() {
        val jrFile = "${project.projectDir}/jr/${ext.projectName}.android.json".file()

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
                    lib.sourceFiles.add(javaFile.javaType())
                }
                sdk.libs.add(lib)
            }

        // 把依赖插件的libs都添加到当前插件的jr文件中去, 并标注为依赖
        sdk.libs.addAll(
            dependenciesJrFiles
                .map { it.readText().parseSDK() }
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
        val jrFile = "${project.projectDir}/jr/${ext.projectName}.ios.json".file()

        // 依赖插件的jr文件们, 过滤掉没有对应fluttify工程的插件
        val dependenciesJrFiles = ext.pluginDependencies
            .filterKeys { project.projectDir.parentFile.listFiles()?.map { it.name }?.contains(it) == true }
            .map { "${project.projectDir.parent}/${it.key}/jr/${it.key}.ios.json".file() }

        sdk.platform = Platform.iOS

        // 远程依赖解析
        if (ext.ios.remote.iosConfigured) {
            println("远程依赖解析")
            frameworkDir.listFiles()
                ?.filter { it.isDirectory && !it.name.startsWith(".") }
                ?.forEach {
                    val dir = "${project.projectDir}/output-project/${ext.projectName}/example/ios/Pods/Target Support Files/${it.name}"
                    val xcConfigFile =
                        if (File("${dir}/${it.name}.xcconfig").exists()) {
                            println("找到 ${dir}/${it.name}.xcconfig")
                            File("${dir}/${it.name}.xcconfig")
                        } else if (File("${dir}/${it.name}.release.xcconfig").exists()) {
                            println("找到 ${dir}/${it.name}.release.xcconfig")
                            File("${dir}/${it.name}.release.xcconfig")
                        } else {
                            println("已尝试 ${dir}/${it.name}.xcconfig 和 ${dir}/${it.name}.release.xcconfig")
                            println("未找到xcconfig")
                            return
                        }
                    val xcConfig = XCConfig(xcConfigFile)
                    // 先看有没有配置framework的路径
                    if (xcConfig.FRAMEWORK_SEARCH_PATHS != null) {
                        xcConfig.FRAMEWORK_SEARCH_PATHS
                            ?.file()
                            ?.listFiles()
                            ?.filter { file -> file.extension == "framework" }
                            ?.forEach { file ->
                                val lib = Lib().apply { name = file.nameWithoutExtension }
                                file.iterate("h") { objcFile ->
                                    lib.sourceFiles.add(objcFile.objcType())
                                }
                                sdk.libs.add(lib)
                            }
                    }
                    // 再看有没有配置头文件的路径
                    else if (xcConfig.HEADER_SEARCH_PATHS.isNotEmpty()) {
                        val lib = Lib().apply { name = it.nameWithoutExtension }
                        xcConfig.HEADER_SEARCH_PATHS
                            .flatMap { path -> path.file().listFiles()?.toList() ?: listOf() }
                            .forEach { header ->
                                if (header.extension == "h") lib.sourceFiles.add(header.objcType())
                            }
                        sdk.libs.add(lib)
                    } else {
                        println("未找到搜索路径: $xcConfig")
                    }
                }
        }
        // 本地依赖解析
        else {
            println("本地依赖解析")
            frameworkDir.listFiles()
                ?.run {
                    // 如果下载来解压后发现没有framework文件, 那么就认为是.h+.a的组合, 直接解析
                    if (none { it.extension == "framework" }) {
                        val lib = Lib().apply { name = ext.projectName }
                        frameworkDir.iterate("h") { objcFile ->
                            lib.sourceFiles.add(objcFile.objcType())
                        }
                        sdk.libs.add(lib)
                    }
                    // 如果有framework文件, 那么就遍历framework, 生成Lib
                    else {
                        filter { it.isDirectory }
                            .forEach {
                                val lib = Lib().apply { name = it.nameWithoutExtension }
                                it.iterate("h") { objcFile ->
                                    lib.sourceFiles.add(objcFile.objcType())
                                }
                                sdk.libs.add(lib)
                            }
                    }
                }
        }

        // 把依赖插件的libs都添加到当前插件的jr文件中去, 并标注为依赖
        sdk.libs.addAll(
            dependenciesJrFiles
                .map { it.readText().parseSDK() }
                .flatMap { it.libs }
                .map { it.apply { isDependency = true } }
        )

        jrFile.writeText(sdk.toJson())
    }

}