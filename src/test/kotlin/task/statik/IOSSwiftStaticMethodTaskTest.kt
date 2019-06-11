package task.statik

import common.extensions.file
import org.junit.Test

class IOSSwiftStaticMethodTaskTest {

    @Test
    fun process() {
        val sourceFile =
            "/Users/yohom/Github/Util/Kotlin/fluttify-core/src/main/resources/ios/Tbit.framework/Headers/TbitBluetooth.h".file()
        val result = IOSSwiftStaticMethodTask(sourceFile).process()
        println(result.readText())
    }
}