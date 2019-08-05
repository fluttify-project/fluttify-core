package me.yohom.fluttify.common.tmpl.swift.plugin.handlemethod

import me.yohom.fluttify.common.TYPE_NAME
import me.yohom.fluttify.common.extensions.jsonable

//val returnRefId = result.hashCode()
//REF_MAP[returnRefId] = result
//
//methodResult.success(returnRefId)
class RefResultTmpl(val returnType: TYPE_NAME) {

    private val tmpl = this::class.java.getResource("/tmpl/swift/ref_result.stmt.swift.tmpl").readText()

    fun kotlinRefResult(): String {
        return when {
            returnType == "void" -> "methodResult.success(\"success\")"
            returnType.jsonable() -> "methodResult.success(result)"
            else -> tmpl
        }
    }

}