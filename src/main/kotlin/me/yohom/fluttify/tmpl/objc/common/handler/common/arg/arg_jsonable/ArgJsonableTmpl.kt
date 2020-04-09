package me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_jsonable

import me.yohom.fluttify.SYSTEM_TYPEDEF
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Variable

//// jsonable参数
//#__type_name__# #__arg_name__# = #__right_value__#;
private val tmpl = getResource("/tmpl/objc/arg_jsonable.stmt.m.tmpl").readText()

fun ArgJsonableTmpl(variable: Variable): String {
    val typeName = when {
        variable.typeName.isValueType() -> variable.typeName.depointer()
        variable.isIterable -> variable.typeName
        else -> variable.typeName.enpointer()
    }
    val rightValue = if (variable.typeName.isValueType() || variable.isAliasType()) {
        var methodPrefix = (SYSTEM_TYPEDEF[variable.typeName]
            ?: variable.typeName.findType().aliasOf
            ?: variable.typeName)
            .depointer()
            .toLowerCase()
            .removePrefix("ns")
            .removePrefix("cg")
        if (variable.typeName == "NSUInteger" || variable.typeName.findType().aliasOf == "NSUInteger") {
            methodPrefix = "unsignedInteger"
        }
        if (variable.typeName == "long long") {
            methodPrefix = "longLongInteger"
        }
        if (variable.typeName == "uint32_t") {
            methodPrefix = "unsignedInt"
        }
        if (variable.typeName == "int32_t") {
            methodPrefix = "int"
        }
        if (variable.typeName == "int64_t") {
            methodPrefix = "longLongInteger"
        }
        "[args[@\"${variable.name.depointer()}\"] ${methodPrefix}Value]"
    } else {
        "($typeName) args[@\"${variable.name.depointer()}\"]"
    }
    val argName = variable.name.depointer()

    return tmpl
        .replace("#__type_name__#", typeName)
        .replace("#__right_value__#", rightValue)
        .replace("#__arg_name__#", argName)
}