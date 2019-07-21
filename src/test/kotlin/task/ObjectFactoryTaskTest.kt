package task

import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.task.ObjectFactoryTask
import org.junit.Test

class ObjectFactoryTaskTest {

    @Test
    fun process() {
        val testDir = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled"
        ObjectFactoryTask(testDir.file()).process().readText().run { println(this) }
    }
}