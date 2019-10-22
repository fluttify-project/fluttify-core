package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_list

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Parameter

//(args['#__arg_name__#'] as List).cast<int>().map((it) => #__arg_type_name__#()..refId = it).toList()
class CallbackCaseArgListTmpl(private val param: Parameter) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/callback_case_arg_list.stmt.dart.tmpl").readText()

    fun dartCallbackCaseArgList(): String {
        return tmpl
            .replace("#__arg_name__#", param.variable.name.depointer())
            .replace("#__arg_type_name__#", param
                .variable
                .typeName
                .run { if (param.variable.genericLevel == 0) {
                    param.platform.objectType()
                } else {
                    this
                } }
                .toDartType())
    }
}