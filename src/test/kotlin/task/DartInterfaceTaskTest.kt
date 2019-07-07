package task

import Jar
import common.extensions.file
import common.extensions.isObfuscated
import common.extensions.iterate
import org.junit.Test

class DartInterfaceTaskTest {

    @Test
    fun process() {
        Jar.Decompiled.rootDirPath.file().iterate("java") {
            if (!it.nameWithoutExtension.isObfuscated()) {
                val file = DartInterfaceTask(it).process()
//                val formatedFile = DartfmtTask(file).process()
                println(file.readText())
            }
        }
        ExportTask("/Users/yohom/Github/Util/Kotlin/fluttify-core/build/output-project/baidu_map_flutter".file()).process()
//        println("  abc\ndef".replaceParagraph("abc", "g"))
    }
}