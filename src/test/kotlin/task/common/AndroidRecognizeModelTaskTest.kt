package task.common

import org.junit.Test
import java.io.File

class AndroidRecognizeModelTaskTest {

    @Test
    fun process() {
        val testPath = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled/com"
        println(AndroidRecognizeModelTask(File(testPath)).process().joinToString("\n") { it.absolutePath })
    }
}