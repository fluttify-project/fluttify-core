package me.yohom.fluttify.tmpl.java.common.handler.handler_getter

import me.yohom.fluttify.FluttifyTest
import me.yohom.fluttify.Nim
import me.yohom.fluttify.tmpl.dart.type.type_sdk.method.MethodTmpl
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class HandlerGetterTmplKtTest : FluttifyTest() {

    @Test
    fun handlerGetterTmpl() {
        Nim.androidSDK
            .allTypes
            .find { it.name == "com.netease.nimlib.sdk.chatroom.model.ChatRoomStatusChangeData" }
            ?.fields
            ?.find { it.variable.name == "status" }
            ?.run { println(HandlerGetterTmpl(this)) }
    }
}