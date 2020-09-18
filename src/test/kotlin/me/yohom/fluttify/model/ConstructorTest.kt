package me.yohom.fluttify.model

import me.yohom.fluttify.*
import me.yohom.fluttify.extensions.filterConstructor
import org.junit.jupiter.api.Test

class ConstructorTest : FluttifyTest() {

    @Test
    fun filter() {
//        Amap.androidMapSDK
//            .libs[3]
//            .types
//            .find { it.name == "com.amap.api.maps.utils.overlay.SmoothMoveMarker" }
//            ?.constructable
//            ?.run {
//                println("结果: $this")
//            }
        TencentLive.androidSDK
            .libs[1]
            .types
            .find { it.name == "com.tencent.rtmp.ui.TXCloudVideoView" }
            ?.constructors
            ?.filterConstructor()
            ?.run {
                println("结果: $this")
            }
    }

    @Test
    fun constructable_com_hyphenate_chat_adapter_EMARHttpCallback() {
        EaseMob.androidSDK
            .libs[2]
            .types
            .find { it.name == "com.hyphenate.chat.adapter.EMARHttpCallback" }
            ?.constructable
            ?.run {
                println("结果: $this")
            }
    }
}