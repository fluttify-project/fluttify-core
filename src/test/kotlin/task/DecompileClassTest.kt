package task

import me.yohom.fluttify.task.DecompileClass
import org.junit.Test

class DecompileClassTest {
    @Test
    fun process() {
        DecompileClass().decompile()
    }
}