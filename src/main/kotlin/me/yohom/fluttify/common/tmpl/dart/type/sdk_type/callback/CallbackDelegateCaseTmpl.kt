package me.yohom.fluttify.common.tmpl.dart.type.sdk_type.callback

import me.yohom.fluttify.common.extensions.jsonable
import me.yohom.fluttify.common.extensions.toDartType
import me.yohom.fluttify.common.model.Method

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
 * 回调Delegate的一个case
 */
class CallbackDelegateCaseTmpl(
    private val callerMethod: Method,
    private val callbackMethod: Method,
    private val callbackObject: String
) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/type/sdk_type/callback_case.stmt.dart.tmpl").readText()

    fun callbackCase(): String {
        val callbackCase = "${callerMethod.className}::${callerMethod.name}_Callback::${callbackMethod.name}"
        val log =
            "print('fluttify-dart-callback: ${callerMethod.className}::${callerMethod.name}_${callbackMethod.name}(${callbackMethod.formalParams.filter { it.variable.typeName.jsonable() }.map { "\\'${it.variable.name}\\':\$args[${it.variable.name}]" }})');"
        val callbackHandler = "${callbackObject}.${callbackMethod.name}"
        val callbackArgs = callbackMethod.formalParams
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