package me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_jsonable

import me.yohom.fluttify.SYSTEM_TYPEDEF
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Variable

//// jsonable参数
//#__type_name__# #__arg_name__# = #__right_value__#;
private val tmpl = getResource("/tmpl/objc/arg_jsonable.stmt.m.tmpl").readText()

fun ArgJsonableTmpl(variable: Variable): String {
    val typeName = variable.trueType
    val rightValue = if (variable.trueType.isValueType() || variable.isAliasType()) {
        var methodPrefix = (SYSTEM_TYPEDEF[variable.trueType]
            ?: variable.trueType.findType().aliasOf
            ?: variable.trueType)
            .depointer()
            .toLowerCase()
            .removePrefix("ns")
            .removePrefix("cg")
        if (variable.trueType == "NSUInteger"
            ||
            variable.trueType.findType().aliasOf == "NSUInteger"
            ||
            variable.trueType == "GLuint"
        ) {
            methodPrefix = "unsignedInteger"
        }
        if (variable.trueType == "long long") {
            methodPrefix = "longLongInteger"
        }
        if (variable.trueType == "uint32_t") {
            methodPrefix = "unsignedInt"
        }
        if (variable.trueType == "int32_t") {
            methodPrefix = "int"
        }
        if (variable.trueType == "int64_t") {
            methodPrefix = "longLongInteger"
        }
        if (variable.trueType == "uint64_t") {
            methodPrefix = "unsignedLongLong"
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