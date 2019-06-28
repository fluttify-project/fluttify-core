package task.common

import common.extensions.file
import org.junit.Test

class AndroidInterfaceTaskTest {

    @Test
    fun process() {
        val file = AndroidInterfaceTask("/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled/com/".file()).process()
        println(file.readText())
    }
}