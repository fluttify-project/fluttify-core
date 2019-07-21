package task

import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.task.ObjectFactory
import org.junit.Test

class ObjectFactoryTest {

    @Test
    fun process() {
        val testDir = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled"
        ObjectFactory(testDir.file()).process().readText().run { println(this) }
    }
}