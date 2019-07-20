package me.yohom.fluttify.task

import me.yohom.fluttify.Jar
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
class UnzipJarTask(private val jarFile: File) : Task<File, File>(jarFile) {
    override fun process(): File {
        val jarPath = jarFile.absolutePath
        val artifactPath = Jar.Decompiled.rootDirPath

        val process = Runtime.getRuntime().exec("unzip -o $jarPath -d $artifactPath")
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
        return File(artifactPath)
    }
}