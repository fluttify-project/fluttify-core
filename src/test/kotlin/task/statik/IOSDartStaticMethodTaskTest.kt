package task.statik

import common.extensions.toFile
import org.junit.Test

class IOSDartStaticMethodTaskTest {

    @Test
    fun process() {
        val sourceFile =
            "/Users/yohom/Github/Util/Kotlin/fluttify-core/src/main/resources/ios/Tbit.framework/Headers/TbitBluetooth.h".toFile()
        val result = IOSDartStaticMethodTask(sourceFile).process()
        println(result.readText())
    }
}