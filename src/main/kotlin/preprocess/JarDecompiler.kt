package preprocess

import Configs.jarPath
import preprocess.Analyzer.projectPath
import java.io.BufferedReader
import java.io.InputStreamReader

object JarDecompiler {
    fun decompile() {
        val process = Runtime.getRuntime().exec(
            """
            java -jar /usr/local/custom/java/fernflower.jar $jarPath $projectPath/src/main/resources/android/decompiled
            """.trimIndent()
        )
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
    }

    fun unzip() {
        val process = Runtime.getRuntime().exec(
            """
            unzip -o $projectPath/src/main/resources/android/decompiled/tbitble.jar -d $projectPath/src/main/resources/android/decompiled
            """.trimIndent()
        )
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
    }
}