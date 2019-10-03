package me.yohom.fluttify.model

import me.yohom.fluttify.androidSDK
import me.yohom.fluttify.extensions.filterConstructor
import org.junit.Test

class TypeTest {

    @Test
    fun constructable() {
        androidSDK
            .libs[1]
            .types
            .find { it.name == "com.amap.api.services.route.RouteSearch.DriveRouteQuery" }
            ?.constructors
            ?.filterConstructor()
            ?.run {
                println("结果: $this")
            }
    }
}