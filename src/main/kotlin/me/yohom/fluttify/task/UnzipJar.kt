package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.file
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

/**
 * 解压缩Jar任务
 */
open class UnzipJar : FluttifyTask() {

    @InputFile
    var jarFile: File? = ext.jarDir.file().listFiles()?.firstOrNull { it.name.endsWith("jar") }

    @OutputDirectory
    var unzippedJar: File = "${ext.jarDir}unzip/".file()

    @TaskAction
    fun unzip() {
        if (jarFile == null) return

        val process = Runtime.getRuntime().exec("unzip -o ${jarFile?.absolutePath} -d $unzippedJar")
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
    }
}