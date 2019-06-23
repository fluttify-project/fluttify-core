package task.common

import common.extensions.file
import org.junit.Test

class AndroidObfuscatedModelTaskTest {

    @Test
    fun process() {
        val testPath = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled/com"
        val modelFileList = AndroidRecognizeModelTask(testPath.file()).process()
        println(AndroidObfuscatedModelTask(modelFileList).process().joinToString("\n") { it.absolutePath })
    }
}