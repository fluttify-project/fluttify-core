package me.yohom.fluttify.tmpl.kotlin.common.handler.common.result.result_list

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.underscore2Camel

//for (val item in result) {
//    HEAP_#__plugin_name__#[item.hashCode()] = item
//}
//
//methodResult.success(result.map { it.hashCode() })
internal class ResultListTmpl {

    private val tmpl = this::class.java.getResource("/tmpl/kotlin/result_list.stmt.kt.tmpl").readText()

    fun kotlinListResult(): String {
        return tmpl.replace("#__plugin_name__#", ext.outputProjectName.underscore2Camel(true))
    }

}