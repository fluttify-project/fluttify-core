package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.downloadFrom
import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.fromJson
import me.yohom.fluttify.extensions.isIOSArchive
import org.apache.commons.io.FileUtils
import org.gradle.api.tasks.TaskAction
import org.zeroturnaround.zip.ZipUtil
import java.io.File
import java.net.URI

open class DownloadAndroidSDK : FluttifyTask() {
    @TaskAction
    fun process() {
        if (ext.android.remote.run { "$org$name$version" }.isNotEmpty()) {
            project.repositories.run {
                maven { it.url = URI("http://maven.aliyun.com/nexus/content/groups/public/") }
                maven { it.url = URI("https://oss.sonatype.org/content/groups/public") }
                maven { it.url = URI("https://dl.bintray.com/aweme-open-sdk-team/public") }
                jcenter()
                mavenCentral()
            }
            val config = project.configurations.create("targetJar")
            val dep = project.dependencies.create(ext.android.remote.run { "$org:$name:$version" })
            config.dependencies.add(dep)
            if (config.files.isNotEmpty()) {
                config.files.first().run {
                    FileUtils.copyFile(this, "${ext.android.libDir}/${name}".file())
                }
            }
        }
    }
}

open class DownloadIOSSDK : FluttifyTask() {
    @TaskAction
    fun process() {
        ext.ios.libDir.file().run {
            if (list()?.isEmpty() == true && ext.ios.remote.run { "$name$version" }.isNotEmpty()) {
                val iosArchiveSpec: File?

                val specDir = "${System.getProperty("user.home")}/.cocoapods/repos/master/Specs/".file()
                val archiveName = ext.ios.remote.name
                val archiveVersion = ext.ios.remote.version                // 找出目标pod所在的文件
                // cocoapods的Specs文件夹分为三层0x0-0xf的文件夹, 最后一层文件夹下的分别存放着所有的pod, 找到目标pod后再根据版本号找到目标podspec.json
                // 解析出下载地址后进行下载
                iosArchiveSpec = specDir.listFiles()
                    ?.flatMap<File, File> { it.listFiles()?.toList() ?: listOf() }
                    ?.flatMap<File, File> { it.listFiles()?.toList() ?: listOf() }
                    ?.flatMap<File, File> { it.listFiles()?.toList() ?: listOf() }
                    ?.firstOrNull { it.nameWithoutExtension == archiveName }

                // 找出目标版本所在文件夹
                val targetVersion: File? = iosArchiveSpec?.listFiles()?.firstOrNull { it.name.contains(archiveVersion) }
                println("targetVersion: $targetVersion")

                // 从podspec.json文件中读取下载地址, 并下载
                targetVersion?.run {
                    val podspecJson = File("$this/$archiveName.podspec.json").readText().fromJson<Map<String, Any>>()
                    val source: Map<String, String> = podspecJson["source"] as Map<String, String>
                    source["http"]?.run {
                        val archiveFile = "${ext.ios.libDir}/ARCHIVE.zip".file()

                        archiveFile.downloadFrom(this)
                        // 下载完成后解压
                        ZipUtil.unpack(archiveFile, archiveFile.parentFile)
                        // 删除压缩文件
                        archiveFile.delete()
                    }
                }
            }
        }
    }
}