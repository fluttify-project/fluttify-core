package me.yohom.fluttify.common.extensions

import me.yohom.fluttify.androidSearchSDK
import me.yohom.fluttify.extensions.filterGetters
import me.yohom.fluttify.extensions.filterMethod
import me.yohom.fluttify.iosSearchSDK
import org.junit.Test

class ListXKtTest {

    @Test
    fun filterMethod() {
        androidSearchSDK.libs[1]
            .types.apply { println("types:$this") }
            .find { it.name == "com.amap.api.services.poisearch.PoiResult" }
            ?.methods
            ?.apply { println("before:$this") }
            ?.filterMethod()
            ?.apply { println("after:$this") }
    }

    @Test
    fun filterGetters() {
        iosSearchSDK.libs[1]
            .types.apply { println("types:$this") }
            .find { it.name == "AMapPOISearchResponse" }
            ?.fields
            ?.apply { println("before:$this") }
            ?.filterGetters()
            ?.apply { println("after:$this") }
    }

    @Test
    fun filterType() {
    }

    @Test
    fun filterSetters() {
    }
}