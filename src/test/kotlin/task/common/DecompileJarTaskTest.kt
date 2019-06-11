package task.common

import Configs
import org.junit.Assert
import org.junit.Test
import java.io.File

class DecompileJarTaskTest {

    @Test
    fun process() {
        val decompiledJarFile = DecompileJarTask(File(Configs.jarFilePath)).process()

        println(decompiledJarFile.absolutePath)
        Assert.assertTrue(decompiledJarFile.exists())
    }
}