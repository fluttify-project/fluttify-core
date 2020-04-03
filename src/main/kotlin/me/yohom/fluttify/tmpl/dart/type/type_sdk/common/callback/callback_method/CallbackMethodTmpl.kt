package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.callback_method

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.callback_case_delegate.CallbackCaseDelegateTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case.callback_case_lambda.CallbackCaseLambdaTmpl

//MethodChannel('#__callback_channel__#')
//    .setMethodCallHandler((methodCall) async {
//      final args = methodCall.arguments as Map;
//      // final refId = args['callerRefId'] as int;
//      // if (refId != this.refId) return;
//
//      switch (methodCall.method) {
//        #__cases__#
//        default:
//          break;
//      }
//    });
private val tmpl = getResource("/tmpl/dart/callback.stmt.dart.tmpl").readText()

fun CallbackMethodTmpl(callerMethod: Method): String {
    // 如果方法参数中没有回调类型的参数, 那么直接返回空字符串
    if (callerMethod
            .formalParams
            .none { it.variable.typeName.findType().run { isCallback() || isLambda() } }
    )
        return ""

    val callbackDelegates = callerMethod.formalParams
        .filter { it.variable.typeName.findType().isCallback() }
    val callbackLambdas = callerMethod.formalParams
        .filter { it.variable.typeName.findType().isLambda() }

    // 如果是View类型的类, 那么就加上当前的View代表的id
    // 因为objc端的delegate方法无法区分调用方, 所以只有view类型的类能根据viewId区分
    val callbackChannel = if (callerMethod.className.findType().isView()) {
        "${callerMethod.nameWithClass()}::Callback@\$refId"
    } else {
        "${callerMethod.nameWithClass()}::Callback"
    }

    val callbackDelegateCases = callbackDelegates
        .map { param ->
            param
                .variable
                .typeName
                .findType()
                .methods
                .filterMethod()
                // 回调的方法要过滤掉参数含有`没有子类的抽象类`参数的方法
                .filter { it.must("形参类型是具体类型或者含有子类的抽象类") { formalParams.all { it.variable.hasConcretSubtype() } } }
                .joinToString("\n") {
                    CallbackCaseDelegateTmpl(it, param.variable.name)
                }
        }
    // 形参里的lambda类型参数
    val callbackLambdaCases = callbackLambdas
        .map { CallbackCaseLambdaTmpl(it) }

    return tmpl
        .replace("#__callback_channel__#", callbackChannel)
        .replaceParagraph("#__cases__#", callbackDelegateCases.union(callbackLambdaCases).joinToString("\n"))
}