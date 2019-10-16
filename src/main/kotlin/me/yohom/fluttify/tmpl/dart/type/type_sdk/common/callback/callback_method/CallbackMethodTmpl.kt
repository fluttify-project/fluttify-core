package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.callback_method

import me.yohom.fluttify.extensions.filterMethod
import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.must
import me.yohom.fluttify.extensions.replaceParagraph
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
/**
 * 回调代码
 */
class CallbackMethodTmpl(private val callerMethod: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/callback.stmt.dart.tmpl").readText()

    fun callback(): String {
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

        val callbackChannel = "${callerMethod.nameWithClass()}::Callback"
        val callbackDelegateCases = callbackDelegates
            .map { param ->
                param
                    .variable
                    .typeName
                    .findType()
                    .methods
                    .filterMethod()
                    // 回调的方法要过滤掉参数含有`没有子类的抽象类`参数的方法
                    .filter { it.must("形参类型是具体类型或者含有子类的抽象类") { formalParams.all { it.variable.run { isConcret() || hasSubtype() } } } }
                    .joinToString("\n") {
                        CallbackCaseDelegateTmpl(it, param.variable.name).dartCallbackDelegateCase()
                    }
            }
        val callbackLambdaCases = callbackLambdas
            .map { CallbackCaseLambdaTmpl(callerMethod, it).callbackCase() }

        return tmpl
            .replace("#__callback_channel__#", callbackChannel)
            .replaceParagraph("#__cases__#", callbackDelegateCases.union(callbackLambdaCases).joinToString("\n"))
    }
}