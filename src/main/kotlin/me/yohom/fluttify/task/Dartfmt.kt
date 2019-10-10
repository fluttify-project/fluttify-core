package me.yohom.fluttify.task

import me.yohom.fluttify.extensions.iterate
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

/**
 * 把输入文件进行dartfmt
 *
 * 输入: 未格式化的dart文件
 * 输出: 格式化后的dart文件
 */
open class Dartfmt : FluttifyTask() {
    @OutputFile
    val projectDir: File = project.projectDir

    @TaskAction
    fun process() {
        projectDir.iterate("dart") {
            val process = Runtime
                .getRuntime()
                .exec("dartfmt -w ${it.absolutePath}")

            val br = BufferedReader(InputStreamReader(process.inputStream))
            br.lines().forEach(::println)
        }
    }
}