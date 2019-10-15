package me.yohom.fluttify

import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.fromJson
import me.yohom.fluttify.model.SDK

val androidSearchSDK = "/Users/yohom/Github/Me/All/fluttify/amap_search_fluttify/ir/android/json_representation.json".file().readText().fromJson<SDK>()
val iosSearchSDK = "/Users/yohom/Github/Me/All/fluttify/amap_search_fluttify/ir/ios/json_representation.json".file().readText().fromJson<SDK>()

val androidMapSDK = "/Users/yohom/Github/Me/All/fluttify/amap_map_fluttify/ir/android/json_representation.json".file().readText().fromJson<SDK>()
val iosMapSDK = "/Users/yohom/Github/Me/All/fluttify/amap_map_fluttify/ir/ios/json_representation.json".file().readText().fromJson<SDK>()

val androidNaviSDK = "/Users/yohom/Github/Me/All/fluttify/amap_navi_fluttify/ir/android/json_representation.json".file().readText().fromJson<SDK>()
val iosSearchNaviSDK = "/Users/yohom/Github/Me/All/fluttify/amap_navi_fluttify/ir/ios/json_representation.json".file().readText().fromJson<SDK>()
val ext = FluttifyExtension().apply { outputOrg = "me.yohom"; outputProjectName = "amap_base_flutter" }