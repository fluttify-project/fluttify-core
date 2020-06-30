package me.yohom.fluttify.tmpl.dart.type.type_interface

import me.yohom.fluttify.*
import me.yohom.fluttify.extensions.getResource
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class TypeInterfaceTmplKtTest : FluttifyTest() {

    @Test
    fun typeInterfaceTmpl_nim_com_netease_nimlib_sdk_InvocationFuture() {
        Nim.androidSDK
            .allTypes
            .find { it.name == "com.netease.nimlib.sdk.InvocationFuture" }
            ?.run {
                println(TypeInterfaceTmpl(this))
            }
    }

    @Test
    fun typeInterfaceTmpl_tim_com_tencent_imsdk_v2_V2TIMSendCallback() {
        Tim.androidSDK
            .allTypes
            .find { it.name == "com.tencent.imsdk.v2.V2TIMSendCallback" }
            ?.run {
                println(TypeInterfaceTmpl(this))
            }
    }
}