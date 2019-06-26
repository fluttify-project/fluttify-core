package task.common

import common.JAVA_FILE
import common.extensions.file
import task.Task
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

/**
 * 反编译Jar任务
 *
 * 输入: 单个class文件
 * 输出: 反编译后的单个java文件
 * 依赖: [UnzipJarTask]
 */
class DecompileClassTask(private val classFile: File) : Task<File, JAVA_FILE>(classFile) {
    override fun process(): JAVA_FILE {
        val artifactPath = classFile.absolutePath.substringBeforeLast("/")

        val process = Runtime
            .getRuntime()
            // -dgs=1 => decompile generic signatures
            // -din=0 => decompile inner classes
            // -rsy=1 => hide synthetic class members
            // -hdc=1 => hide empty default constructor
            .exec("java -jar /usr/local/custom/java/fernflower.jar -dgs=1 -din=0 -rsy=1 -hdc=0 ${classFile.absolutePath} $artifactPath")

        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)

        classFile.delete()

        return classFile.absolutePath.replace("class", "java").file()
    }
}