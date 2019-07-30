package me.yohom.fluttify.common.tmpl.kotlin

import me.yohom.fluttify.common.model.Variable

//val #__arg_name__# = REF_MAP[args["#__arg_name__#"] as Int] as #__type_name__#
class ArgRefTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/arg_ref.stmt.kt.tmpl").readText()

    fun kotlinArgRef(): String {
        return tmpl
            .replace("#__type_name__#", variable.typeName)
            .replace("#__arg_name__#", variable.name)
    }
}