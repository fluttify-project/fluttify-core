package me.yohom.fluttify.tmpl.objc.common.callback_method.callback.callback_return

import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.isCType
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Method

//// __block #__callback_result_type__# _callbackResult = nil;
//// [channel invokeMethod:@"#__callback_method__#"
////             arguments:@{#__callback_args__#}
////                result:^(id result) {
////                  #__raw_callback_result__#
////                }];
////
//// while (_callbackResult == nil) {
////   // _callbackResult有值前, 空转
//// }
////
//// #__struct_value__#
////
//// return #__callback_result__#;
//
//// 由于flutter无法同步调用method channel, 所以暂不支持有返回值的回调方法
//// 相关issue https://github.com/flutter/flutter/issues/28310
//NSLog(@"暂不支持有返回值的回调方法");
//
//#__stub_return__#;
internal class CallbackReturnTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/callback_return.stmt.m.tmpl").readText()

    fun objcCallbackReturn(): String {
//        val callbackResultType = method.returnType.run { if (findType().isStruct()) "NSValue*" else this }
//        val callbackMethod =
//            "Callback::${method.className}::${method.name}${method.formalParams.joinToString("") { it.named }.capitalize()}"
//        val callbackArgs = method.formalParams.joinToString {
//            when {
//                it.variable.isStruct() -> "@\"${it.variable.name}\": @(${StructToNSValueTmpl(it.variable).objcStructToNSValue()}.hash)"
//                it.variable.isRefType() -> "@\"${it.variable.name}\": @(${it.variable.name}.hash)"
//                else -> "@\"${it.variable.name}\": @(${it.variable.name})"
//            }
//        }
//        val rawCallbackResult = method.returnType.run {
//            when {
//                jsonable() -> CallbackReturnJsonableTmpl(method).objcReturnJsonable()
//                findType().isRefType() -> CallbackReturnRefTmpl(method).objcReturnRef()
//                findType().isStruct() -> CallbackReturnStructTmpl(method).objcReturnStruct()
//                else -> this
//            }
//        }
//        val structValue = if (method.returnType.findType().isStruct())
//            NSValueToStructTmpl(method.returnType, "_callbackResult").objcNSValueToStruct()
//        else
//            ""
//        val callbackResult = if (method.returnType.findType().isStruct()) "_structValue" else "_callbackResult"
//
//        return tmpl
//            .replace("#__callback_result_type__#", callbackResultType)
//            .replace("#__callback_method__#", callbackMethod)
//            .replace("#__callback_args__#", callbackArgs)
//            .replaceParagraph("#__raw_callback_result__#", rawCallbackResult)
//            .replace("#__struct_value__#", structValue)
//            .replace("#__callback_result__#", callbackResult)

        val stubReturn = method.returnType.run {
            when {
                isCType() -> "return 0;"
                findType().isStruct() -> "${this} value; return value;"
                else -> "return nil;"
            }
        }

        return tmpl
            .replaceParagraph("__stub_return__", stubReturn)
    }
}