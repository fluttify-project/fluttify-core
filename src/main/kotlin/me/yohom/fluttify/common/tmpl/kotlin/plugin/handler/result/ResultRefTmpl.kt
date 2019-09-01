package me.yohom.fluttify.common.tmpl.kotlin.plugin.handler.result

import me.yohom.fluttify.common.TYPE_NAME
import me.yohom.fluttify.common.extensions.jsonable

//val returnRefId = result.hashCode()
//REF_MAP[returnRefId] = result
//
//methodResult.success(returnRefId)
internal class ResultRefTmpl(val returnType: TYPE_NAME) {

    private val tmpl = this::class.java.getResource("val returnRefId = result.hashCode()\nREF_MAP[returnRefId] = result\n\nmethodResult.success(returnRefId)").readText()

    fun kotlinRefResult(): String {
        return when {
            returnType == "void" -> "methodResult.success(\"success\")"
            returnType.jsonable() -> "methodResult.success(result)"
            else -> tmpl
        }
    }

}