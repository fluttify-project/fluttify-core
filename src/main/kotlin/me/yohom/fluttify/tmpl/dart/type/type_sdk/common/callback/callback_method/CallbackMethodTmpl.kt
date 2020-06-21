package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.callback_method

import me.yohom.fluttify.extensions.filterMethod
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.mustNot
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.callback_case_delegate.CallbackCaseDelegateTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.callback_case_lambda.CallbackCaseLambdaTmpl

//MethodChannel('#__callback_channel__#')
//    .setMethodCallHandler((methodCall) async {
//      final args = methodCall.arguments as Map;
//      switch (methodCall.method) {
//        #__cases__#
//        default:
//          break;
//      }
//    });
private val tmpl by lazy { getResource("/tmpl/dart/callback.stmt.dart.tmpl").readText() }

fun CallbackMethodTmpl(callbackType: Type, callbackObject: String): String {
    // 如果是View类型的类, 那么就加上当前的View代表的id
    // 如果参数的回调是lambda类型, 那么也不加入viewid, 因为不需要
    // 因为objc端的delegate方法无法区分调用方, 所以只有view类型的类能根据viewId区分
    val isView = callbackType.isView
    val callbackChannel = if (isView) {
        "${callbackType.name}::Callback@\$refId"
    } else {
        "${callbackType.name}::Callback"
    }

    val callbackCases = if (callbackType.isLambda) {
        CallbackCaseLambdaTmpl(callbackType, callbackObject)
    } else {
        callbackType
            .methods
            .filterMethod()
            // 回调的方法要过滤掉参数含有`回调类`参数的方法
            .filter { it.mustNot("参数含有回调类") { formalParams.any { it.variable.isCallback() } } }
            .joinToString("\n") { CallbackCaseDelegateTmpl(it, callbackObject) }
    }

    return tmpl
        .replace("#__callback_channel__#", callbackChannel)
        .replaceParagraph("#__cases__#", callbackCases)
}