package task

import Configs
import common.extensions.file
import org.junit.Test

class IOSInterfaceTaskTest {

    @Test
    fun process() {
        val file = IOSInterfaceTask(Configs.frameworkDirPath.file())
            .process()
        println(file.readText())
    }
}