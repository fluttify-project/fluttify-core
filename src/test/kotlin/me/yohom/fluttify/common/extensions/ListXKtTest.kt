package me.yohom.fluttify.common.extensions

import me.yohom.fluttify.Amap
import me.yohom.fluttify.extensions.filterGetters
import me.yohom.fluttify.extensions.filterMethod
import me.yohom.fluttify.extensions.isList
import org.junit.Test

class ListXKtTest {

    @Test
    fun filterMethod() {
        Amap.androidSearchSDK.libs[1]
            .types.apply { println("types:$this") }
            .find { it.name == "com.amap.api.services.poisearch.PoiResult" }
            ?.methods
            ?.apply { println("before:$this") }
            ?.filterMethod()
            ?.apply { println("after:$this") }
    }

    @Test
    fun filterGetters() {
        Amap.iosSearchSDK.libs[1]
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

    @Test
    fun isList() {
        val result0 = "List".isList()
        println("List is: $result0")
        val result1 = "List<Object>".isList()
        println("List<Object> is: $result1")
        val result2 = "NSArray".isList()
        println("NSArray is: $result2")
        val result3 = "NSArray*".isList()
        println("NSArray* is: $result3")
    }
}