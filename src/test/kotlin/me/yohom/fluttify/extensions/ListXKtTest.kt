package me.yohom.fluttify.extensions

import me.yohom.fluttify.Amap
import me.yohom.fluttify.FluttifyTest
import me.yohom.fluttify.Nim
import me.yohom.fluttify.Tmap
import me.yohom.fluttify.model.Field
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.SDK
import me.yohom.fluttify.model.Variable
import me.yohom.fluttify.tmpl.dart.type.type_interface.TypeInterfaceTmpl
import org.apache.commons.io.FileUtils
import org.apache.commons.io.filefilter.FalseFileFilter
import org.apache.commons.io.filefilter.SuffixFileFilter
import org.apache.commons.io.filefilter.TrueFileFilter
import org.apache.commons.io.filefilter.WildcardFileFilter
import org.junit.jupiter.api.Test

class ListXKtTest : FluttifyTest() {

    @Test
    fun filterMethod() {
        // 如果含有通配符, 那么从通配符开始查找目标framework
        val subPath = "**/NIMSDK.framework".substringBefore("**/")
        val frameworkName = "**/NIMSDK.framework".substringAfter("**/")
        val result = FileUtils.iterateFilesAndDirs(
            "/Users/yohom/Github/Me/All/fluttify/3rd_party/nim/sdk/ios/$subPath".file(),
            FalseFileFilter.INSTANCE,
            TrueFileFilter.INSTANCE
        )
            .asSequence()
            .find { it.name.endsWith(frameworkName) }
            ?.path!!
        println(result)

//        listOf(Field(true, true, true, "", Variable("", "", Platform.Android), "", platform = Platform.Android)).filterConstants()
//        Amap.androidSearchSDK.libs[1]
//            .types.apply { println("types:$this") }
//            .find { it.name == "com.amap.api.services.poisearch.PoiResult" }
//            ?.methods
//            ?.apply { println("before:$this") }
//            ?.filterMethod()
//            ?.apply { println("after:$this") }

//        val sdk = "/Users/yohom/Github/Me/All/fluttify/3rd.party/xftts/jr/xftts.fluttify.ios.json"
//            .file()
//            .readText()
//            .fromJson<SDK>()
//
//        sdk.libs
//            .flatMap { it.types }
//            .find { it.name == "IFlySpeechRecognizerDelegate" }
//            ?.methods
//            ?.apply { println("before:$this") }
//            ?.filterMethod()
//            ?.apply { println("after:$this") }
    }

    @Test
    fun filterGetters() {
//        Amap.iosSearchSDK.libs[1]
//            .types.apply { println("types:$this") }
//            .find { it.name == "AMapPOISearchResponse" }
//            ?.fields
//            ?.apply { println("before:$this") }
//            ?.filterGetters()
//            ?.apply { println("after:$this") }
        Tmap.androidSDK
            .allTypes
            .find { it.name == "com.tencent.tencentmap.mapsdk.maps.model.CamerParameter" }
            ?.fields
            ?.apply { println("before:$this") }
            ?.filterGetters()
            ?.apply { println("after:$this") }
    }

    @Test
    fun filterType() {
    }

    @Test
    fun filterSetters() {
    }

    @Test
    fun NIMSDK_filterType() {
        Nim.iosSDK.allTypes.find { it.name == "NIMSDK" }?.run { println(filter) }
    }

    @Test
    fun NIMSDK_filterMethod() {
        Nim.androidSDK.allTypes
            .find { it.name == "com.netease.nimlib.sdk.InvocationFuture" }
            ?.methods
            ?.find { it.name == "setCallback" }
            ?.run { println(filter) }
    }

    @Test
    fun AmapNavi_filterMethod() {
        Amap.androidMapSDK.allTypes
            .find { it.name == "com.amap.api.navi.AMapNaviListener" }
            ?.run {
                println(TypeInterfaceTmpl(this))
            }
//        Amap.androidMapSDK.allTypes
//            .find { it.name == "com.amap.api.navi.AMapNaviListener" }
//            ?.methods
//            ?.filter { it.name == "OnUpdateTrafficFacility" }
//            ?.forEach { println("${it.nameWithClass()}: ${it.filter}") }
    }

    @Test
    fun isList() {
        val result0 = "List".isIterable()
        println("List is: $result0")
        val result1 = "List<Object>".isIterable()
        println("List<Object> is: $result1")
        val result2 = "NSArray".isIterable()
        println("NSArray is: $result2")
        val result3 = "NSArray*".isIterable()
        println("NSArray* is: $result3")
    }
}