package task.common

import common.extensions.toFile
import org.junit.Test

class JsonTaskTest {

    @Test
    fun process() {
        val sourcePath = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/output-project/tbitble_flutter/lib/src/android/model/bike_state.dart"
        val result = JsonTask(sourcePath.toFile()).process()
        println(result.readText())
    }
}