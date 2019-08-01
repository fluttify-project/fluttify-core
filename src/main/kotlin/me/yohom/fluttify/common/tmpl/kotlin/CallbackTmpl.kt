package me.yohom.fluttify.common.tmpl.kotlin

import me.yohom.fluttify.common.model.Variable

//val #__arg_name__# = #__type_name__#.values()[args["#__arg_name__#"] as Int]
class CallbackTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/callback.stmt.kt.tmpl").readText()

    fun kotlinArgEnum(): String {
        return tmpl
            .replace("#__type_name__#", variable.typeName)
            .replace("#__arg_name__#", variable.name)
    }
}