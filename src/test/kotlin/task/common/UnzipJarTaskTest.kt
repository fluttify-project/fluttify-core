package task.common

import Configs
import org.junit.Assert
import org.junit.Test
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