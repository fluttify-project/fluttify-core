package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.extensions.file
import org.gradle.api.tasks.TaskAction
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

/**
 * 解压缩Jar任务
 *
 * 输入: 反编译后的Jar文件
 * 输出: class文件列表
 * 依赖: []
 */
open class UnzipJar : FluttifyTask() {
    @TaskAction
    fun unzip() {
        val ext = project.extensions.getByType(FluttifyExtension::class.java)
        val jarPath = ext.jarDir.file().listFiles()?.first { it.name.endsWith("jar") }?.absolutePath

        val unzippedJar: File = "${ext.jarDir}unzip/".file()

        val process = Runtime.getRuntime().exec("unzip -o $jarPath -d $unzippedJar")
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
    }
}