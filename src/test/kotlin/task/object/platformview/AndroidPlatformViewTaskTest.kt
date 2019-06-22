package task.`object`.platformview

import Jar
import common.extensions.file
import org.junit.Test
import task.common.RecognizeAndroidModelTask

class AndroidPlatformViewTaskTest {

    @Test
    fun process() {
        RecognizeAndroidModelTask(Jar.Decompiled.rootDirPath.file()).process()
        AndroidPlatformViewTask(Jar.Decompiled.mainClassFilePath.file())
            .process()
            .readText()
            .run { println(this) }
    }
}