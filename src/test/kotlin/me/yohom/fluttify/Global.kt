package me.yohom.fluttify

import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.fromJson
import me.yohom.fluttify.extensions.parseSDK
import me.yohom.fluttify.model.SDK

object Amap {
    val androidSearchSDK = "/Users/yohom/Github/Me/All/fluttify/amap/amap_search_fluttify/jr/android/json_representation.json".file().readText().fromJson<SDK>()
    val iosSearchSDK = "/Users/yohom/Github/Me/All/fluttify/amap/amap_search_fluttify/jr/ios/json_representation.json".file().readText().fromJson<SDK>()

    val androidMapSDK = "/Users/yohom/Github/Me/All/fluttify/amap/amap_map_fluttify/jr/amap_map_fluttify.android.json".file().readText().fromJson<SDK>()
    val iosMapSDK = "/Users/yohom/Github/Me/All/fluttify/amap/amap_map_fluttify/jr/amap_map_fluttify.ios.json".file().readText().fromJson<SDK>()

    val androidLocationSDK = "/Users/yohom/Github/Me/All/fluttify/amap/amap_location_fluttify/jr/android/json_representation.json".file().readText().fromJson<SDK>()
    val iosLocationSDK = "/Users/yohom/Github/Me/All/fluttify/amap/amap_location_fluttify/jr/ios/json_representation.json".file().readText().fromJson<SDK>()

    val androidNaviSDK = "/Users/yohom/Github/Me/All/fluttify/amap/amap_navi_fluttify/jr/android/json_representation.json".file().readText().fromJson<SDK>()
    val iosSearchNaviSDK = "/Users/yohom/Github/Me/All/fluttify/amap/amap_navi_fluttify/jr/ios/json_representation.json".file().readText().fromJson<SDK>()
}

object Bmap {
    val androidSearchSDK = "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_search_fluttify/jr/android/json_representation.json".file().readText().fromJson<SDK>()
    val iosSearchSDK = "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_search_fluttify/jr/ios/json_representation.json".file().readText().fromJson<SDK>()

    val androidMapSDK = "/Users/yohom/Github/Me/All/fluttify/baidu_map/bmap_map_fluttify/jr/bmap_map_fluttify.android.json".file().readText().fromJson<SDK>()
    val iosMapSDK = "/Users/yohom/Github/Me/All/fluttify/baidu_map/bmap_map_fluttify/jr/bmap_map_fluttify.ios.json".file().readText().fromJson<SDK>()

    val androidLocationSDK = "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_location_fluttify/jr/android/json_representation.json".file().readText().fromJson<SDK>()
    val iosLocationSDK = "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_location_fluttify/jr/ios/json_representation.json".file().readText().fromJson<SDK>()

    val androidNaviSDK = "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_navi_fluttify/jr/android/json_representation.json".file().readText().fromJson<SDK>()
    val iosSearchNaviSDK = "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_navi_fluttify/jr/ios/json_representation.json".file().readText().fromJson<SDK>()
}

object BaiduAsr {
    val androidAsrSDK = "/Users/yohom/Github/Me/All/fluttify/3rd_party/baidu_asr/jr/baidu_asr_fluttify.android.json".file().readText().fromJson<SDK>()

}

object TencentLive {
    val androidSDK = "/Users/yohom/Github/Me/All/fluttify/3rd_party/tencent_live/jr/tencent_live_fluttify.android.json".file().readText().fromJson<SDK>()

}

object Tim {
    val androidSDK = "/Users/yohom/Github/Me/All/fluttify/tim/jr/tim_fluttify.android.json".file().readText().fromJson<SDK>()
    val iosSDK = "/Users/yohom/Github/Me/All/fluttify/tim/jr/tim_fluttify.ios.json".file().readText().fromJson<SDK>()
}

object Tmap {
    val androidSDK = "/Users/yohom/Github/Me/All/fluttify/3rd_party/tencent_map/jr/tmap_map_fluttify.android.json".file().readText().fromJson<SDK>()
    val iosSDK = "/Users/yohom/Github/Me/All/fluttify/3rd_party/tencent_map/jr/tmap_map_fluttify.ios.json".file().readText().fromJson<SDK>()
}

object NeteaseLive {
    val androidSDK = "/Users/yohom/Github/Me/All/fluttify/3rd_party/netease_live/jr/netease_live_fluttify.android.json".file().readText().fromJson<SDK>()
    val iosSDK = "/Users/yohom/Github/Me/All/fluttify/3rd_party/netease_live/jr/netease_live_fluttify.ios.json".file().readText().fromJson<SDK>()
}

object Nim {
    val androidSDK = "/Users/yohom/Github/Me/All/fluttify/3rd_party/nim/jr/nim_fluttify.android.json".file().readText().fromJson<SDK>()
    val iosSDK = "/Users/yohom/Github/Me/All/fluttify/3rd_party/nim/jr/nim_fluttify.ios.json".file().readText().fromJson<SDK>()
}

object EaseMob {
    val androidSDK = "/Users/yohom/Github/Me/All/fluttify/3rd_party/easemob_im/jr/easemob_im_fluttify.android.json".file().readText().fromJson<SDK>()
    val iosSDK = "/Users/yohom/Github/Me/All/fluttify/3rd_party/easemob_im/jr/easemob_im_fluttify.ios.json".file().readText().fromJson<SDK>()
}

object AliRtc {
    val androidSDK = "/Users/yohom/Github/Me/All/fluttify/3rd_party/ali_rtc_fluttify/jr/ali_rtc_fluttify.android.json".file().readText().parseSDK()
    val iosSDK = "/Users/yohom/Github/Me/All/fluttify/3rd_party/ali_rtc_fluttify/jr/ali_rtc_fluttify.ios.json".file().readText().parseSDK()
}

object CmGame {
    val androidSDK = "/Users/yohom/Github/Me/All/fluttify/3rd_party/baoqu/jr/cm_game_fluttify.android.json".file().readText().parseSDK()
    val iosSDK = "/Users/yohom/Github/Me/All/fluttify/3rd_party/baoqu/jr/cm_game_fluttify.ios.json".file().readText().parseSDK()
}

