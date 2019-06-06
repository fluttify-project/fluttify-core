package task

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

/**
 * 解压缩反编译Jar任务 依赖[DecompileTask]
 */
class UnzipTask(private val decompiledJarFile: File) : Task<File, File>(decompiledJarFile) {
    override fun process(): File {
        val decompiledJarPath = decompiledJarFile.absolutePath
        val artifactPath = decompiledJarPath.substringBeforeLast("/")

        val process = Runtime.getRuntime().exec("unzip -o $decompiledJarPath -d $artifactPath")
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
        return File(artifactPath)
    }
}