package me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_ref

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Variable

//// ref arg
//#__type_name__# #__arg_name__# = (#__type_name__#) (args[@"#__arg_name__#"] == [NSNull null] ? nil : args[@"#__arg_name__#"]);
private val tmpl by lazy { getResource("/tmpl/objc/arg_ref.stmt.m.tmpl").readText() }

fun ArgRefTmpl(variable: Variable): String {
    val typeName = if (variable.trueType.isPrimitivePointerType()) "NSValue*" else variable.trueType
    val argName = variable.name
    return tmpl
        .replace("#__type_name__#", typeName)
        .replace("#__arg_name__#", argName)
}