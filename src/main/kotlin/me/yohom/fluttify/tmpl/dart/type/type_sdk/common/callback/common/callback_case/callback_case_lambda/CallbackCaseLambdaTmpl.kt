package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.callback_case_lambda

import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.model.Parameter
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_enum.CallbackCaseArgEnumTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_jsonable.CallbackCaseArgJsonableTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_list.CallbackCaseArgListTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.common.callback_case_arg.callback_case_arg_ref.CallbackCaseArgRefTmpl

//case '#__callback_case__#':
//  if (#__callback_handler__# != null) {
//    // 日志打印
//    #__log__#
//
//    // 调用回调方法
//    #__callback_handler__#(#__callback_args__#);
//  }
//  break;
/**
 * 回调case
 */
class CallbackCaseLambdaTmpl(private val lambdaParam: Parameter) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/callback_case.stmt.dart.tmpl").readText()

    fun callbackCase(): String {
        val callbackCase = "Callback::${lambdaParam.variable.typeName.replace("$", ".")}::${lambdaParam.variable.typeName}"
        val log = ""
        val callbackHandler = lambdaParam.variable.name
        val callbackArgs = lambdaParam
            .variable
            .typeName
            .findType()
            .formalParams
            .joinToString {
                when {
                    it.variable.jsonable() -> CallbackCaseArgJsonableTmpl(it).dartCallbackCaseArgJsonable()
                    it.variable.isList -> CallbackCaseArgListTmpl(it).dartCallbackCaseArgList()
                    it.variable.isEnum() -> CallbackCaseArgEnumTmpl(it).dartCallbackCaseArgEnum()
                    else -> CallbackCaseArgRefTmpl(it).dartCallbackCaseArgRef()
                }
            }

        return tmpl
            .replace("#__callback_case__#", callbackCase)
            .replace("#__log__#", log)
            .replace("#__callback_handler__#", callbackHandler)
            .replace("#__callback_args__#", callbackArgs)
    }
}