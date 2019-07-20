package task

import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.task.ObjectCreatorTask
import org.junit.Test

class ObjectCreatorTaskTest {

    @Test
    fun process() {
        val testDir = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled"
        ObjectCreatorTask(testDir.file()).process().readText().run { println(this) }
    }
}