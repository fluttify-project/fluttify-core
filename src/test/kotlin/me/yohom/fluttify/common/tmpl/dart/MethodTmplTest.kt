package me.yohom.fluttify.common.tmpl.dart

import me.yohom.fluttify.common.model.Method
import me.yohom.fluttify.common.model.Parameter
import me.yohom.fluttify.common.model.Variable
import me.yohom.fluttify.common.tmpl.dart.clazz.MethodTmpl
import org.junit.Test


internal class MethodTmplTest {

    @Test
    fun dartMethod() {
        val testMethod = Method(
            "String",
            "test",
            listOf(Parameter(variable = Variable("String", "var"))),
            false,
            false,
            true,
            "Test"
        )
        val dartMethodString = MethodTmpl(testMethod).dartMethod()
        println(dartMethodString)
    }
}