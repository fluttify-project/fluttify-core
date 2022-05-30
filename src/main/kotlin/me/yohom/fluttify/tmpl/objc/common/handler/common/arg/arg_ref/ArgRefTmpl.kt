package me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_ref

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Variable

//// ref arg
//#__type_name__# #__arg_name__# = (#__type_name__#) (args[@"#__arg_name__#"] == [NSNull null] ? nil : args[@"#__arg_name__#"]);
private val tmpl by lazy { getResource("/tmpl/objc/arg_ref.stmt.m.tmpl").readText() }

fun ArgRefTmpl(variable: Variable): String {
    val typeName = when {
        variable.trueType.isPrimitivePointerType() -> "NSValue*"
        // 多级指针缩减为一级指针, 然后在变量上加&
        variable.trueType.isMultiPointer() -> variable.trueType.replace("**", "*")
        else -> variable.trueType
    }
    val argName = variable.name
    return tmpl
        .replace("#__type_name__#", typeName)
        .replace("#__arg_name__#", argName)
}