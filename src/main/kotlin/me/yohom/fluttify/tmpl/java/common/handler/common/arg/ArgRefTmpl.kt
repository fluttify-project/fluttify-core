package me.yohom.fluttify.tmpl.java.common.handler.common.arg

import me.yohom.fluttify.model.Variable

//// 引用参数
//val #__arg_name__# = HEAP[args["#__arg_name__#"] as Int] as #__type_name__#
internal class ArgRefTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/arg_ref.stmt.kt.tmpl").readText()

    fun kotlinArgRef(): String {
        return tmpl
            .replace("#__type_name__#", variable.typeName)
            .replace("#__arg_name__#", variable.name)

    }
}