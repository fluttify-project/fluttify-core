package me.yohom.fluttify.common.tmpl.objc.common.delegate_method.callback_return

import me.yohom.fluttify.common.extensions.findType
import me.yohom.fluttify.common.extensions.jsonable
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.model.Method
import me.yohom.fluttify.common.tmpl.objc.common.nsvalue_struct.NSValueToStructTmpl
import me.yohom.fluttify.common.tmpl.objc.common.nsvalue_struct.StructToNSValueTmpl

//__block #__callback_result_type__# _callbackResult = nil;
//[channel invokeMethod:@"#__callback_method__#"
//            arguments:@{#__callback_args__#}
//               result:^(id result) {
//                 #__raw_callback_result__#
//               }];
//
//while (_callbackResult == nil) {
//  // _callbackResult有值前, 空转
//}
//
//#__struct_value__#
//
//return #__callback_result__#;
internal class CallbackReturnTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/plugin/delegate_method/callback_return/callback_return.stmt.m.tmpl").readText()

    fun objcCallbackReturn(): String {
        return tmpl
            .replace("#__callback_result_type__#", method.returnType.run { if (findType().isStruct()) "NSValue*" else this })
            .replace(
                "#__callback_method__#",
                "${method.name}:${method.formalParams.joinToString(":") { it.variable.typeName }}"
            )
            .replace(
                "#__callback_args__#",
                method.formalParams.joinToString {
                    if (it.variable.typeName.findType().isStruct()) {
                        "@\"${it.variable.name}\": @(${StructToNSValueTmpl(
                            it.variable
                        ).objcStructToNSValue()}.hash)"
                    } else if (it.variable.typeName.findType().isRefType()){
                        "@\"${it.variable.name}\": @(${it.variable.name}.hash)"
                    } else {
                        "@\"${it.variable.name}\": @(${it.variable.name})"
                    }
                }
            )
            .replaceParagraph("#__raw_callback_result__#", method.returnType.run {
                when {
                    jsonable() -> ReturnJsonableTmpl(method).objcReturnJsonable()
                    findType().isRefType() -> ReturnRefTmpl(method).objcReturnRef()
                    findType().isStruct() -> ReturnStructTmpl(method).objcReturnStruct()
                    else -> this
                }
            })
            .replace(
                "#__struct_value__#", if (method.returnType.findType().isStruct())
                    NSValueToStructTmpl(
                        method.returnType,
                        "_callbackResult"
                    ).objcNSValueToStruct()
                else
                    ""
            )
            .replace(
                "#__callback_result__#",
                if (method.returnType.findType().isStruct()) "_structValue" else "_callbackResult"
            )
    }
}