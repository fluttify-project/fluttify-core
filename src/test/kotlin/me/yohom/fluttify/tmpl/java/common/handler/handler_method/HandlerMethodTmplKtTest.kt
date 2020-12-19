package me.yohom.fluttify.tmpl.java.common.handler.handler_method

import me.yohom.fluttify.*
import me.yohom.fluttify.tmpl.dart.type.type_interface.TypeInterfaceTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.method.MethodTmpl
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
            }
    }

    @Test
    fun handlerMethodTmpl_com_tencent_imsdk_v2_V2TIMSendCallback_sendMessage() {
        ext.android.callbackClasses = listOf(
            "com.tencent.imsdk.v2.V2TIMCallback",
            "com.tencent.imsdk.v2.TIMValueCallBack",
            "com.tencent.imsdk.v2.V2TIMSDKListener",
            "com.tencent.imsdk.v2.V2TIMConversationListener",
            "com.tencent.imsdk.v2.V2TIMSendCallback"
        )
        Tim.androidSDK
            .allTypes
            .find { it.name == "com.tencent.imsdk.v2.V2TIMMessageManager" }
            ?.methods
            ?.find { it.name == "sendMessage" }
            ?.run {
                println(HandlerMethodTmpl(this))
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
            }
    }

    @Test
    fun handlerMethodTmpl_nim_com_netease_nimlib_sdk_team_TeamService_createTeam() {
        Nim.androidSDK
            .allTypes
            .find { it.name == "com.netease.nimlib.sdk.team.TeamService" }
            ?.methods
            ?.find { it.name == "createTeam" }
            ?.run { println(HandlerMethodTmpl(this)) }
    }
}