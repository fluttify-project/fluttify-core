package task.common

import org.junit.Test
import java.io.File

class ExportTaskTest {

    @Test
    fun process() {
        val outputProjectDirPath = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/output-project/tbitble_flutter"

        ExportTask(File(outputProjectDirPath)).process()
    }
}