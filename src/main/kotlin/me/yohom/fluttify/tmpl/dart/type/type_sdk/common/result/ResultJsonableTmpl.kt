package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

//result
class ResultJsonableTmpl {
    private val tmpl = this::class.java.getResource("/tmpl/dart/result_jsonable.stmt.dart.tmpl").readText()

    fun dartResultJsonable(): String {
        return tmpl
    }
}