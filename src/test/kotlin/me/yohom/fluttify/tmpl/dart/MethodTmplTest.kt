package me.yohom.fluttify.tmpl.dart

import me.yohom.fluttify.FluttifyTest
import me.yohom.fluttify.Nim
import me.yohom.fluttify.SYSTEM_TYPE
import me.yohom.fluttify.tmpl.dart.type.type_sdk.method.MethodTmpl
import org.junit.jupiter.api.Test


class MethodTmplTest : FluttifyTest() {

    @Test
    fun dartMethod() {
//        Nim.androidSDK
//            .allTypes
//            .find { it.name == "com.netease.nimlib.sdk.InvocationFuture" }
//            ?.methods
//            ?.filter { it.filter }
//            ?.run { println("过滤结果: $this") }

        println(SYSTEM_TYPE.find { it.name == "android.view.SurfaceHolder.Callback" }?.isCallback)
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

    @Test
    fun methodTmpl_nim_NIMLoginManager_addDelegate() {
        Nim.iosSDK
            .allTypes
            .find { it.name == "NIMLoginManager" }
            ?.methods
            ?.find { it.name == "addDelegate" }
            ?.run { println(MethodTmpl(this)) }
    }
}