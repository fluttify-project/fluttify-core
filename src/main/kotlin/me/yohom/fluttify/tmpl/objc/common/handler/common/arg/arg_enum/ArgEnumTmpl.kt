package me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_enum

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//// 枚举参数
//#__type_name__# #__arg_name__# = (#__type_name__#) [args[@"#__arg_name__#"] integerValue];
private val tmpl = getResource("/tmpl/objc/arg_enum.stmt.m.tmpl").readText()

fun ArgEnumTmpl(variable: Variable): String {
    val typeName = variable.typeName
    val name = variable.name

    return tmpl
        .replace("#__type_name__#", typeName)
        .replace("#__arg_name__#", name)
}