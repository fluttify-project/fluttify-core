package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.callback_case_lambda

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Type
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

fun CallbackCaseLambdaTmpl(lambdaType: Type, lambdaName: String): String {
    val callbackCase = "Callback::${lambdaType.name.replace("$", ".")}::${lambdaType.name}"
    val log =
        "debugPrint('fluttify-dart-callback: ${lambdaName}(${lambdaType.formalParams.map { "\\'${it.variable.name}\\':\${args['${it.variable.name}']}" }})');"
    val callbackArgs = lambdaType
        .formalParams
        .joinToString {
            when {
                it.variable.isVoid() || it.variable.jsonable() -> CallbackCaseArgJsonableTmpl(it)
                it.variable.isIterable -> CallbackCaseArgListTmpl(it)
                it.variable.isEnum() -> CallbackCaseArgEnumTmpl(it)
                else -> CallbackCaseArgRefTmpl(it)
            }
        }

    return tmpl
        .replace("#__callback_case__#", callbackCase)
        .replace("#__log__#", log)
        .replace("#__callback_handler__#", lambdaName)
        .replace("#__callback_args__#", callbackArgs)
}