package task

import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.task.AndroidInterfaceTask
import org.junit.Test

class AndroidInterfaceTaskTest {

    @Test
    fun process() {
        val file = AndroidInterfaceTask("/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled/com/".file())
            .process()
        println(file.readText())
    }
}