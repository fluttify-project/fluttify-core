package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.callback_case_delegate

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_enum.CallbackCaseArgEnumTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_jsonable.CallbackCaseArgJsonableTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_list.CallbackCaseArgListTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_ref.CallbackCaseArgRefTmpl

//case '#__callback_case__#':
//  // print log
//  if (fluttifyLogEnabled) {
//    #__log__#
//  }
//
//  // handle the native call
//  #__callback_handler__#(#__callback_args__#);
//  break;
private val tmpl by lazy { getResource("/tmpl/dart/callback_case.stmt.dart.tmpl").readText() }

fun CallbackCaseDelegateTmpl(callbackMethod: Method, callbackObject: String): String {
    val callbackMethodName = callbackMethod.signature
    val callbackCase = "Callback::${callbackMethod.nameWithClass()}"
    val log =
        "debugPrint('fluttify-dart-callback: ${callbackMethodName}(${callbackMethod.formalParams.map { "\\'${it.variable.name}\\':\${args['${it.variable.name}']}" }})');"
    val callbackHandler = "${callbackObject}.${callbackMethodName}"
    val callbackArgs = callbackMethod.formalParams
        .joinToString {
            when {
                it.variable.run { jsonable() || isAliasType() } -> CallbackCaseArgJsonableTmpl(it)
                it.variable.isCollection() -> CallbackCaseArgListTmpl(it)
                it.variable.isEnum() -> CallbackCaseArgEnumTmpl(it)
                else -> CallbackCaseArgRefTmpl(it)
            }
        }

    return tmpl
        .replace("#__callback_case__#", callbackCase)
        .replace("#__log__#", log)
        .replace("#__callback_handler__#", callbackHandler)
        .replace("#__callback_args__#", callbackArgs)
}