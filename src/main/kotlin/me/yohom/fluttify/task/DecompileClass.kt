package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.file
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import org.jetbrains.java.decompiler.main.decompiler.ConsoleDecompiler

/**
 * 反编译Jar任务
 *
 * 输入: 单个class文件
 * 输出: 反编译后的单个java文件
 */
open class DecompileClass : FluttifyTask() {
    @InputDirectory
    val classFilesDir = "${ext.jarDir}unzip/".file()

    @OutputDirectory
    val javaFilesDir = "${project.buildDir}/decompiled/".file()

    @TaskAction
    fun decompile() {
        // 生成前先删除之前的文件
        javaFilesDir.listFiles()?.forEach { it.deleteRecursively() }

        ConsoleDecompiler.main(arrayOf(
            "-dgs=1", "-din=0", "-rsy=1", "-hdc=0",
            classFilesDir.toString(),
            javaFilesDir.toString())
        )
    }
}