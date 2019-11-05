package me.yohom.fluttify.tmpl.java.common.handler.common.arg

import me.yohom.fluttify.model.Variable

//// jsonable arg
//#__type_name__# #__arg_name__# = (#__type_name__#) args.get("#__arg_name__#");
internal class ArgJsonableTmpl(private val variable: Variable) {
    private val tmpl =
        this::class.java.getResource("/tmpl/java/arg_jsonable.stmt.java.tmpl").readText()

    fun kotlinArgJsonable(): String {
        val type = variable.typeName.run { if (this == "Float") "Double" else this }
        return tmpl
            .replace(
                "#__type_name__#",
                if (variable.isList) "List<${type}>" else type
            )
            .replace("#__arg_name__#", variable.name)
    }
}