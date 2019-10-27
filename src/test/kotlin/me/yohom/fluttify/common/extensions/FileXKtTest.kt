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
//        val file = "/Users/yohom/Github/Util/Kotlin/fluttify-core/src/main/resources/library/ios/BaiduMapAPI_Map.framework/Headers/BMKMapView.h".file()
//        val file = "/Users/yohom/Github/Me/All/fluttify/amap_location_fluttify/output-project/amap_location_fluttify/ios/AMapLocationKit.framework/Headers/AMapLocationManager.h".file()
        val dir = "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_core_fluttify/sdk/ios/BaiduMapAPI_Base.framework/Headers/".file()
        dir
            .listFiles()
            ?.forEach {
                println(it.objcType())
            }
    }
}