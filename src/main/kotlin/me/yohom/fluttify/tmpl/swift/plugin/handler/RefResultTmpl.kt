package me.yohom.fluttify.tmpl.swift.plugin.handler

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.jsonable

//let returnRefId = result.hashCode()
//REF_MAP[returnRefId] = result
//
//methodResult(returnRefId)
internal class RefResultTmpl(val returnType: TYPE_NAME) {

    private val tmpl = this::class.java.getResource("/tmpl/swift/ref_result.stmt.swift.tmpl").readText()

    fun swiftRefResult(): String {
        return when {
            returnType == "void" -> "methodResult(\"success\")"
            returnType.jsonable() -> "methodResult(result)"
            else -> tmpl
        }
    }

}