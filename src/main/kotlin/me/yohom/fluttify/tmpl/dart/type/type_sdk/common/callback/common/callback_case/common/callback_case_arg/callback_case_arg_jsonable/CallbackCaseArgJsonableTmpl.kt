package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_jsonable

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.model.Parameter

//args['#__arg_name__#']
class CallbackCaseArgJsonableTmpl(private val param: Parameter) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/callback_case_arg_jsonable.stmt.dart.tmpl").readText()

    fun dartCallbackCaseArgJsonable(): String {
        return tmpl
            .replace("#__arg_name__#", param.variable.name.depointer())
    }
}