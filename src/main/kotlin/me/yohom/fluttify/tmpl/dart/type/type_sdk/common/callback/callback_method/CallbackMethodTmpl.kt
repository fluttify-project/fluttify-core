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
            .none { it.variable.trueType.findType().run { isCallback || isLambda } }
    )
        return ""

    val callbackDelegates = callerMethod.formalParams
        .filter { it.variable.trueType.findType().isCallback }
    val callbackLambdas = callerMethod.formalParams
        .filter { it.variable.trueType.findType().isLambda }

    // 如果是View类型的类, 那么就加上当前的View代表的id
    // 如果参数的回调是lambda类型, 那么也不加入viewid, 因为不需要
    // 因为objc端的delegate方法无法区分调用方, 所以只有view类型的类能根据viewId区分
    val isView = callerMethod.className.findType().isView
    val containLambda = callerMethod.formalParams.any { it.variable.isLambda() }
    val callbackChannel = if (isView && !containLambda) {
        "${callerMethod.nameWithClass()}::Callback@\$refId"
    } else {
        "${callerMethod.nameWithClass()}::Callback"
    }

    val callbackDelegateCases = callbackDelegates
        .map { param ->
            param
                .variable
                .trueType
                .findType()
                .methods
                .filterMethod()
                // 回调的方法要过滤掉参数含有`回调类`参数的方法
                .filter {
                    it.must("形参类型是具体类型或者含有子类的抽象类") {
                        formalParams.all {
                            it.variable.jsonable()
                                    ||
                                    it.variable.isConcret()
                                    ||
                                    it.variable.hasConcretSubtype()
                        }
                    }
                }
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