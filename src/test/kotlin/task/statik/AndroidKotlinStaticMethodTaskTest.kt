package task.statik

import common.extensions.file
import org.junit.Test

class AndroidKotlinStaticMethodTaskTest {

    @Test
    fun process() {
        val sourceFile =
            "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled/com/tbit/tbitblesdk/Bike/TbitBle.java".file()
        val result = AndroidKotlinStaticMethodTask(sourceFile).process()
        println(result.readText())
    }
}