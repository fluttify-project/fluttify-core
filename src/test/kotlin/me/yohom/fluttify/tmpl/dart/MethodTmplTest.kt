package me.yohom.fluttify.tmpl.dart

import me.yohom.fluttify.FluttifyTest
import me.yohom.fluttify.Nim
import org.junit.jupiter.api.Test


class MethodTmplTest : FluttifyTest() {

    @Test
    fun dartMethod() {
        Nim.androidSDK
            .allTypes
            .find { it.name == "com.netease.nimlib.sdk.InvocationFuture" }
            ?.methods
            ?.filter { it.filter }
            ?.run { println("过滤结果: $this") }
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