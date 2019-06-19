package task.`object`.platformview

import OutputProject
import common.extensions.file
import org.junit.Test

class AndroidKotlinFactoryTaskTest {

    @Test
    fun process() {
        AndroidKotlinFactoryTask(OutputProject.Android.platformViewFactoryFilePath.file())
            .process()
            .run { println(readText()) }
    }
}