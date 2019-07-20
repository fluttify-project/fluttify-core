package task

import me.yohom.fluttify.FluttifyCorePluginExtension
import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.task.SingleObjcClassTask
import org.junit.Assert
import org.junit.Test

class SingleObjcClassTaskTest {

    @Test
    fun process() {
        val objcClassesDir = SingleObjcClassTask(FluttifyCorePluginExtension.frameworkDirPath.file())
            .process()

        println(objcClassesDir.listFiles().forEach { println(it) })
        Assert.assertTrue(objcClassesDir.isDirectory)
    }
}