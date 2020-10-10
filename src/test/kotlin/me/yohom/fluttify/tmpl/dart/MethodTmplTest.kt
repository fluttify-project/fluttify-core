package me.yohom.fluttify.tmpl.dart

import me.yohom.fluttify.*
import me.yohom.fluttify.tmpl.dart.type.type_sdk.TypeSdkTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.method.MethodBatchTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.method.MethodTmpl
import org.junit.jupiter.api.Test


class MethodTmplTest : FluttifyTest() {

    @Test
    fun dartMethod() {
//        Nim.androidSDK
//            .allTypes
//            .find { it.name == "com.netease.nimlib.sdk.InvocationFuture" }
//            ?.methods
//            ?.filter { it.filter }
//            ?.run { println("过滤结果: $this") }

        println(SYSTEM_TYPE.find { it.name == "android.view.SurfaceHolder.Callback" }?.isCallback)
//        val testMethod = Method(
//            "String",
//            "test",
//            listOf(Parameter(variable = Variable("String", "var"))),
//            false,
//            false,
//            true,
//            "Test"
//        )
//        val dartMethodString = MethodTmpl(testMethod).dartMethod()
//        println(dartMethodString)
    }

    @Test
    fun methodTmpl_nim_NIMLoginManager_addDelegate() {
        Nim.iosSDK
            .allTypes
            .find { it.name == "NIMLoginManager" }
            ?.methods
            ?.find { it.name == "addDelegate" }
            ?.run { println(MethodTmpl(this)) }
    }

    @Test
    fun methodTmpl_com_amap_api_navi_model_AimLessModeCongestionInfo() {
        Amap.androidMapSDK
            .allTypes
            .find { it.name == "com.amap.api.navi.model.AimLessModeCongestionInfo" }
            ?.methods
            ?.find { it.name == "getAmapCongestionLinks" }
            ?.run { println(MethodTmpl(this)) }
    }

    @Test
    fun methodBatchTmpl_amap() {
        Amap.iosMapSDK
            .allTypes
            .find { it.name == "MAParticleColorGenerate" }
            ?.methods
            ?.find { it.name == "getColor" }
            ?.run { println(MethodBatchTmpl(this)) }
    }

    @Test
    fun methodTmpl_easemob_im_com_hyphenate_push_EMPushConfig_getEnabledPushTypes() {
        EaseMob.androidSDK
            .allTypes
            .find { it.name == "com.hyphenate.push.EMPushConfig" }
            ?.methods
            ?.find { it.name == "getEnabledPushTypes" }
            ?.run { println(MethodTmpl(this)) }
    }

    @Test
    fun methodTmpl_ali_rtc_com_serenegiant_usb_UVCCamera_open() {
        AliRtc.androidSDK
            .allTypes
            .find { it.name == "com.serenegiant.usb.UVCCamera" }
            ?.run { println(TypeSdkTmpl(this)) }
    }

    @Test
    fun methodTmpl_nim_com_netease_nimlib_sdk_team_TeamService_createTeam() {
        ext.android.noncallbackClasses = listOf()
        Nim.androidSDK
            .allTypes
            .find { it.name == "com.netease.nimlib.sdk.team.TeamService" }
            ?.methods
            ?.find { it.name == "createTeam" }
            ?.run { println(MethodTmpl(this)) }
    }
}