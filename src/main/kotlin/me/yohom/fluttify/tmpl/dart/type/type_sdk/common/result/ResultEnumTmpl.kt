package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.*

//(#__var__# as int).to#__type_name__#()
private val tmpl by lazy { getResource("/tmpl/dart/result_enum.stmt.dart.tmpl").readText() }

fun ResultEnumTmpl(returnType: TYPE_NAME): String {
    val enumResult = if (returnType.isEnumList()) {
        tmpl
            .replace("#__var__#", "__it__")
            .replace("#__type_name__#", returnType.genericTypes()[0].toDartType())
    } else {
        tmpl
            .replace("#__var__#", "__result__")
            .replace("#__type_name__#", returnType.toDartType())
    }
    return if (returnType.isIterable()) {
        "(__result__ as List).cast<int>().map((__it__) => $enumResult).toList()"
    } else {
        enumResult
    }
}