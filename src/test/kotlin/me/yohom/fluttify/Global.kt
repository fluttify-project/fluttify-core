package me.yohom.fluttify

import me.yohom.fluttify.extensions.file
import me.yohom.fluttify.extensions.fromJson
import me.yohom.fluttify.model.SDK

val androidSDK = "/Users/yohom/Github/Util/Kotlin/amap_search_fluttify/ir/android/json_representation.json".file().readText().fromJson<SDK>()
val iosSDK = "/Users/yohom/Github/Util/Kotlin/amap_search_fluttify/ir/ios/json_representation.json".file().readText().fromJson<SDK>()
val ext = FluttifyExtension().apply { outputOrg = "me.yohom"; outputProjectName = "amap_base_flutter" }