package me.yohom.fluttify.tmpl.kotlin.common.handler.common.arg

import me.yohom.fluttify.model.Variable

//// 列表参数
//val #__arg_name__# = (args["#__arg_name__#"] as List<Int>).map { REF_MAP[it] as #__type_name__# }
internal class ArgListTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/arg_list.stmt.kt.tmpl").readText()

    fun kotlinArgList(): String {
        return tmpl
            .replace("#__type_name__#", variable.typeName)
            .replace("#__arg_name__#", variable.name)
    }
}