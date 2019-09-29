package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

//result
class ResultVoidTmpl {
    private val tmpl = this::class.java.getResource("/tmpl/dart/result_void.stmt.dart.tmpl").readText()

    fun kotlinResultVoid() = tmpl
}