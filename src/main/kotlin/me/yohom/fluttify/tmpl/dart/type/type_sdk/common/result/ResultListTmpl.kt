package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*

//(__result__ as List)?.cast<#__type_name__#>()
private val tmpl by lazy { getResource("/tmpl/dart/result_list.stmt.dart.tmpl").readText() }

fun ResultListTmpl(genericType: TYPE_NAME): String {
    return tmpl
        .replace("#__type_name__#", genericType.toDartType())
}