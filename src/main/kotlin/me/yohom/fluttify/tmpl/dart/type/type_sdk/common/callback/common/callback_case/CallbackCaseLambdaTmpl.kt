package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case

import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.jsonable
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Parameter

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
class CallbackCaseLambdaTmpl(
    private val callerMethod: Method,
    private val lambdaParam: Parameter
) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/callback_case.stmt.dart.tmpl").readText()

    fun callbackCase(): String {
        val callbackCase = "${callerMethod.className}::${callerMethod.name}_Callback::${lambdaParam.variable.name}"
        val log = ""
        val callbackHandler = lambdaParam.variable.name
        val callbackArgs = lambdaParam.variable.typeName.findType().formalParams
            .joinToString {
                if (it.variable.typeName.jsonable()) {
                    "args['${it.variable.name}']"
                } else {
                    "${it.variable.typeName.toDartType()}()..refId = (args['${it.variable.name}'])"
                }
            }

        return tmpl
            .replace("#__callback_case__#", callbackCase)
            .replace("#__log__#", log)
            .replace("#__callback_handler__#", callbackHandler)
            .replace("#__callback_args__#", callbackArgs)
    }
}