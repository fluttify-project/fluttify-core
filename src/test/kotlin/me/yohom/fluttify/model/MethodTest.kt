package me.yohom.fluttify.model

import me.yohom.fluttify.AliyunShortVideo
import me.yohom.fluttify.Amap
import me.yohom.fluttify.FluttifyTest
import me.yohom.fluttify.Tim
import me.yohom.fluttify.tmpl.java.common.handler.handler_method.HandlerMethodTmpl
import org.junit.jupiter.api.Test

class MethodTest: FluttifyTest() {

    @Test
    fun filter() {
        Tim.iosSDK
            .libs
            .flatMap { it.types }
            .find { it.name == "TIMGroupManager" }
            ?.methods
            ?.find { it.signature == "modifyGroupCustomInfo_customInfo_succ_fail" }
            ?.filter
            ?.run {
                println("通过过滤: $this")
            }
    }

    @Test
    fun amap_map_filter_mapView_regionDidChangeAnimated_wasUserAction() {
        Amap.iosMapSDK
            .allTypes
            .find { it.name == "MAMapViewDelegate" }
            ?.methods
            ?.filter { it.filter }
            ?.run {
                println(joinToString("\n") { "${it.nameWithClass()} 通过过滤: ${it.filter}" })
            }
    }

    @Test
    fun aliyun_OnChoosePictureSizeCallBack() {
        AliyunShortVideo.androidSDK
            .allTypes
            .find { it.name == "com.aliyun.recorder.supply.AliyunIRecorder" }
            ?.methods
            ?.find { it.name == "setOnChoosePictureSizeCallBack" }
            ?.run {
                println(HandlerMethodTmpl(this))
            }
    }
}