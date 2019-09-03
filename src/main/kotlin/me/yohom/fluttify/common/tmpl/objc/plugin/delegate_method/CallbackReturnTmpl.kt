package me.yohom.fluttify.common.tmpl.objc.plugin.delegate_method

import me.yohom.fluttify.common.model.Method

//__block #__return_type__# *_result = nil;
//[channel invokeMethod:@"#__callback_method__#"
//            arguments:@{#__callback_args__#}
//               result:^(id result) {
//                 _result = (#__return_type__# *) result;
//               }];
//
//while (!_result) {
//  // _result有值前, 空转
//}
//
//return _result;
internal class CallbackReturnTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/plugin/delegate_method/callback_return.stmt.m.tmpl").readText()

    fun objcCallbackReturn(): String {
        return tmpl
            .replace("#__return_type__#", method.returnType)
            .replace(
                "#__callback_method__#",
                "${method.name}:${method.formalParams.joinToString(":") { it.variable.typeName }}"
            )
            .replace(
                "#__callback_args__#",
                method.formalParams.joinToString { "@\"${it.variable.name}\": @(${it.variable.name}.hash)" }
            )
    }
}