package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.callback_method

import me.yohom.fluttify.extensions.filterMethod
import me.yohom.fluttify.extensions.findType
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
 *
 * todo 如果回调参数中有抽象类型, 那么sdk中必定有它的子类, 不然native端如何实例化? 所以之类可以直接选一个子类进行refId的保存
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
                    .distinctBy { it.nameWithClass() }
                    .filter { it.formalParams.none { it.variable.typeName.findType().isAbstract } }
                    .joinToString("\n") {
                        CallbackCaseDelegateTmpl(
                            it,
                            param.variable.name
                        ).dartCallbackDelegateCase()
                    }
            }
        val callbackLambdaCases = callbackLambdas
            .map { CallbackCaseLambdaTmpl(
                callerMethod,
                it
            ).callbackCase() }

        return tmpl
            .replace("#__callback_channel__#", callbackChannel)
            .replaceParagraph("#__cases__#", callbackDelegateCases.union(callbackLambdaCases).joinToString("\n"))
    }
}