package me.yohom.fluttify.tmpl.java.common.handler.common.arg

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//// ref arg
//Integer __refId__ = (Integer) ((Map<String, Object>) __args__).get("#__arg_name__#");
//#__type_name__# #__arg_name__# = __refId__ != null ? (#__type_name__#) getHEAP().get(__refId__) : null;
private val tmpl by lazy { getResource("/tmpl/java/arg_ref.stmt.java.tmpl").readText() }

fun ArgRefTmpl(variable: Variable): String {
    return tmpl
        .replace("#__type_name__#", variable.trueType.replace("$", "."))
        .replace("#__arg_name__#", variable.name)
}