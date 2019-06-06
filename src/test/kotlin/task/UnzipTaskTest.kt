package task

import org.junit.Assert
import org.junit.Test
import Project
import java.io.File

class UnzipTaskTest {

    @Test
    fun process() {
        val decompiledJarFile = File("${Project.path}/build/decompiled/tbitble.jar")
        val decompiledJarDir = UnzipTask(decompiledJarFile).process()

        Assert.assertTrue(decompiledJarDir.isDirectory)
        Assert.assertTrue(decompiledJarDir.exists())
    }
}