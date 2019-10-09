package me.yohom.fluttify.model

import me.yohom.fluttify.androidSDK
import org.junit.Test

class TypeTest {

    @Test
    fun constructable() {
        androidSDK
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
}