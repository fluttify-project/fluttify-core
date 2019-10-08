package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.toDartType

//#__type_name__#()..refId = result
class ResultRefTmpl(private val returnType: TYPE_NAME) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/result_ref.stmt.dart.tmpl").readText()

    fun dartResultRef(): String {
        return tmpl
            .replace("#__type_name__#", returnType.toDartType())
    }
}