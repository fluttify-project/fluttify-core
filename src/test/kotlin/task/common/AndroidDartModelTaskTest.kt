package task.common

import common.extensions.file
import org.junit.Test
import java.io.File

class AndroidDartModelTaskTest {

    @Test
    fun process() {
        val testPath = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled/com"
        RecognizeAndroidModelTask(File(testPath)).process()
        val testFile = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled/com/baidu/mapapi/synchronization/histroytrace/HistoryTraceQueryOptions.java".file()
        val dartFile = AndroidDartModelTask(testFile).process()
        println(DartfmtTask(dartFile).process().readText())
    }
}