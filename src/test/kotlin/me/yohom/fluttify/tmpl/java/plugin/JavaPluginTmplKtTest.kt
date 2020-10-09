package me.yohom.fluttify.tmpl.java.plugin

import me.yohom.fluttify.Amap
import me.yohom.fluttify.FluttifyTest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class JavaPluginTmplKtTest : FluttifyTest() {

    @Test
    fun javaPluginTmpl() {
        println(JavaPluginTmpl(Amap.androidMapSDK.directLibs, "/Users/yohom/Github/Me/All/fluttify/amap/amap_map_fluttify/output-project/amap_map_fluttify/android/src/main/java/me/yohom/amap_map_fluttify/sub_handler"))
    }
}