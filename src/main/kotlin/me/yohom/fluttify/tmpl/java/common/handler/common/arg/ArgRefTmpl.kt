package me.yohom.fluttify.tmpl.java.common.handler.common.arg

import me.yohom.fluttify.model.Variable

//// ref arg
//#__type_name__# #__arg_name__# = (#__type_name__#) HEAP.get((int) args.get("#__arg_name__#"));
internal class ArgRefTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/java/arg_ref.stmt.java.tmpl").readText()

    fun javaArgRef(): String {
        return tmpl
            .replace("#__type_name__#", variable.typeName)
            .replace("#__arg_name__#", variable.name)

    }
}