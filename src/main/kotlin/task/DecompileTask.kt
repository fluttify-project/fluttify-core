package task

import Configs
import preprocess.Project
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

/**
 * 反编译Jar任务
 *
 * 输入: Jar文件[jarFile]
 * 输出: 反编译后的Jar文件
 * 依赖: []
 */
class DecompileTask(private val jarFile: File) : Task<File, File>(jarFile) {
    override fun process(): File {
        val artifactPath = "${Project.path}/build/decompiled"
        val decompiledJarFileName = Configs.jarPath.substringAfterLast("/")
        val decompiledJarFile = File("$artifactPath/$decompiledJarFileName")

        if (decompiledJarFile.exists()) {
            decompiledJarFile.delete()
        }

        val process = Runtime
            .getRuntime()
            .exec("java -jar /usr/local/custom/java/fernflower.jar -dgs=1 ${jarFile.absolutePath} $artifactPath")

        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
        return File("$artifactPath/$decompiledJarFileName")
    }
}