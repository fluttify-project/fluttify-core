package preprocess

import Configs.jarPath
import Configs.projectPath
import java.io.BufferedReader
import java.io.InputStreamReader


object JarDecompiler {
    fun decompile() {
        val process = Runtime.getRuntime().exec(
            """
            java -jar /usr/local/custom/java/fernflower.jar $jarPath $projectPath/resource/android/decompiled
            """.trimIndent()
        )
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
    }

    fun unzip() {
        val process = Runtime.getRuntime().exec(
            """
            unzip -o $projectPath/resource/android/decompiled/tbitble.jar -d $projectPath/resource/android/decompiled
            """.trimIndent()
        )
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
    }
}