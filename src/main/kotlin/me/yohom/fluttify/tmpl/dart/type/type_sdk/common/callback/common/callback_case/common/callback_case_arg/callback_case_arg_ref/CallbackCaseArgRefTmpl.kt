package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_ref

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Parameter

//(#__arg_type_name__#()..refId = (args['#__arg_name__#'])..tag__ = '#__plugin_name__#')
private val tmpl by lazy { getResource("/tmpl/dart/callback_case_arg_ref.stmt.dart.tmpl").readText() }

fun CallbackCaseArgRefTmpl(param: Parameter): String {
    return tmpl
        .replace("#__arg_type_name__#", param
            .variable
            .trueType
            .findType()
            .run {
                when {
                    name.toDartType() == "dynamic" -> "Ref"
                    isInterface -> "${name.toDartType()}.subInstance"
                    else -> name.toDartType()
                }
            })
        .replace("#__arg_name__#", param.variable.name.depointer())
        .replace("#__plugin_name__#", ext.projectName)
}