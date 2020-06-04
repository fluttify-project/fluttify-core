package me.yohom.fluttify.tmpl.dart

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.Tmap
import me.yohom.fluttify.ext
import me.yohom.fluttify.tmpl.dart.type.type_sdk.method.MethodTmpl
import org.junit.jupiter.api.Test

class CallbackCaseDelegateTmplTest {

    @Test
    fun callbackCase() {
        ext = FluttifyExtension(null)
        val type = Tmap.androidSDK
            .allTypes
            .find { it.name == "com.tencent.tencentmap.mapsdk.maps.TencentMapNavi" }
            ?.methods
            ?.find { it.name == "calculateZoomToSpanLevelAsync" }
        MethodTmpl(type!!)
    }
}