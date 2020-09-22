package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.downloadFrom
import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.fromJson
import me.yohom.fluttify.model.Podspec
import org.apache.commons.io.FileUtils
import org.apache.commons.io.filefilter.FalseFileFilter
import org.apache.commons.io.filefilter.TrueFileFilter
import org.gradle.api.tasks.TaskAction
import org.zeroturnaround.zip.ZipUtil
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.net.URI

open class DownloadAndroidSDK : FluttifyTask() {
    @TaskAction
    fun process() {
        if (ext.android.remote.androidConfigured) {
            project.repositories.run {
                maven { it.url = URI("http://maven.aliyun.com/nexus/content/groups/public/") }
                maven { it.url = URI("https://oss.sonatype.org/content/groups/public") }
                maven { it.url = URI("https://dl.bintray.com/aweme-open-sdk-team/public") }
                maven { it.url = URI("http://developer.huawei.com/repo") }
                jcenter()
                google()
                mavenCentral()
            }
            val config = project.configurations.create("targetJar")
            val deps = ext.android.remote.androidCoordinate.map { project.dependencies.create(it) }
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
        val process = Runtime
            .getRuntime()
            .exec(
                arrayOf(
                    "/bin/sh",
                    "-c",
                    "cd ${project.projectDir}/output-project/${ext.projectName}/example; flutter packages get --verbose; cd ios; pod install --verbose; cd ${project.projectDir}"
                )
            )
        val br = BufferedReader(InputStreamReader(process.inputStream))
        val errorBr = BufferedReader(InputStreamReader(process.errorStream))
        br.lines().forEach(::println)
        errorBr.lines().forEach(::println)

        if (process.exitValue() == 0) {
            "output-project/${ext.projectName}/example/ios/Pods/"
                .file()
                .listFiles { _, name -> name in ext.ios.remote.name }
                ?.forEach {
                    FileUtils.copyDirectoryToDirectory("${it}/".file(), ext.ios.libDir.file())
                }
        }
    }

    //    /**
//     * 下载iOS端的依赖
//     */
//    private fun downloadIOSDependency(archiveName: String, archiveVersion: String) {
//        val iosArchiveSpec: File?
//        val specDir = "${System.getProperty("user.home")}/.cocoapods/repos/master/Specs/".file()
//
//        // 找出目标pod所在的文件
//        // cocoapods的Specs文件夹分为三层0x0-0xf的文件夹, 最后一层文件夹下的分别存放着所有的pod, 找到目标pod后再根据版本号找到目标podspec.json
//        // 解析出下载地址后进行下载
//        iosArchiveSpec = specDir.listFiles()
//            ?.flatMap<File, File> { it.listFiles()?.toList() ?: listOf() }
//            ?.flatMap<File, File> { it.listFiles()?.toList() ?: listOf() }
//            ?.flatMap<File, File> { it.listFiles()?.toList() ?: listOf() }
//            ?.firstOrNull { it.nameWithoutExtension == archiveName }
//
//        // 找出目标版本所在文件夹
//        val targetVersion: File? = iosArchiveSpec?.listFiles()?.firstOrNull { it.name.contains(archiveVersion) }
//        println("targetVersion: $targetVersion")
//
//        // 从podspec.json文件中读取下载地址, 并下载
//        targetVersion?.apply {
//            val podspec = File("$this/$archiveName.podspec.json").readText().fromJson<Podspec>()
//            if (podspec.source?.http != null) {
//                podspec.source.http.run {
//                    val archiveFile = "${ext.ios.libDir}/ARCHIVE.zip".file()
//
//                    archiveFile.downloadFrom(this)
//                    // 下载完成后解压
//                    ZipUtil.unpack(archiveFile, archiveFile.parentFile)
//                    // 如果包含vendored_frameworks, 那么需要再拿出framework
//                    // 碰到一种情况, 下载下来带有demo和乱七八糟的东西, 需要再把framework找出来
//                    val vendoredFrameworkPath = podspec.ios?.vendoredFrameworks ?: podspec.vendoredFrameworks
//                    // 可能是String也可能是List<String>
//                    if (vendoredFrameworkPath is String) {
//                        moveFramework(vendoredFrameworkPath)
//                    } else if (vendoredFrameworkPath is List<*>) {
//                        vendoredFrameworkPath.forEach { moveFramework(it as String) }
//                    }
//                    // 删除压缩文件
//                    archiveFile.delete()
//                }
//            } else if (podspec.source?.git != null) {
//                println("git clone -b ${podspec.source.tag} ${podspec.source.git} sdk/ios")
//                val process = Runtime
//                    .getRuntime()
//                    .exec("git clone -b ${podspec.source.tag} ${podspec.source.git} sdk/ios")
//                val br = BufferedReader(InputStreamReader(process.inputStream))
//                val errorBr = BufferedReader(InputStreamReader(process.errorStream))
//                br.lines().forEach(::println)
//                errorBr.lines().forEach(::println)
//
//                // 如果包含vendored_frameworks, 那么需要再拿出framework
//                // 碰到一种情况, 下载下来带有demo和乱七八糟的东西, 需要再把framework找出来
//                val vendoredFrameworkPath = podspec.ios?.vendoredFrameworks ?: podspec.vendoredFrameworks
//                // 可能是String也可能是List<String>
//                if (vendoredFrameworkPath is String) {
//                    moveFramework(vendoredFrameworkPath)
//                } else if (vendoredFrameworkPath is List<*>) {
//                    vendoredFrameworkPath.forEach { moveFramework(it as String) }
//                }
//            }
//        }
//    }
//
    private fun moveFramework(vendoredFrameworkPath: String) {
        val trueFramework = if (vendoredFrameworkPath.contains("**/")) {
            // 如果含有通配符, 那么从通配符开始查找目标framework
            val subPath = vendoredFrameworkPath.substringBefore("**/")
            val frameworkName = vendoredFrameworkPath.substringAfter("**/")
            FileUtils.iterateFilesAndDirs(
                "${ext.ios.libDir}/$subPath".file(),
                FalseFileFilter.INSTANCE,
                TrueFileFilter.INSTANCE
            )
                .asSequence()
                .find { it.name.endsWith(frameworkName) }
                ?.path!!
        } else {
            "${ext.ios.libDir}/$vendoredFrameworkPath"
        }
        // 因为其实每个pod都会有vendored_frameworks字段, 所以这里判断一下顶层是否已经有这个framework, 如果有的
        // 话就不需要拷贝了
        // 拿出framework文件, 然后拷贝到顶层
        if (trueFramework.file().parent != ext.ios.libDir.removeSuffix("/")) {
            FileUtils.copyDirectoryToDirectory(trueFramework.file(), ext.ios.libDir.file())
        }
        ext.ios.libDir.file()
            .listFiles()
            ?.filter { it.extension != "framework" }
            ?.forEach { it.deleteRecursively() }
    }
}