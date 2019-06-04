package task

import org.junit.Test
import java.io.File

class AndroidDartModelTaskTest {

    @Test
    fun process() {
        val testFilePath = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled/com/tbit/tbitblesdk/Bike/model/BikeState.java"
        val dartModelSource = AndroidDartModelTask(File(testFilePath)).process().readText()
        println(dartModelSource)
    }
}