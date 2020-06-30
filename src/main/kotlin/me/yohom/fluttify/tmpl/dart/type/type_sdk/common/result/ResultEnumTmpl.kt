package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.isIterable
import me.yohom.fluttify.extensions.toDartType

//__result__.to#__type_name__#()
private val tmpl by lazy { getResource("/tmpl/dart/result_enum.stmt.dart.tmpl").readText() }

fun ResultEnumTmpl(returnType: TYPE_NAME): String {
    val enumResult = tmpl.replace("#__type_name__#", returnType.toDartType())
    return if (returnType.isIterable()) {
        "(result as List).cast<int>().map((result) => $enumResult)"
    } else {
        enumResult
    }
}