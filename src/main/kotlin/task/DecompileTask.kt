package task

import Configs
import common.PATH
import preprocess.Project
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

class DecompileTask(private val jarPath: PATH = Configs.jarPath) : Task<PATH, PATH>(jarPath) {
    override fun process(): PATH {
        val artifactPath = "${Project.path}/src/main/resources/android/decompiled"
        val decompiledJarFileName = Configs.jarPath.substringAfterLast("/")
        val decompiledJarFile = File("$artifactPath/$decompiledJarFileName")

        if (decompiledJarFile.exists()) {
            decompiledJarFile.delete()
        }

        val process =
            Runtime.getRuntime().exec("java -jar /usr/local/custom/java/fernflower.jar $jarPath $artifactPath")
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
        return "$artifactPath/$decompiledJarFileName"
    }
}