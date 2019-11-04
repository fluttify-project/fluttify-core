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
open class UnzipJar : FluttifyTask() {

    @InputFiles
    var jarFiles: List<File> = ext.jarDir.file().listFiles()?.filter { it.name.endsWith("jar") } ?: listOf()

    @OutputDirectory
    var unzippedJarDir: File = "${ext.jarDir}unzip/".file()

    @TaskAction
    fun unzip() {
        if (jarFiles.isEmpty()) return

        jarFiles.forEach {
            val process = Runtime.getRuntime().exec("unzip -o ${it.absolutePath} -d $unzippedJarDir")
            val br = BufferedReader(InputStreamReader(process.inputStream))
            br.lines().forEach(::println)
        }
    }
}