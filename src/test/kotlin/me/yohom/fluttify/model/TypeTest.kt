package me.yohom.fluttify.model

import me.yohom.fluttify.Amap
import me.yohom.fluttify.BaiduAsr
import me.yohom.fluttify.Bmap
import org.junit.jupiter.api.Test

class TypeTest {

    @Test
    fun constructable() {
//        Amap.androidSearchSDK
//            .libs[1]
//            .types
//            .find { it.name == "com.amap.api.services.route.RouteSearch.DriveRouteQuery" }
//            ?.constructable
//            ?.run {
//                println("结果: $this")
//            }
        Bmap.androidMapSDK
            .libs[3]
            .types
            .forEach {
                println("${it.name} constructable: ${it.constructable}")
            }
//
//        iosSDK
//            .libs[1]
//            .types
//            .find { it.name == "AMapNearbySearchManager" }
//            ?.constructable
//            ?.run {
//                println("结果: $this")
//            }
    }

    @Test
    fun firstConcretSubtype() {
//        iosMapSDK
//            .libs[1]
//            .types
//            .find { it.name == "MAAnnotation" }
//            ?.firstConcretSubtype()
//            ?.run {
//                println("结果: $this")
//            }
        BaiduAsr.androidAsrSDK
            .libs[1]
            .types
            .find { it.name == "com.baidu.speech.EventManager" }
//            .find { it.name == "com.amap.api.maps.AMap.CancelableCallback" }
//            .find { it.name == "com.amap.api.maps.AMap.InfoWindowAdapter" }
            ?.firstConcretSubtype
            ?.run {
                println("结果: $this")
            }
    }

    @Test
    fun hasSubtype() {
//        iosMapSDK
//            .libs[1]
//            .types
//            .find { it.name == "MAAnnotation" }
//            ?.firstConcretSubtype()
//            ?.run {
//                println("结果: $this")
//            }
        BaiduAsr.androidAsrSDK
            .libs[1]
            .types
            .find { it.name == "com.baidu.speech.EventManager" }
            ?.subtypes
            ?.run {
                println("结果: ${this.joinToString { it.name }}")
            }
    }

    @Test
    fun ancestorTypes() {
//        iosMapSDK
//            .libs[1]
//            .types
//            .find { it.name == "MAAnnotation" }
//            ?.firstConcretSubtype()
//            ?.run {
//                println("结果: $this")
//            }
        Amap.iosMapSDK
            .libs[0]
            .types
            .find { it.name == "MAGroundOverlay" }
            ?.ancestorTypes
            ?.run {
                println("结果: $this")
            }
    }
}