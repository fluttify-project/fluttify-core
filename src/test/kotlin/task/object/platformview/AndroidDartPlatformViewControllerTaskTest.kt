package task.`object`.platformview

import Jar
import common.extensions.file
import org.junit.Test

class AndroidDartPlatformViewControllerTaskTest {

    @Test
    fun process() {
        AndroidDartPlatformViewControllerTask(Jar.Decompiled.mainClassFilePath.file()).process()
    }
}