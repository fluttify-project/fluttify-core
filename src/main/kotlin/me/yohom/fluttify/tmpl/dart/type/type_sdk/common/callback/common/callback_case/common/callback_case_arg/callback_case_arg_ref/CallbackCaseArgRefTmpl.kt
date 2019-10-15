package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_ref

import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Parameter

//#__arg_type_name__#()..refId = (args['#__arg_name__#'])
class CallbackCaseArgRefTmpl(private val param: Parameter) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/callback_case_arg_ref.stmt.dart.tmpl").readText()

    fun dartCallbackCaseArgRef(): String {
        return tmpl
            .replace("#__arg_type_name__#", param
                .variable
                .typeName
                .findType()
                .run { firstConcretSubtype()?.name ?: name }
                .toDartType())
            .replace("#__arg_name__#", param.variable.name)
    }
}