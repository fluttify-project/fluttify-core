package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.file
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

/**
 * 解压缩Jar任务
 */
open class UnzipArchive : FluttifyTask() {

    @OutputDirectory
    var unzippedJarDir: File = "${ext.android.libDir}/unzip/".file()

    @TaskAction
    fun unzip() {
        val archiveFiles: List<File> = ext.android.libDir
            .file()
            .listFiles()
            ?.filter { it.name.run { endsWith("jar") || endsWith("aar") } } ?: listOf()

        if (archiveFiles.isEmpty()) return

        archiveFiles.forEach {
            when (it.extension) {
                "jar" -> {
                    val process = Runtime.getRuntime().exec("unzip -o ${it.absolutePath} -d $unzippedJarDir")
                    val br = BufferedReader(InputStreamReader(process.inputStream))
                    br.lines().forEach(::println)
                }
                "aar" -> {
                    val aarUnzipDirPath = "${ext.android.libDir}/${it.nameWithoutExtension}"
                    // 先把aar解压在当前文件夹
                    val aarProcess = Runtime.getRuntime().exec("unzip -o ${it.absolutePath} -d $aarUnzipDirPath")
                    var br = BufferedReader(InputStreamReader(aarProcess.inputStream))
                    br.lines().forEach(::println)

                    // 然后去解压文件夹内找到classes.jar, 对它进行和普通jar一样的操作
                    val jarProcess =
                        Runtime.getRuntime().exec("unzip -o $aarUnzipDirPath/classes.jar -d $unzippedJarDir")
                    br = BufferedReader(InputStreamReader(jarProcess.inputStream))
                    br.lines().forEach(::println)

                    // 如果在libs文件夹下发现其他jar, 对它进行和普通jar一样的操作
                    "$aarUnzipDirPath/libs/".file()
                        .listFiles()
                        ?.filter { file -> file.extension == "jar" }
                        ?.forEach { jarFile ->
                            val libsJarProcess = Runtime.getRuntime().exec("unzip -o $jarFile -d $unzippedJarDir")
                            br = BufferedReader(InputStreamReader(libsJarProcess.inputStream))
                            br.lines().forEach(::println)
                        }
                    // 结束后删除解压的aar
                    aarUnzipDirPath.file().deleteRecursively()
                }
            }
        }
    }
}