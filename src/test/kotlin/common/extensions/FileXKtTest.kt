package common.extensions

import org.junit.Test

class FileXKtTest {

    @Test
    fun javaType() {
    }

    @Test
    fun objcType() {
        val file = "/Users/yohom/Github/Util/Kotlin/fluttify-core/build/objc-classes/Class_1".file()

        println(file.objcType())
    }
}