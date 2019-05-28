package preprocess

import Configs.projectPath
import java.io.BufferedReader
import java.io.InputStreamReader


object JarDecompiler {
    fun decompile() {
        val process = Runtime.getRuntime().exec(
            """
            java -jar /usr/local/custom/java/fernflower.jar $projectPath/resource/android/tbitble.jar $projectPath/resource/android/decompiled
            """.trimIndent()
        )
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines()
    }

    fun unzip() {
        val process = Runtime.getRuntime().exec(
            """
            unzip $projectPath/resource/android/decompiled/tbitble.jar -d $projectPath/resource/android/decompiled
            """.trimIndent()
        )
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines()
    }
}