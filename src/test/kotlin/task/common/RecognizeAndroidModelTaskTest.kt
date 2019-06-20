package task.common

import org.junit.Test
import java.io.File

class RecognizeAndroidModelTaskTest {

    @Test
    fun process() {
        val testPath = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled/com"
        println(RecognizeAndroidModelTask(File(testPath)).process().joinToString("\n") { it.absolutePath })
    }
}