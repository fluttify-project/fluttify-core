package task.common

import Framework
import common.extensions.file
import org.junit.Test

class RecognizeIOSModelTaskTest {

    @Test
    fun process() {
        val testPath = Framework.singleClassesDirPath
        println(RecognizeIOSModelTask(testPath.file()).process())
    }
}