package me.yohom.fluttify.common.tmpl.kotlin.plugin.handlemethod

import me.yohom.fluttify.common.TYPE_NAME
import me.yohom.fluttify.common.extensions.jsonable

//val returnRefId = result.hashCode()
//REF_MAP[returnRefId] = result
//
//methodResult.success(returnRefId)
internal class RefResultTmpl(val returnType: TYPE_NAME) {

    private val tmpl = this::class.java.getResource("/tmpl/kotlin/ref_result.stmt.kt.tmpl").readText()

    fun kotlinRefResult(): String {
        return when {
            returnType == "void" -> "methodResult.success(\"success\")"
            returnType.jsonable() -> "methodResult.success(result)"
            else -> tmpl
        }
    }

}