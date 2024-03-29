package me.yohom.fluttify.tmpl.dart.type.type_interface.interface_method

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method

//Future<#__return_type__#> #__interface_method__#(#__formal_params__#) {}
private val tmpl by lazy { getResource("/tmpl/dart/interface_method.mtd.dart.tmpl").readText() }

fun InterfaceMethodTmpl(method: Method): String {
    val returnType = method.returnType.toDartType().enOptional()
    val name = method.signature
    val formalParams = method.formalParams.joinToString { it.variable.toDartString() }

    return tmpl
        .replace("#__return_type__#", returnType)
        .replace("#__interface_method__#", name)
        .replace("#__formal_params__#", formalParams)
}