package task

import Configs
import org.junit.Assert
import org.junit.Test
import task.UnzipJarTask
import java.io.File

class UnzipJarTaskTest {

    @Test
    fun process() {
        val jarFile = File(Configs.jarFilePath)
        val unzipJarDir = UnzipJarTask(jarFile).process()

        Assert.assertTrue(unzipJarDir.isDirectory)
        Assert.assertTrue(unzipJarDir.exists())
    }
}