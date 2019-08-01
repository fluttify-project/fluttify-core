package me.yohom.fluttify.common.tmpl.kotlin.plugin

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.file
import me.yohom.fluttify.common.extensions.fromJson
import me.yohom.fluttify.common.model.SDK
import org.junit.Test

class PluginTmplTest {

    @Test
    fun kotlinPlugin() {
        val sdk = "/Users/yohom/Github/Util/Kotlin/fluttify-core/src/test/resources/ir/android/json_representation.json".file().readText().fromJson<SDK>()
        PluginTmpl(
            sdk.libs[0],
            FluttifyExtension().apply { outputOrg = "me.yohom"; outputProjectName = "baidu_map_flutter" }
        ).kotlinPlugin().run { print(this) }
    }
}