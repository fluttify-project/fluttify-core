package me.yohom.fluttify.tmpl.objc.common.handler.handler_method

import me.yohom.fluttify.FluttifyTest
import me.yohom.fluttify.Tim
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class HandlerMethodTmplKtTest : FluttifyTest() {

    @Test
    fun handlerMethodTmpl() {
        Tim.iosSDK
            .allTypes
            .find { it.name == "V2TIMManager" }
            ?.methods
            ?.find { it.name == "createGroup" }
            ?.run {
                println(HandlerMethodTmpl(this))
            }
    }
}