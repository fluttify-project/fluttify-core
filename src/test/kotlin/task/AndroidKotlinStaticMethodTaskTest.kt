package task

import common.extensions.toFile
import org.junit.Test
import task.statik.AndroidKotlinStaticMethodTask

class AndroidKotlinStaticMethodTaskTest {

    @Test
    fun process() {
        val sourceFile =
            "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled/com/tbit/tbitblesdk/Bike/TbitBle.java".toFile()
        val result = AndroidKotlinStaticMethodTask(sourceFile).process()
        println(result.readText())
    }
}