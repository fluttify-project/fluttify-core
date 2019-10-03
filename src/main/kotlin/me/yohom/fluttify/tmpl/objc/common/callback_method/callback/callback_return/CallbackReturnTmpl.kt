package me.yohom.fluttify.tmpl.objc.common.callback_method.callback.callback_return

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
//return nil;
/**
 * 带有返回值的回调方法, 目前都是空实现
 */
internal class CallbackReturnTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/callback_return.stmt.m.tmpl").readText()

    fun objcCallbackReturn(): String {
        return tmpl
//            .replace("#__callback_result_type__#", method.returnType.run { if (findType().isStruct()) "NSValue*" else this })
//            .replace(
//                "#__callback_method__#",
//                "Callback::${method.className}::${method.name}${method.formalParams.joinToString("") { it.named }.capitalize()}"
//            )
//            .replace(
//                "#__callback_args__#",
//                method.formalParams.joinToString {
//                    when {
//                        it.variable.isStruct() -> "@\"${it.variable.name}\": @(${StructToNSValueTmpl(it.variable).objcStructToNSValue()}.hash)"
//                        it.variable.isRefType() -> "@\"${it.variable.name}\": @(${it.variable.name}.hash)"
//                        else -> "@\"${it.variable.name}\": @(${it.variable.name})"
//                    }
//                }
//            )
//            .replaceParagraph("#__raw_callback_result__#", method.returnType.run {
//                when {
//                    jsonable() -> CallbackReturnJsonableTmpl(method).objcReturnJsonable()
//                    findType().isRefType() -> CallbackReturnRefTmpl(method).objcReturnRef()
//                    findType().isStruct() -> CallbackReturnStructTmpl(method).objcReturnStruct()
//                    else -> this
//                }
//            })
//            .replace(
//                "#__struct_value__#", if (method.returnType.findType().isStruct())
//                    NSValueToStructTmpl(method.returnType, "_callbackResult").objcNSValueToStruct()
//                else
//                    ""
//            )
//            .replace(
//                "#__callback_result__#",
//                if (method.returnType.findType().isStruct()) "_structValue" else "_callbackResult"
//            )
    }
}