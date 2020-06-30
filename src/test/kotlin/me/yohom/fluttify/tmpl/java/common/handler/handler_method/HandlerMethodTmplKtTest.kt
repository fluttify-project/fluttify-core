package me.yohom.fluttify.tmpl.java.common.handler.handler_method

import me.yohom.fluttify.Bmap
import me.yohom.fluttify.FluttifyTest
import me.yohom.fluttify.Nim
import me.yohom.fluttify.Tim
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class HandlerMethodTmplKtTest : FluttifyTest() {

    @Test
    fun handlerMethodTmpl_tim_com_tencent_imsdk_common_ICallback_done() {
        Tim.androidSDK
            .allTypes
            .find { it.name == "com.tencent.imsdk.common.ICallback" }
            ?.methods
            ?.find { it.name == "done" }
            ?.run {
                println(HandlerMethodTmpl(this))
//                Assert.assertTrue(this.isCallback)
            }
    }

    @Test
    fun handlerMethodTmpl_bmap_com_baidu_mapapi_search_core_RouteLine_setSteps() {
        Bmap.androidMapSDK
            .allTypes
            .find { it.name == "com.baidu.mapapi.search.core.RouteLine" }
            ?.methods
            ?.find { it.name == "setSteps" }
            ?.run {
                println(HandlerMethodTmpl(this))
//                Assert.assertTrue(this.isCallback)
            }
    }

    @Test
    fun handlerMethodTmpl_nim_com_netease_nimlib_sdk_InvocationFuture_setCallback() {
        Nim.androidSDK
            .allTypes
            .find { it.name == "com.netease.nimlib.sdk.InvocationFuture" }
            ?.methods
            ?.find { it.name == "setCallback" }
            ?.run {
                println(HandlerMethodTmpl(this))
//                Assert.assertTrue(this.isCallback)
            }
    }

    @Test
    fun handlerMethodTmpl_nim_com_netease_nimlib_sdk_uinfo_model_NimUserInfo_getGenderEnum() {
        Nim.androidSDK
            .allTypes
            .find { it.name == "com.netease.nimlib.sdk.uinfo.model.NimUserInfo" }
            ?.methods
            ?.find { it.name == "getGenderEnum" }
            ?.run {
                println(HandlerMethodTmpl(this))
//                Assert.assertTrue(this.isCallback)
            }
    }
}