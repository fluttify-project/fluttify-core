package task.common

import Jar
import common.extensions.file
import org.junit.Test

class RecognizeAndroidRefTaskTest {

    @Test
    fun process() {
        val testPath = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled/com"
        AndroidRecognizeModelTask(testPath.file()).process()
        val testFile = Jar.Decompiled.mainClassFilePath.file()
        println(RecognizeAndroidRefTask(testFile).process().joinToString("\n") { it.absolutePath })
    }
}