package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.replaceGlobal
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Method

//#__project_prefix__##__platform__#As<#__return_type__#>(__result__)
private val tmpl by lazy { getResource("/tmpl/dart/result_ref.stmt.dart.tmpl").readText() }

fun ResultRefTmpl(method: Method): String {
    return tmpl
        .replace("#__return_type__#", method.returnType.toDartType())
        .replaceGlobal(method.platform)
}