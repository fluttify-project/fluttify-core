package task

import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.task.DartfmtTask
import org.junit.Test

class DartfmtTaskTest {

    @Test
    fun process() {
        val testFile = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/output-project/tbitble_flutter/lib/tbitble_flutter.dart".file()
        println(DartfmtTask(testFile).process().readText())
    }
}