package me.yohom.fluttify.tmpl.java.common.handler.handler_method

import me.yohom.fluttify.FluttifyTest
import me.yohom.fluttify.Tim
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class HandlerMethodTmplKtTest : FluttifyTest() {

    @Test
    fun handlerMethodTmpl_tim_com_tencent_imsdk_common_ICallback_done() {
        Tim.androidSDK
            .allTypes
            .find { it.name == "com.tencent.imsdk.common.ICallback" }
            ?.methods
            ?.find { it.name == "done" }
            ?.run {
                println(HandlerMethodTmpl(this))
//                Assert.assertTrue(this.isCallback)
            }
    }
}