package me.yohom.fluttify.task

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.file
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * 反编译Jar任务
 *
 * 输入: 单个class文件
 * 输出: 反编译后的单个java文件
 */
open class DecompileClass : DefaultTask() {

    override fun getGroup() = "fluttify"

    @TaskAction
    fun decompile() {
        val ext = project.extensions.getByType(FluttifyExtension::class.java)

        val classFilesDir = "${ext.jarFile.file().parent}/unzip/".file()
        val javaFilesDir = "${project.buildDir}/decompiled/".file()

        // 开始反编译
        val process = Runtime
            .getRuntime()
            // -dgs=1 => decompile generic signatures
            // -din=0 => decompile inner CLASSES
            // -rsy=1 => hide synthetic class members
            // -hdc=1 => hide empty default constructor
            .exec("java -jar /usr/local/custom/java/fernflower.jar -dgs=1 -din=0 -rsy=1 -hdc=0 $classFilesDir $javaFilesDir")

        BufferedReader(InputStreamReader(process.inputStream)).lines().forEach(::println)
    }
}