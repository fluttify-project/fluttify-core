package me.yohom.fluttify

import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.fromJson
import me.yohom.fluttify.model.SDK

object Amap {
    val androidSearchSDK = "/Users/yohom/Github/Me/All/fluttify/amap/amap_search_fluttify/ir/android/json_representation.json".file().readText().fromJson<SDK>()
    val iosSearchSDK = "/Users/yohom/Github/Me/All/fluttify/amap/amap_search_fluttify/ir/ios/json_representation.json".file().readText().fromJson<SDK>()

    val androidMapSDK = "/Users/yohom/Github/Me/All/fluttify/amap/amap_map_fluttify/ir/android/json_representation.json".file().readText().fromJson<SDK>()
    val iosMapSDK = "/Users/yohom/Github/Me/All/fluttify/amap/amap_map_fluttify/ir/ios/json_representation.json".file().readText().fromJson<SDK>()

    val androidLocationSDK = "/Users/yohom/Github/Me/All/fluttify/amap/amap_location_fluttify/ir/android/json_representation.json".file().readText().fromJson<SDK>()
    val iosLocationSDK = "/Users/yohom/Github/Me/All/fluttify/amap/amap_location_fluttify/ir/ios/json_representation.json".file().readText().fromJson<SDK>()

    val androidNaviSDK = "/Users/yohom/Github/Me/All/fluttify/amap/amap_navi_fluttify/ir/android/json_representation.json".file().readText().fromJson<SDK>()
    val iosSearchNaviSDK = "/Users/yohom/Github/Me/All/fluttify/amap/amap_navi_fluttify/ir/ios/json_representation.json".file().readText().fromJson<SDK>()
}

object Bmap {
    val androidSearchSDK = "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_search_fluttify/ir/android/json_representation.json".file().readText().fromJson<SDK>()
    val iosSearchSDK = "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_search_fluttify/ir/ios/json_representation.json".file().readText().fromJson<SDK>()

    val androidMapSDK = "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_map_fluttify/ir/android/json_representation.json".file().readText().fromJson<SDK>()
    val iosMapSDK = "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_map_fluttify/ir/ios/json_representation.json".file().readText().fromJson<SDK>()

    val androidLocationSDK = "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_location_fluttify/ir/android/json_representation.json".file().readText().fromJson<SDK>()
    val iosLocationSDK = "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_location_fluttify/ir/ios/json_representation.json".file().readText().fromJson<SDK>()

    val androidNaviSDK = "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_navi_fluttify/ir/android/json_representation.json".file().readText().fromJson<SDK>()
    val iosSearchNaviSDK = "/Users/yohom/Github/Me/All/fluttify/bmap/bmap_navi_fluttify/ir/ios/json_representation.json".file().readText().fromJson<SDK>()
}

