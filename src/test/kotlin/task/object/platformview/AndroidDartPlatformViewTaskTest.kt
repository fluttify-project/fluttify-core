package task.`object`.platformview

import OutputProject
import common.extensions.file
import org.junit.Test

class AndroidDartPlatformViewTaskTest {

    @Test
    fun process() {
        AndroidDartPlatformViewTask(OutputProject.Dart.androidPlatformViewFilePath.file())
            .process()
            .readText()
            .run { println(this) }
    }
}