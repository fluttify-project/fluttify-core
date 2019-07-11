package task

import Configs
import common.extensions.file
import common.extensions.iterate
import org.junit.Test

class IOSDartInterfaceTaskTest {

    @Test
    fun process() {
        Configs.frameworkDirPath
            .file()
            .iterate("h") {
                val file = IOSDartInterfaceTask(it).process()
                println(file.readText())
            }
//        ExportTask("/Users/yohom/Github/Util/Kotlin/fluttify-core/build/output-project/baidu_map_flutter".file()).process()

    }
}