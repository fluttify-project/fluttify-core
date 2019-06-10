package task.statik

import common.extensions.toFile
import org.junit.Test

class IOSSwiftStaticMethodTaskTest {

    @Test
    fun process() {
        val sourceFile =
            "/Users/yohom/Github/Util/Kotlin/fluttify-core/src/main/resources/ios/Tbit.framework/Headers/TbitBluetooth.h".toFile()
        val result = IOSSwiftStaticMethodTask(sourceFile).process()
        println(result.readText())
    }
}