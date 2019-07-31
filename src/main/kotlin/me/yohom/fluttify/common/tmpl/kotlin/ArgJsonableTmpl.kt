package me.yohom.fluttify.common.tmpl.kotlin

import me.yohom.fluttify.common.model.Variable

//val #__arg_name__# = args["#__arg_name__#"] as #__type_name__#
class ArgJsonableTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/arg_jsonable.stmt.kt.tmpl").readText()

    fun kotlinArgJsonable(): String {
        return tmpl
            .replace("#__type_name__#", variable.typeName.capitalize().replace("[]", "Array"))
            .replace("#__arg_name__#", variable.name)
    }
}