package me.yohom.fluttify.common.extensions

import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.objcType
import org.junit.Test

class FileXKtTest {

    @Test
    fun javaType() {
    }

    @Test
    fun objcType() {
//        val file = "/Users/yohom/Github/Util/Kotlin/fluttify-core/src/main/resources/library/ios/BaiduMapAPI_Map.framework/Headers/BMKOfflineMapType.h".file()
        val file = "/Users/yohom/Github/Util/Kotlin/fluttify-core/src/main/resources/library/ios/BaiduMapAPI_Map.framework/Headers/BMKMapView.h".file()
        println(file.objcType())
    }
}