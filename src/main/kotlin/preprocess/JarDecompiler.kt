package preprocess

import Configs.jarPath
import java.io.BufferedReader
import java.io.InputStreamReader

object JarDecompiler {
    fun decompile() {
        val process = Runtime.getRuntime().exec(
            """
            java -jar /usr/local/custom/java/fernflower.jar $jarPath ${Project.path}/src/main/resources/android/decompiled
            """.trimIndent()
        )
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
    }

    fun unzip() {
        val process = Runtime.getRuntime().exec(
            """
            unzip -o ${Project.path}/src/main/resources/android/decompiled/tbitble.jar -d ${Project.path}/src/main/resources/android/decompiled
            """.trimIndent()
        )
        val br = BufferedReader(InputStreamReader(process.inputStream))
        br.lines().forEach(::println)
    }
}