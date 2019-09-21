package me.yohom.fluttify.common.tmpl.kotlin.common.handler.arg

import me.yohom.fluttify.common.extensions.toKotlinType
import me.yohom.fluttify.common.model.Variable

//// jsonable参数
//val #__arg_name__# = args["#__arg_name__#"] as #__type_name__#
internal class ArgJsonableTmpl(private val variable: Variable) {
    private val tmpl =
        this::class.java.getResource("/tmpl/kotlin/arg_jsonable.stmt.kt.tmpl").readText()

    fun kotlinArgJsonable(): String {
        val kotlinType = variable.typeName.toKotlinType().run { if (this == "Float") "Double" else this }
        return tmpl
            .replace(
                "#__type_name__#",
                if (variable.isList) "List<${kotlinType}>" else kotlinType
            )
            .replace("#__arg_name__#", variable.name)
    }
}