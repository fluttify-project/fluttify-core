package me.yohom.fluttify.common.extensions

import me.yohom.fluttify.sdk
import org.junit.Test

class ListXKtTest {

    @Test
    fun filterMethod() {
        sdk.libs[0]
            .types.apply { println("types:$this") }
            .find { it.name == "com.amap.api.maps.AMap" }
            ?.methods
            ?.apply { println("before:$this") }
            ?.filterMethod()
            ?.apply { println("after:$this") }
    }

    @Test
    fun filterGetters() {
    }

    @Test
    fun filterType() {
    }

    @Test
    fun filterSetters() {
    }
}