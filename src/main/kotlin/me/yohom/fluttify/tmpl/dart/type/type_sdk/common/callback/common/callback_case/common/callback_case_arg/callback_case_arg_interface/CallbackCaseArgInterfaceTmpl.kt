package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_interface

import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Parameter

//#__arg_type_name__#_Ref()..refId = (args['#__arg_name__#'])
class CallbackCaseArgInterfaceTmpl(private val param: Parameter) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/callback_case_arg_interface.stmt.dart.tmpl").readText()

    fun dartCallbackCaseArgInterface(): String {
        return tmpl
            .replace("#__arg_type_name__#", param.variable.typeName.toDartType())
            .replace("#__arg_name__#", param.variable.name)
    }
}