package task

import me.yohom.fluttify.FluttifyCorePluginExtension
import org.junit.Assert
import org.junit.Test
import me.yohom.fluttify.task.UnzipJarTask
import java.io.File

class UnzipJarTaskTest {

    @Test
    fun process() {
        val jarFile = File(FluttifyCorePluginExtension.jarFilePath)
        val unzipJarDir = UnzipJarTask(jarFile).process()

        Assert.assertTrue(unzipJarDir.isDirectory)
        Assert.assertTrue(unzipJarDir.exists())
    }
}