package me.yohom.fluttify.common.tmpl.kotlin.plugin

import me.yohom.fluttify.ext
import me.yohom.fluttify.sdk
import org.junit.Test

class PluginTmplTest {

    @Test
    fun kotlinPlugin() {
        PluginTmpl(sdk.libs[0], ext).kotlinPlugin().run { print(this) }
    }
}