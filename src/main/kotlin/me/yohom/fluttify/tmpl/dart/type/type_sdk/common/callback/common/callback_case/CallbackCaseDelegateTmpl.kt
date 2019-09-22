package me.yohom.fluttify.tmpl.dart.type.type_sdk.common.callback.common.callback_case

import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.jsonable
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Method

//case '#__callback_case__#':
//  // 日志打印
//  #__log__#
//
//    // 调用回调方法
//  #__callback_handler__#(#__callback_args__#);
//  break;
/**
 * 回调Delegate的一个case
 */
class CallbackCaseDelegateTmpl(
    private val callbackMethod: Method,
    private val callbackObject: String
) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/callback_case.stmt.dart.tmpl").readText()

    fun dartCallbackDelegateCase(): String {
        val callbackMethodName =
            "${callbackMethod.name}${callbackMethod.formalParams.joinToString("") { it.named }.capitalize()}"

        val callbackCase = "Callback::${callbackMethod.className}::${callbackMethodName}"
        val log =
            "print('fluttify-dart-callback: ${callbackMethodName}(${callbackMethod.formalParams.filter { it.variable.typeName.jsonable() }.map { "\\'${it.variable.name}\\':\$args[${it.variable.name}]" }})');"
        val callbackHandler = "${callbackObject}?.${callbackMethodName}"
        val callbackArgs = callbackMethod.formalParams
            .joinToString {
                when {
                    it.variable.typeName.jsonable() -> "args['${it.variable.name}']"
                    it.variable.isList -> "[]" // 列表暂时不处理
                    it.variable.typeName.findType().isInterface() -> "${it.variable.typeName.toDartType()}_Ref()..refId = (args['${it.variable.name}'])"
                    it.variable.typeName.findType().isEnum() -> "${it.variable.typeName.toDartType()}.values[(args['${it.variable.name}'])]"
                    else -> "${it.variable.typeName.toDartType()}()..refId = (args['${it.variable.name}'])"
                }
            }

        return tmpl
            .replace("#__callback_case__#", callbackCase)
            .replace("#__log__#", log)
            .replace("#__callback_handler__#", callbackHandler)
            .replace("#__callback_args__#", callbackArgs)
    }
}