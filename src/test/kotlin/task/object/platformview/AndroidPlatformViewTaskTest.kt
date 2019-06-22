package task.`object`.platformview

import Jar
import common.extensions.file
import org.junit.Test
import task.common.AndroidRecognizeModelTask

class AndroidPlatformViewTaskTest {

    @Test
    fun process() {
        AndroidRecognizeModelTask(Jar.Decompiled.rootDirPath.file()).process()
        AndroidPlatformViewTask(Jar.Decompiled.mainClassFilePath.file())
            .process()
            .readText()
            .run { println(this) }
    }
}