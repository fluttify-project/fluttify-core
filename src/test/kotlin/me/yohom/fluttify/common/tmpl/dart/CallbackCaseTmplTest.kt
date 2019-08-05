package me.yohom.fluttify.common.tmpl.dart

import me.yohom.fluttify.common.model.Method
import me.yohom.fluttify.common.tmpl.dart.clazz.CallbackCaseTmpl
import org.junit.Test


internal class CallbackCaseTmplTest {

    @Test
    fun callbackCase() {
        val callerMethod = Method(
            "String",
            "test",
            listOf(),
            false,
            false,
            true,
            "Test"
        )
        val callbackMethod = Method(
            "String",
            "testCallback",
            listOf(),
            false,
            false,
            true,
            "Test"
        )
        val result = CallbackCaseTmpl(callerMethod, callbackMethod).callbackCase()
        println(result)
    }
}