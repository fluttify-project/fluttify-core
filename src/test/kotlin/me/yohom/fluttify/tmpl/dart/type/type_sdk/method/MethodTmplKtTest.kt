package me.yohom.fluttify.tmpl.dart.type.type_sdk.method

import me.yohom.fluttify.FluttifyTest
import me.yohom.fluttify.Nim
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MethodTmplKtTest : FluttifyTest() {

    @Test
    fun methodTmpl_nim_NIMChatManager_addDelegate() {
        Nim.iosSDK
            .allTypes
            .find { it.name == "NIMChatManager" }
            ?.methods
            ?.find { it.name == "addDelegate" }
            ?.run {
                println(MethodTmpl(this))
            }
    }
}