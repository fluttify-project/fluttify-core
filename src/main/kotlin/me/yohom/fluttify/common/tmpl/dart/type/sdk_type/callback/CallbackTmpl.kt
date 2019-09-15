package me.yohom.fluttify.common.tmpl.dart.type.sdk_type.callback

import me.yohom.fluttify.common.extensions.findType
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.model.Method

//MethodChannel('#__callback_channel__#' + refId.toString())
//    .setMethodCallHandler((methodCall) async {
//      final args = methodCall.arguments as Map;
//      final refId = args['callerRefId'] as int;
//      if (refId != this.refId) return;
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
class CallbackTmpl(private val callerMethod: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/type/sdk_type/callback.stmt.dart.tmpl").readText()

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

        val className = "${callerMethod.className}::${callerMethod.name}_Callback"
        val callbackDelegateCases = callbackDelegates
            .map { param ->
                val callbackMethods = param.variable.typeName.findType().methods
                callbackMethods.joinToString("\n") {
                    CallbackDelegateCaseTmpl(callerMethod, it, param.variable.name).callbackCase()
                }
            }
        val callbackLambdaCases = callbackLambdas
            .map { CallbackLambdaCaseTmpl(callerMethod, it).callbackCase() }

        return tmpl
            .replace("#__callback_channel__#", className)
            .replaceParagraph("#__cases__#", callbackDelegateCases.union(callbackLambdaCases).joinToString("\n"))
    }
}