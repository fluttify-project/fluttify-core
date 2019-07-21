package task

import me.yohom.fluttify.task.Export
import org.junit.Test
import java.io.File

class ExportTest {

    @Test
    fun process() {
        val outputProjectDirPath = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/output-project/baidu_map_flutter"

        Export(File(outputProjectDirPath)).process()
    }
}