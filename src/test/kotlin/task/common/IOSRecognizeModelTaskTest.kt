package task.common

import Framework
import common.extensions.file
import org.junit.Test

class IOSRecognizeModelTaskTest {

    @Test
    fun process() {
        val testPath = Framework.singleClassesDirPath
        println(IOSRecognizeModelTask(testPath.file()).process())
    }
}