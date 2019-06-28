package task.`object`.platformview

import Jar
import common.extensions.file
import org.junit.Test

class AndroidKotlinPlatformViewTaskTest {

    @Test
    fun process() {
        AndroidKotlinPlatformViewTask(Jar.Decompiled.mainClassFilePath.file())
            .process()
            .readText()
            .run { println(this) }
    }
}