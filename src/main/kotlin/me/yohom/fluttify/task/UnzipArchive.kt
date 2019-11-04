package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.file
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

/**
 * 解压缩Jar任务
 */
open class UnzipArchive : FluttifyTask() {

    @InputFiles
    var archiveFiles: List<File> = ext.archiveDir
        .file()
        .listFiles()
        ?.filter { it.name.run { endsWith("jar") || endsWith("aar") } } ?: listOf()

    @OutputDirectory
    var unzippedJarDir: File = "${ext.archiveDir}unzip/".file()

    @TaskAction
    fun unzip() {
        if (archiveFiles.isEmpty()) return

        archiveFiles.forEach {
            when (it.extension) {
                "jar" -> {
                    val process = Runtime.getRuntime().exec("unzip -o ${it.absolutePath} -d $unzippedJarDir")
                    val br = BufferedReader(InputStreamReader(process.inputStream))
                    br.lines().forEach(::println)
                }
                "aar" -> {
                    val aarUnzipDirPath = "${ext.archiveDir}/${it.nameWithoutExtension}"
                    // 先把aar解压在当前文件夹
                    val aarProcess = Runtime.getRuntime().exec("unzip -o ${it.absolutePath} -d $aarUnzipDirPath")
                    var br = BufferedReader(InputStreamReader(aarProcess.inputStream))
                    br.lines().forEach(::println)

                    // 然后去解压文件夹内找到classes.jar, 对它进行和普通jar一样的操作
                    val jarProcess = Runtime.getRuntime().exec("unzip -o $aarUnzipDirPath/classes.jar -d $unzippedJarDir")
                    br = BufferedReader(InputStreamReader(jarProcess.inputStream))
                    br.lines().forEach(::println)
                }
            }
        }
    }
}