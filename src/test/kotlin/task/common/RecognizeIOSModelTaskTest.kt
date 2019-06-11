package task.common

import common.extensions.file
import org.junit.Test

class RecognizeIOSModelTaskTest {

    @Test
    fun process() {
        val testPath = "/Users/yohom/Github/Util/Kotlin/fluttify-core/src/main/resources/ios/Tbit.framework"
        println(RecognizeIOSModelTask(testPath.file()).process())
    }
}