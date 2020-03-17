package me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_ref

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Variable

//// ref arg
//#__type_name__# #__arg_name__# = (#__type_name__#) HEAP[@([args[@"#__arg_name__#"] integerValue])];
private val tmpl = getResource("/tmpl/objc/arg_ref.stmt.m.tmpl").readText()

fun ArgRefTmpl(variable: Variable): String {
    val typeName = when {
        variable.typeName == "id" -> variable.typeName
        variable.typeName.isPrimitivePointerType() -> "NSValue*"
        variable.typeName.findType().isInterface() -> variable.typeName.deprotocol().enprotocol()
        else -> variable.typeName.enpointer()
    }
    val argName = variable.name.depointer()
    return tmpl
        .replace("#__type_name__#", typeName)
        .replace("#__arg_name__#", argName)
}