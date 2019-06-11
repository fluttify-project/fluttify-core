package task.common

import Configs
import common.extensions.file
import org.junit.Assert
import org.junit.Test

class SingleObjcClassTaskTest {

    @Test
    fun process() {
        val objcClassesDir = SingleObjcClassTask(Configs.frameworkDirPath.file()).process()

        println(objcClassesDir.listFiles().forEach { println(it) })
        Assert.assertTrue(objcClassesDir.isDirectory)
    }
}