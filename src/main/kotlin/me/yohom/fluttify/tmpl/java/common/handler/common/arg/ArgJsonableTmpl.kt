package me.yohom.fluttify.tmpl.java.common.handler.common.arg

import me.yohom.fluttify.extensions.enlist
import me.yohom.fluttify.model.Variable

//// jsonable arg
//#__type_name__# #__arg_name__# = (#__type_name__#) args.get("#__arg_name__#");
internal class ArgJsonableTmpl(private val variable: Variable) {
    private val tmpl =
        this::class.java.getResource("/tmpl/java/arg_jsonable.stmt.java.tmpl").readText()

    fun kotlinArgJsonable(): String {
        val type = variable.typeName.run { if (toLowerCase() == "float") "Double" else this }
        return tmpl
            .replace("#__type_name__#", if (variable.isList) type.enlist() else type)
            .replace("#__arg_name__#", variable.name)
    }
}