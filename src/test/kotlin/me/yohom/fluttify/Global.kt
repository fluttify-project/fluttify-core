package me.yohom.fluttify

import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.fromJson
import me.yohom.fluttify.model.SDK

val androidSearchSDK = "/Users/yohom/Github/Util/Kotlin/amap_search_fluttify/ir/android/json_representation.json".file().readText().fromJson<SDK>()
val iosSearchSDK = "/Users/yohom/Github/Util/Kotlin/amap_search_fluttify/ir/ios/json_representation.json".file().readText().fromJson<SDK>()

val androidNaviSDK = "/Users/yohom/Github/Util/Kotlin/amap_navi_fluttify/ir/android/json_representation.json".file().readText().fromJson<SDK>()
val iosSearchNaviSDK = "/Users/yohom/Github/Util/Kotlin/amap_navi_fluttify/ir/ios/json_representation.json".file().readText().fromJson<SDK>()
val ext = FluttifyExtension().apply { outputOrg = "me.yohom"; outputProjectName = "amap_base_flutter" }