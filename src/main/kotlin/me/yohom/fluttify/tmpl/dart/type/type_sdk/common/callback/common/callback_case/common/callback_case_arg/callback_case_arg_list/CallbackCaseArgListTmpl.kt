package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_list

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Parameter

//(args['#__arg_name__#'] as List)?.map((it) => #__project_prefix__##__platform__#As(it))?.toList()
private val tmpl by lazy { getResource("/tmpl/dart/callback_case_arg_list.stmt.dart.tmpl").readText() }

fun CallbackCaseArgListTmpl(param: Parameter): String {
    return tmpl
        .replace("#__arg_name__#", param.variable.name.depointer())
        .replace("#__type_name__#", param
            .variable
            .trueType
            .run {
                if (param.variable.getIterableLevel() == 0) {
                    param.platform.objectType()
                } else {
                    genericTypes()[0].toDartType()
                }
            })
        .replaceGlobal(param.platform)
}