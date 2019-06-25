package task.common

import common.extensions.file
import org.apache.commons.io.FileUtils
import org.junit.Test

class JsonTaskTest {

    @Test
    fun process() {
        val sourceDir =
            "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/output-project/baidu_map_flutter/lib/src/android/model/".file()
        FileUtils.iterateFiles(sourceDir, arrayOf("dart"), true).forEach {
            val result = DartfmtTask(JsonTask(it).process()).process()
            println(result.readText())
        }
    }
}