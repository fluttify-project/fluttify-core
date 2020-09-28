package me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_list.arg_list_ref

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Variable

//// list arg
//NSArray<#__type_name__#>* #__arg_name__# = (NSArray<#__type_name__#>*) args[@"#__arg_name__#"];
private val tmpl by lazy { getResource("/tmpl/objc/arg_list_ref.stmt.m.tmpl").readText() }

fun ArgListRefTmpl(variable: Variable): String {
    val typeName = if (variable.trueType.genericTypes().isEmpty()) {
        "NSObject*"
    } else {
        variable.trueType.genericTypes()[0]
    }
    val argName = variable.name.depointer()
    return tmpl
        .replace("#__type_name__#", typeName)
        .replace("#__arg_name__#", argName)
}