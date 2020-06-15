package me.yohom.fluttify.tmpl.dart.type.type_interface

import me.yohom.fluttify.FluttifyCorePlugin
import me.yohom.fluttify.FluttifyTest
import me.yohom.fluttify.Nim
import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.getResource
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class TypeInterfaceTmplKtTest : FluttifyTest() {

    @Test
    fun typeInterfaceTmpl() {
        Nim.androidSDK
            .allTypes
            .find { it.name == "com.netease.nimlib.sdk.InvocationFuture" }
            ?.run {
                println(TypeInterfaceTmpl(this))
            }
    }
}