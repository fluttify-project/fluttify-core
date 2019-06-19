package task.`object`.platformview

import OutputProject
import common.extensions.file
import org.junit.Test

class AndroidPlatformViewTaskTest {

    @Test
    fun process() {
        AndroidPlatformViewTask(OutputProject.Android.platformViewFilePath.file())
            .process()
            .readText()
            .run { println(this) }
    }
}