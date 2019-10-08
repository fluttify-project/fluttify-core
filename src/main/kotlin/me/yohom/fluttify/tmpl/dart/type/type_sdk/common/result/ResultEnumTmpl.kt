package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.TYPE_NAME

//#__type_name__#.values[result]
class ResultEnumTmpl(private val returnType: TYPE_NAME) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/result_enum.stmt.dart.tmpl").readText()

    fun dartResultEnum(): String {
        return tmpl
            .replace("#__type_name__#", returnType)
    }
}