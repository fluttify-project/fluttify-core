package me.yohom.fluttify.tmpl.dart.type.type_sdk

import me.yohom.fluttify.FluttifyTest
import me.yohom.fluttify.Tim
import me.yohom.fluttify.tmpl.dart.type.type_interface.TypeInterfaceTmpl
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TypeSdkTmplKtTest : FluttifyTest() {

    @Test
    fun typeSdkTmpl_tim_com_tencent_imsdk_v2_V2TIMManager() {
        Tim.androidSDK
            .allTypes
            .find { it.name == "com.tencent.imsdk.v2.V2TIMManager" }
            ?.run {
                println(TypeSdkTmpl(this))
            }
    }
}