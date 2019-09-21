package me.yohom.fluttify.common.tmpl.dart.type.interface_type

import me.yohom.fluttify.common.extensions.toDartType
import me.yohom.fluttify.common.model.Method

//Future<#__return_type__#> #__interface_method__#(#__formal_params__#) {}
class InterfaceMethodTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("/tmpl/dart/interface_method.dart.tmpl").readText()

    fun dartMethod(): String {
        val returnType = method.returnType.toDartType()
        val name = method.name + method.formalParams.joinToString("") { it.named }.capitalize()
        val formalParams = method.formalParams.joinToString { it.variable.toDartString() }

        return tmpl
            .replace("#__return_type__#", returnType)
            .replace("#__interface_method__#", name)
            .replace("#__formal_params__#", formalParams)
    }
}