package task

import org.junit.Test
import me.yohom.fluttify.task.ExportTask
import java.io.File

class ExportTaskTest {

    @Test
    fun process() {
        val outputProjectDirPath = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/output-project/baidu_map_flutter"

        ExportTask(File(outputProjectDirPath)).process()
    }
}