package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_enum

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Parameter

//(args['#__arg_name__#'] as int).to#__arg_type_name__#()
private val tmpl by lazy { getResource("/tmpl/dart/callback_case_arg_enum.stmt.dart.tmpl").readText() }

fun CallbackCaseArgEnumTmpl(param: Parameter): String {
    return tmpl
        .replace("#__arg_type_name__#", param.variable.trueType.toDartType())
        .replace("#__arg_name__#", param.variable.name)
}