package task

import common.PATH
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

class UnzipTask(private val decompiledJarPath: PATH) : Task<PATH, File>(decompiledJarPath) {
    override fun process(): File {
        val artifactPath = decompiledJarPath.substringBeforeLast("/")
        val process = Runtime.getRuntime().exec("unzip -o $decompiledJarPath -d $artifactPath")
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
        return File(artifactPath)
    }
}