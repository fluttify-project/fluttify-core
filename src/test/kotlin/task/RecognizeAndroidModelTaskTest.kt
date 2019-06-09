package task

import org.junit.Test
import task.common.RecognizeAndroidModelTask
import java.io.File

class RecognizeAndroidModelTaskTest {

    @Test
    fun process() {
        val testPath = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled/com"
        println(RecognizeAndroidModelTask(File(testPath)).process())
    }
}