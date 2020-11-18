package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.file
import org.apache.commons.io.FileUtils
import org.gradle.api.tasks.TaskAction
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URI

open class DownloadAndroidSDK : FluttifyTask() {
    @TaskAction
    fun process() {
        if (ext.android.remote.configured) {
            project.repositories.run {
                maven { it.url = URI("https://maven.aliyun.com/nexus/content/groups/public/") }
                maven { it.url = URI("https://oss.sonatype.org/content/groups/public") }
                maven { it.url = URI("https://dl.bintray.com/aweme-open-sdk-team/public") }
                maven { it.url = URI("http://developer.huawei.com/repo") }
                maven { it.url = URI("http://repo.baichuan-android.taobao.com/content/groups/BaichuanRepositories/") }
                jcenter()
                google()
                mavenCentral()
            }
            val config = project.configurations.create("implementation")
            val deps = ext.android.remote.dependencies.map { project.dependencies.create(it) }
            config.dependencies.addAll(deps)
            if (config.files.isNotEmpty()) {
                config.files.forEach {
                    FileUtils.copyFile(it, "${ext.android.libDir}/${it.name}".file())
                }
            }
        }
    }
}

open class DownloadIOSSDK : FluttifyTask() {
    @TaskAction
    fun process() {
        if (ext.ios.remote.configured) {
            val process = Runtime
                .getRuntime()
                .exec(
                    arrayOf(
                        "/bin/sh",
                        "-c",
                        "cd ${project.projectDir}/output-project/${ext.projectName} && flutter packages get && cd example/ios && pod install --verbose"
                    )
                )
            val br = BufferedReader(InputStreamReader(process.inputStream))
            val errorBr = BufferedReader(InputStreamReader(process.errorStream))
            br.lines().forEach(::println)
            errorBr.lines().forEach(::println)

            if (process.exitValue() == 0) {
                // 清除原先的内容
                ext.ios.libDir.file().listFiles()?.forEach { it.deleteRecursively() }
                "output-project/${ext.projectName}/example/ios/Pods/"
                    .file()
                    .listFiles { _, name -> ext.ios.remote.dependencies.any { it.contains(name) } }
                    ?.forEach {
                        FileUtils.copyDirectoryToDirectory("${it}/".file(), ext.ios.libDir.file())
                    }
            }
        }
    }
}