package me.yohom.fluttify.tmpl.dart.type.type_enum

import me.yohom.fluttify.Amap
import me.yohom.fluttify.FluttifyTest
import me.yohom.fluttify.Nim
import org.junit.jupiter.api.Test

internal class TypeEnumTmplKtTest : FluttifyTest() {

    @Test
    fun typeEnumTmpl() {
        Nim.iosSDK
            .allTypes
            .find { it.name == "NIMHandshakeType" }
            ?.run {
                println(TypeEnumTmpl(this))
            }
    }
    @Test
    fun typeEnumNaviTmpl() {
        Amap.iosMapSDK
            .allTypes
            .find { it.name == "AMapNaviDrivingStrategy" }
            ?.run {
                println(TypeEnumTmpl(this))
            }
    }
}