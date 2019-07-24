package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.file
import org.gradle.api.DefaultTask
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
open class UnzipJar : DefaultTask() {

    override fun getGroup() = "fluttify"

    @TaskAction
    fun unzip() {
        val extension = project.extensions.getByType(FluttifyExtension::class.java)
        val jarPath = extension.jarFile.file().absolutePath
        val jarName = extension.jarFile.file().nameWithoutExtension

        val unzippedJar: File = "${project.buildDir}/decompiled/$jarName/".file()

        val process = Runtime.getRuntime().exec("unzip -o $jarPath -d $unzippedJar")
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
    }
}