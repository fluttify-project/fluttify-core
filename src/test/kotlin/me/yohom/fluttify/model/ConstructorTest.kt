package me.yohom.fluttify.model

import me.yohom.fluttify.Amap
import org.junit.Test

class ConstructorTest {

    @Test
    fun filter() {
        Amap.androidMapSDK
            .libs[3]
            .types
            .find { it.name == "com.amap.api.maps.utils.overlay.SmoothMoveMarker" }
            ?.constructable()
            ?.run {
                println("结果: $this")
            }
    }
}