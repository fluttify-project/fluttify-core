package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_list

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Parameter

//(args['#__arg_name__#'] as List).cast<Ref>().map((__it__) => TypeOp#__plugin_name__##__platform__#(__it__).as__<#__arg_type_name__#>()).toList()
private val tmpl by lazy { getResource("/tmpl/dart/callback_case_arg_list.stmt.dart.tmpl").readText() }

fun CallbackCaseArgListTmpl(param: Parameter): String {
    return tmpl
        .replace("#__arg_name__#", param.variable.name.depointer())
        .replace("#__arg_type_name__#", param
            .variable
            .trueType
            .run {
                if (param.variable.getIterableLevel() == 0) {
                    param.platform.objectType()
                } else {
                    genericTypes()[0].toDartType()
                }
            })
        .replace("#__plugin_name__#", ext.projectName.underscore2Camel())
        .replace("#__platform__#", param.platform.name.capitalize())
}