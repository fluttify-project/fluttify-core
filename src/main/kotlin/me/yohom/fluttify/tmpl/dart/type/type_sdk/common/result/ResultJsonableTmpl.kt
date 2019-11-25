package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.result

import me.yohom.fluttify.extensions.dearray
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Variable

//result
class ResultJsonableTmpl(val returnType: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/result_jsonable.stmt.dart.tmpl").readText()

    fun dartResultJsonable(): String {
        return if (returnType.isList)
            "(result as List).cast<${returnType.typeName.dearray().toDartType()}>()"
        else
            "result"
    }
}