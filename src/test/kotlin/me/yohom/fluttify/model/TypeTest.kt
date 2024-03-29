package me.yohom.fluttify.model

import me.yohom.fluttify.*
import me.yohom.fluttify.extensions.filterConstructable
import me.yohom.fluttify.tmpl.dart.type.type_sdk.TypeSdkTmpl
import me.yohom.fluttify.tmpl.objc.common.handler.handler_getter.HandlerGetterTmpl
import org.junit.jupiter.api.Test

class TypeTest : FluttifyTest() {

    @Test
    fun constructable() {
//        Amap.androidSearchSDK
//            .libs[1]
//            .types
//            .find { it.name == "com.amap.api.services.route.RouteSearch.DriveRouteQuery" }
//            ?.constructable
//            ?.run {
//                println("结果: $this")
//            }
        Bmap.androidMapSDK
            .libs[3]
            .types
            .forEach {
                println("${it.name} constructable: ${it.constructable}")
            }
//
//        iosSDK
//            .libs[1]
//            .types
//            .find { it.name == "AMapNearbySearchManager" }
//            ?.constructable
//            ?.run {
//                println("结果: $this")
//            }
    }

    @Test
    fun BMKMapPoint_Test() {
        Bmap.androidMapSDK
            .libs[3]
            .types
            .forEach {
                println("${it.name} constructable: ${it.constructable}")
            }
    }

    @Test
    fun constructable_amap_AMapNaviDriveManager() {
        Amap.iosMapSDK
            .allTypes
            .find { it.name == "AMapNaviDriveManager" }
            ?.run {
                println("结果: ${constructable}")
            }
    }

    @Test
    fun constructable_amap_track_com_amap_api_track_query_model_QueryTerminalRequest() {
        Amap.androidTrackSDK
            .allTypes
            .find { it.name == "com.amap.api.track.query.model.QueryTerminalRequest" }
            ?.run {
                println("结果: $constructable")
            }
    }

    @Test
    fun filterConstructable_amap() {
        Amap.iosMapSDK
            .allTypes
            .filterConstructable()
            .map { it.name }
            .run {
                println("结果: ${contains("AMapNaviDriveManager")}")
            }
    }

    @Test
    fun firstConcretSubtype() {
//        iosMapSDK
//            .libs[1]
//            .types
//            .find { it.name == "MAAnnotation" }
//            ?.firstConcretSubtype()
//            ?.run {
//                println("结果: $this")
//            }
        Tmap.androidSDK
            .allTypes
            .find { it.name == "com.tencent.tencentmap.mapsdk.maps.model.IOverlay" }
            ?.firstConcretSubtype
            ?.run {
                println("结果: $this")
            } ?: println("没有子类")
    }

    @Test
    fun hasSubtype() {
//        iosMapSDK
//            .libs[1]
//            .types
//            .find { it.name == "MAAnnotation" }
//            ?.firstConcretSubtype()
//            ?.run {
//                println("结果: $this")
//            }
        BaiduAsr.androidAsrSDK
            .libs[1]
            .types
            .find { it.name == "com.baidu.speech.EventManager" }
            ?.subtypes
            ?.run {
                println("结果: ${this.joinToString { it.name }}")
            }
    }

    @Test
    fun ancestorTypes() {
//        iosMapSDK
//            .libs[1]
//            .types
//            .find { it.name == "MAAnnotation" }
//            ?.firstConcretSubtype()
//            ?.run {
//                println("结果: $this")
//            }
        Amap.iosMapSDK
            .libs[0]
            .types
            .find { it.name == "MAGroundOverlay" }
            ?.ancestorTypes
            ?.run {
                println("结果: $this")
            }
    }

    @Test
    fun isView_tmap_QMapView() {
        Tmap.iosSDK
            .allTypes
            .find { it.name == "QMapView" && it.typeType == TypeType.Class }
            ?.isView
            ?.run {
                println("结果: $this")
            }
    }

    @Test
    fun isView_ali_rtc_SophonSurfaceView() {
        AliRtc.androidSDK
            .allTypes
            .find { it.name == "org.webrtc.sdk.SophonSurfaceView" }
            ?.isView
            ?.run {
                println("结果: $this")
            }
    }

    @Test
    fun constructable_ali_rtc_org_webrtc_ali_RTCStatsReport() {
        AliRtc.androidSDK
            .allTypes
            .find { it.name == "org.webrtc.ali.RTCStatsReport" }
            ?.run {
                println("结果: $constructable")
            }
    }

    @Test
    fun baoqu() {
        ext.ios.exclude.classes = listOf(
            "[BU|bu].*",
            "SD.*",
            "Pangle.*"
        )
        CmGame.iosSDK
            .allTypes
            .find { it.name == "bu_safe_dispatch_sync_main_queue" }
            ?.run {
                println("结果: $filter")
            }
    }

    @Test
    fun locationClient() {
        Bmap.androidMapSDK
            .allTypes
            .find { it.name == "com.baidu.location.LocationClient" }
            ?.run {
                println("结果: ${TypeSdkTmpl(this)}")
            }
    }

    @Test
    fun MACircle() {
        Amap.iosMapSDK
            .allTypes
            .find { it.name == "MACircle" }
            ?.run {
                println("结果: ${TypeSdkTmpl(this)}")
            }
    }

    @Test
    fun amap_AMapGeoFenceCircleRegion() {
        Amap.iosLocationSDK
            .allTypes
            .find { it.name == "AMapGeoFenceRegion" }
            ?.run {
                println("结果: ${filter}")
            }
    }

    @Test
    fun pangolin_ios_BUNativeAd() {
        Pangolin.iosSDK
            .allTypes
            .find { it.name == "BUNativeAd" }
//            ?.methods
//            ?.find { it.name.contains("registerContainer") }
            ?.run {
                println("结果: ${TypeSdkTmpl(this)}")
            }
    }

    @Test
    fun tencent_live_TRTCCloudDelegate() {
        ext.ios.exclude.classes = listOf("TRTCMediaDeviceType")
        TencentLive.iosSDK
            .allTypes
            .find { it.name == "TRTCCloudDelegate" }
            ?.methods
            ?.find { it.name.contains("onDevice") }
            ?.run {
                println("结果 ${nameWithClass()}: ${filter}")
            }
    }

    @Test
    fun tencent_live_TXAudioEffectManager() {
        TencentLive.iosSDK
            .allTypes
            .find { it.name == "TXAudioEffectManager" }
            ?.methods
            ?.find { it.name.contains("init") }
            ?.run {
                println("结果 $isPublic")
            }
    }
}