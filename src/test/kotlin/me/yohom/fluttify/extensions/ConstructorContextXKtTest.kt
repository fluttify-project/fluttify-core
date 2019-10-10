package me.yohom.fluttify.extensions

import me.yohom.fluttify.androidNaviSDK
import org.junit.Test

class ConstructorContextXKtTest {

    @Test
    fun isPublic() {
    }

    @Test
    fun hasDependency() {
    }

    @Test
    fun isStaticType() {
        androidNaviSDK.libs[1]
            .types.apply { println("types:$this") }
            .find { it.name == "com.amap.api.services.poisearch.PoiResult" }
            ?.methods
            ?.apply { println("before:$this") }
            ?.filterMethod()
            ?.apply { println("after:$this") }
    }

    @Test
    fun formalParams() {
    }
}