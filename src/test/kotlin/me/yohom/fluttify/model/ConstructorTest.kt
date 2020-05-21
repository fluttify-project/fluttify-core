package me.yohom.fluttify.model

import me.yohom.fluttify.Amap
import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.TencentLive
import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.filterConstructor
import org.junit.jupiter.api.Test

class ConstructorTest {

    @Test
    fun filter() {
//        Amap.androidMapSDK
//            .libs[3]
//            .types
//            .find { it.name == "com.amap.api.maps.utils.overlay.SmoothMoveMarker" }
//            ?.constructable
//            ?.run {
//                println("结果: $this")
//            }
        TencentLive.androidSDK
            .libs[1]
            .types
            .find { it.name == "com.tencent.rtmp.ui.TXCloudVideoView" }
            ?.constructors
            ?.filterConstructor()
            ?.run {
                println("结果: $this")
            }
    }
}