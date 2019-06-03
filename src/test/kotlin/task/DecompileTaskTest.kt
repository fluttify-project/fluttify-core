package task

import Configs
import org.junit.Assert
import org.junit.Test
import java.io.File

class DecompileTaskTest {

    @Test
    fun process() {
        val decompiledJarFile = DecompileTask(File(Configs.jarPath)).process()

        println(decompiledJarFile.absolutePath)
        Assert.assertTrue(decompiledJarFile.exists())
    }
}