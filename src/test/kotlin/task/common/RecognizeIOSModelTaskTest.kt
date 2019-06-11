package task.common

import org.junit.Test
import java.io.File

class RecognizeIOSModelTaskTest {

    @Test
    fun process() {
        val testPath = "/Users/yohom/Github/Util/Kotlin/fluttify-core/src/main/resources/ios/Tbit.framework"
        println(RecognizeIOSModelTask(File(testPath)).process())
    }
}