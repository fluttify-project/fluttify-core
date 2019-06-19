package task.`object`.platformview

import OutputProject
import common.extensions.file
import org.junit.Test

class AndroidKotlinPluginTaskTest {

    @Test
    fun process() {
        AndroidKotlinPluginTask(OutputProject.Android.kotlinFilePath.file())
            .process()
            .readText()
            .run { println(this) }
    }
}