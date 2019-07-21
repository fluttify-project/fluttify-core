package task

import me.yohom.fluttify.FluttifyCorePluginExtension
import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.common.extensions.iterate
import me.yohom.fluttify.task.IOSDartInterfaceTask
import org.junit.Test

class IOSDartInterfaceTaskTest {

    @Test
    fun process() {
        FluttifyCorePluginExtension.frameworkDirPath
            .file()
            .iterate("h") {
                val file = IOSDartInterfaceTask(it).process()
                println(file.readText())
            }
//        Export("/Users/yohom/Github/Util/Kotlin/fluttify-core/build/output-project/baidu_map_flutter".file()).process()

    }
}