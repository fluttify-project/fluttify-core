package task

import org.junit.Assert
import org.junit.Test

class UnzipTaskTest {

    @Test
    fun process() {
        val decompiledJarPath = "/Users/yohom/Github/Util/Kotlin/fluttify-core/src/test/resources/android/decompiled/tbitble.jar"
        val decompiledJarDir = UnzipTask(decompiledJarPath).process()

        Assert.assertTrue(decompiledJarDir.isDirectory)
        Assert.assertTrue(decompiledJarDir.exists())
    }
}