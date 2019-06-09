package task

import common.extensions.toFile
import org.junit.Test
import task.statik.AndroidDartStaticMethodTask

class AndroidDartStaticMethodTaskTest {

    @Test
    fun process() {
        val sourceFile =
            "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled/com/tbit/tbitblesdk/Bike/TbitBle.java".toFile()
        val result = AndroidDartStaticMethodTask(sourceFile).process()
        println(result.readText())
    }
}