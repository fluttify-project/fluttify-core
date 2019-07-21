package me.yohom.fluttify.task

import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.common.extensions.iterate
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.TaskAction
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

/**
 * 反编译Jar任务
 *
 * 输入: 单个class文件
 * 输出: 反编译后的单个java文件
 */
open class DecompileClass : DefaultTask() {

    @InputDirectory
    var classFilesDir: File = "${project.buildDir}/decompiled/".file()

    override fun getGroup() = "fluttify"

    @TaskAction
    fun decompile() {
        classFilesDir.iterate("class") {
            val artifactPath = it.absolutePath.substringBeforeLast("/")

            val process = Runtime
                .getRuntime()
                // -dgs=1 => decompile generic signatures
                // -din=0 => decompile inner CLASSES
                // -rsy=1 => hide synthetic class members
                // -hdc=1 => hide empty default constructor
                .exec("java -jar /usr/local/custom/java/fernflower.jar -dgs=1 -din=0 -rsy=1 -hdc=0 ${it.absolutePath} $artifactPath")

            val br = BufferedReader(InputStreamReader(process.inputStream))
            br.lines().forEach(::println)

            it.delete()
        }
    }
}