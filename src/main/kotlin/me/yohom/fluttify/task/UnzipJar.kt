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
    var jarFile: File? = null

    @OutputDirectory
    var unzippedJar: File? = null

    @TaskAction
    fun unzip() {
        jarFile = ext.jarDir.file().listFiles()?.first { it.name.endsWith("jar") }
        unzippedJar = "${ext.jarDir}unzip/".file()

        if (jarFile == null || unzippedJar == null) return

        val process = Runtime.getRuntime().exec("unzip -o ${jarFile?.absolutePath} -d $unzippedJar")
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
    }
}