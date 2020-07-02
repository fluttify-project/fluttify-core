package me.yohom.fluttify.tmpl.java.plugin

import me.yohom.fluttify.Amap
import me.yohom.fluttify.FluttifyTest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class JavaPluginTmplKtTest : FluttifyTest() {

    @Test
    fun javaPluginTmpl() {
        println(JavaPluginTmpl(Amap.androidMapSDK.directLibs, "xxx"))
    }
}