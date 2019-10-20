package me.yohom.fluttify.tmpl.kotlin.common.handler.common.result.result_ref

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.underscore2Camel

//val returnRefId = result.hashCode()
//HEAP_#__plugin_name__#[returnRefId] = result
//
//methodResult.success(returnRefId)
internal class ResultRefTmpl {

    private val tmpl = this::class.java.getResource("/tmpl/kotlin/result_ref.stmt.kt.tmpl").readText()

    fun kotlinRefResult(): String {
        return tmpl.replace("#__plugin_name__#", ext.outputProjectName.underscore2Camel(true))
    }

}