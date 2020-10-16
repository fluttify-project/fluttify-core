package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Platform

//__result__.runtimeType == 'List<#__type_name__#>' ? (__result__ as List)?.cast<#__type_name__#>() : (__result__ as List)?.map((it) => #__project_prefix__##__platform__#As(it, '#__type_name__#')).cast<#__type_name__#>().toList()
private val tmpl by lazy { getResource("/tmpl/dart/result_list.stmt.dart.tmpl").readText() }

fun ResultListTmpl(genericType: TYPE_NAME, platform: Platform): String {
    return tmpl
        .replace("#__type_name__#", genericType.toDartType())
        .replace("#__cast_type__#", genericType.replace("$", "\\$"))
        .replaceGlobal(platform)
}