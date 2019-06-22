package task.common

import Jar
import common.extensions.file
import org.junit.Test

class RecognizeAndroidNonModelTaskTest {

    @Test
    fun process() {
        val testPath = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled/com"
        RecognizeAndroidModelTask(testPath.file()).process()
        val testFile = Jar.Decompiled.mainClassFilePath.file()
        println(RecognizeAndroidNonModelTask(testFile).process().joinToString("\n") { it.absolutePath })
    }
}