package me.yohom.fluttify.common.tmpl.kotlin.common.handler.result

import me.yohom.fluttify.common.TYPE_NAME
import me.yohom.fluttify.common.extensions.jsonable

//val returnRefId = result.hashCode()
//REF_MAP[returnRefId] = result
//
//methodResult.success(returnRefId)
internal class ResultRefTmpl(val returnType: TYPE_NAME) {

    private val tmpl = this::class.java.getResource("/tmpl/kotlin/result_ref.stmt.kt.tmpl").readText()

    fun kotlinRefResult(): String {
        return when {
            returnType == "void" -> "methodResult.success(\"success\")"
            returnType.jsonable() -> "methodResult.success(result)"
            else -> tmpl
        }
    }

}