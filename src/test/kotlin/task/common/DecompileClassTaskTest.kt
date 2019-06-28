package task.common

import common.extensions.file
import org.apache.commons.io.FileUtils
import org.junit.Assert
import org.junit.Test

class DecompileClassTaskTest {

    @Test
    fun process() {
        FileUtils.iterateFiles(
            "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled/com/".file(),
            arrayOf("class"),
            true
        ).forEach {
            val decompiledJarFile = DecompileClassTask(it).process()
            println(decompiledJarFile.absolutePath)
            Assert.assertTrue(decompiledJarFile.exists())
        }

    }
}