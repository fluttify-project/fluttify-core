package me.yohom.fluttify.tmpl.kotlin.common.handler.common.arg

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.underscore2Camel
import me.yohom.fluttify.model.Variable

//// 列表参数
//val #__arg_name__# = (args["#__arg_name__#"] as List<Int>).map { HEAP_#__plugin_name__#[it] as #__type_name__# }
internal class ArgListTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/arg_list.stmt.kt.tmpl").readText()

    fun kotlinArgList(): String {
        return if (variable.genericLevel <= 1) {
            tmpl
                .replace("#__type_name__#", variable.typeName)
                .replace("#__arg_name__#", variable.name)
                .replace("#__plugin_name__#", ext.outputProjectName.underscore2Camel(true))
        } else {
            var typeName = variable.typeName
            for (i in 0 until (variable.genericLevel - 1)) {
                typeName = "List<$typeName>"
            }
            "val ${variable.name} = listOf<$typeName>()"
        }
    }
}