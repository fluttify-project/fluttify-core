package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_ref

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Parameter

//#__project_prefix__##__platform__#As<#__arg_type__#>(args['#__arg_name__#'])
private val tmpl by lazy { getResource("/tmpl/dart/callback_case_arg_ref.stmt.dart.tmpl").readText() }

fun CallbackCaseArgRefTmpl(param: Parameter): String {
    return if (param.variable.trueType.isVoid()) {
        "null"
    } else {
        tmpl
            .replace("#__arg_name__#", param.variable.name.depointer())
            .replace("#__arg_type__#", param.variable.trueType.toDartType())
            .replaceGlobal(param.platform)
    }
}