package task.`object`.platformview

import Jar
import common.extensions.file
import org.junit.Test

class AndroidDartControllerTaskTest {

    @Test
    fun process() {
        AndroidDartControllerTask(Jar.Decompiled.mainClassFilePath.file()).process()
    }
}