package task

import org.junit.Assert
import org.junit.Test
import java.io.File

class DecompileTaskTest {

    @Test
    fun process() {
        val decompiledJarPath = DecompileTask().process()
        val jarFile = File(decompiledJarPath)

        Assert.assertTrue(jarFile.exists())
    }
}