package me.yohom.fluttify.tmpl.dart

import me.yohom.fluttify.NeteaseLive
import org.junit.jupiter.api.Test


internal class MethodTmplTest {

    @Test
    fun dartMethod() {
        NeteaseLive.androidSDK
            .allTypes
            .find { it.name == "com.netease.vcloud.video.render.NeteaseView" }
            ?.ancestorTypes
            ?.run { println("祖先类：$this") }
//        val testMethod = Method(
//            "String",
//            "test",
//            listOf(Parameter(variable = Variable("String", "var"))),
//            false,
//            false,
//            true,
//            "Test"
//        )
//        val dartMethodString = MethodTmpl(testMethod).dartMethod()
//        println(dartMethodString)
    }
}