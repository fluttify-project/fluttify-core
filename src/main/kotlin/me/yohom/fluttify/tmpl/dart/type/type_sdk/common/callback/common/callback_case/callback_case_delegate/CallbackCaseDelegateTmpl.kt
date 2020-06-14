package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.callback_case_delegate

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_enum.CallbackCaseArgEnumTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_jsonable.CallbackCaseArgJsonableTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_list.CallbackCaseArgListTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_ref.CallbackCaseArgRefTmpl

//case '#__callback_case__#':
//  // 日志打印
//  #__log__#
//
//    // 调用回调方法
//  #__callback_handler__#(#__callback_args__#);
//  break;
private val tmpl by lazy { getResource("/tmpl/dart/callback_case.stmt.dart.tmpl").readText() }

fun CallbackCaseDelegateTmpl(callbackMethod: Method, callbackObject: String): String {
    val callbackMethodName = callbackMethod.signature
    val callbackCase = "Callback::${callbackMethod.nameWithClass()}"
    val log =
        "debugPrint('fluttify-dart-callback: ${callbackMethodName}(${callbackMethod.formalParams.filter { it.variable.trueType.jsonable() }
            .map { "\\'${it.variable.name}\\':\${args['${it.variable.name}']}" }})');"
    val callbackHandler = "${callbackObject}?.${callbackMethodName}"
    val callbackArgs = callbackMethod.formalParams
        .joinToString {
            when {
//                // TODO 这里的逻辑有问题 判断是否的Ref根本没用 回调过来肯定都是int(refId)或者jsonable的
//                it.variable.trueType.toDartType() == "dynamic" -> "args[\"${it.variable.name}\"] is Ref ? ${CallbackCaseArgRefTmpl(it)} : ${CallbackCaseArgJsonableTmpl(it)}"
//                it.variable.trueType in callbackMethod.className.findType().declaredGenericTypes -> "args[\"${it.variable.name}\"].as__<${it.variable.trueType}>()"
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