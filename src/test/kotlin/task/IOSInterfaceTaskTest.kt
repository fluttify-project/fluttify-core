package task

import me.yohom.fluttify.FluttifyCorePluginExtension
import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.task.IOSInterfaceTask
import org.junit.Test

class IOSInterfaceTaskTest {

    @Test
    fun process() {
        val file = IOSInterfaceTask(FluttifyCorePluginExtension.frameworkDirPath.file())
            .process()
        println(file.readText())
    }
}