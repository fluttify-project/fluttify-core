package task.common

import common.extensions.file
import org.junit.Test

class DartInterfaceTaskTest {

    @Test
    fun process() {
        val testFile= "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/decompiled/com/baidu/mapapi/map/BaiduMap.java".file()
        DartInterfaceTask(testFile).process().run { println(readText()) }
    }
}