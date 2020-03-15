package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.genericType
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.isCollection
import me.yohom.fluttify.extensions.toDartType

//#__type_name__#.values[result]
private val tmpl = getResource("/tmpl/dart/result_enum.stmt.dart.tmpl").readText()

fun ResultEnumTmpl(returnType: TYPE_NAME): String {
    val enumResult = tmpl.replace("#__type_name__#", returnType.toDartType().genericType())
    return if (returnType.isCollection()) {
        "(result as List).cast<int>().map((result) => $enumResult)"
    } else {
        enumResult
    }
}