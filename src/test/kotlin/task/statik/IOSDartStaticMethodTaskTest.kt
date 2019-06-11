package task.statik

import common.extensions.file
import org.junit.Test

class IOSDartStaticMethodTaskTest {

    @Test
    fun process() {
        val sourceFile =
            "/Users/yohom/Github/Util/Kotlin/fluttify-core/src/main/resources/ios/Tbit.framework/Headers/TbitBluetooth.h".file()
        val result = IOSDartStaticMethodTask(sourceFile).process()
        println(result.readText())
    }
}