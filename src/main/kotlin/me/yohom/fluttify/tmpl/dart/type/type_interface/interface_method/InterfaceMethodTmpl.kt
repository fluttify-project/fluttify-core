package me.yohom.fluttify.tmpl.dart.type.type_interface.interface_method

import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Method

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