package me.yohom.fluttify.model

import me.yohom.fluttify.androidSearchSDK
import me.yohom.fluttify.iosMapSDK
import org.junit.Test

class TypeTest {

    @Test
    fun constructable() {
        androidSearchSDK
            .libs[1]
            .types
            .find { it.name == "com.amap.api.services.route.RouteSearch.DriveRouteQuery" }
            ?.constructable()
            ?.run {
                println("结果: $this")
            }
//
//        iosSDK
//            .libs[1]
//            .types
//            .find { it.name == "AMapNearbySearchManager" }
//            ?.constructable()
//            ?.run {
//                println("结果: $this")
//            }
    }

    @Test
    fun firstConcretSubtype() {
        iosMapSDK
            .libs[1]
            .types
            .find { it.name == "MAAnnotation" }
            ?.firstConcretSubtype()
            ?.run {
                println("结果: $this")
            }
    }
}