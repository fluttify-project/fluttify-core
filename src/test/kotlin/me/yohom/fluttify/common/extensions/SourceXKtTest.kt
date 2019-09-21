package me.yohom.fluttify.common.extensions

import me.yohom.fluttify.extensions.file
import org.junit.Test

class SourceXKtTest {

    @Test
    fun isObjcModel() {
        val objcSource = "/Users/yohom/Github/Util/Kotlin/fluttify-core/src/main/resources/ios/Tbit.framework/Headers/BikeState.h".file().readText()
//        println(objcSource.isObjcModel())
    }

}