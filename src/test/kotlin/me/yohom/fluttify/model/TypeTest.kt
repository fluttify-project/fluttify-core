package me.yohom.fluttify.model

import me.yohom.fluttify.androidLocationSDK
import me.yohom.fluttify.androidMapSDK
import me.yohom.fluttify.androidSearchSDK
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
//        iosMapSDK
//            .libs[1]
//            .types
//            .find { it.name == "MAAnnotation" }
//            ?.firstConcretSubtype()
//            ?.run {
//                println("结果: $this")
//            }
        androidMapSDK
            .libs[2]
            .types
//            .find { it.name == "com.amap.api.maps.model.TileProvider" }
            .find { it.name == "com.amap.api.maps.AMap.CancelableCallback" }
            ?.firstConcretSubtype()
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
        androidLocationSDK
            .libs[1]
            .types
            .find { it.name == "com.amap.api.location.AMapLocationListener" }
            ?.hasSubtype()
            ?.run {
                println("结果: $this")
            }
    }
}