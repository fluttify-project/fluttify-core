package me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_struct

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//// struct arg
//NSValue* #__arg_name__#Value = (NSValue*) HEAP[@([args[@"#__arg_name__#"] integerValue])];
//#__type_name__# #__arg_name__#;
//[#__arg_name__#Value getValue:&#__arg_name__#];
private val tmpl = getResource("/tmpl/objc/arg_struct.stmt.m.tmpl").readText()

fun ArgStructTmpl(variable: Variable): String {
    val typeName = if (variable.isIterable) "NSArray<${variable.typeName}>" else variable.typeName
    val argName = variable.name
    return tmpl
        .replace("#__type_name__#", typeName)
        .replace("#__arg_name__#", argName)
}