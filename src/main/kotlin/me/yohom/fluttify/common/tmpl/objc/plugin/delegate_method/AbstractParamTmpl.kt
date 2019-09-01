package me.yohom.fluttify.common.tmpl.objc.plugin.delegate_method

import me.yohom.fluttify.common.extensions.findType
import me.yohom.fluttify.common.model.Method

//([#__formal_param__# isKindOfClass:[#__param_type__# class]]) {
//  [channel invokeMethod:@"#__callback_method__#" arguments:@{#__args__#}];
//
//  #__next_param__#
//}
internal class AbstractParamTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/abstract_param.stmt.m.tmpl").readText()

    fun objcAbstractParam(): String {
        return method.formalParams
            .filter { it.variable.typeName.findType().isAbstract }
            .joinToString(" else if ", prefix = "if ") {
                tmpl.replace("__formal_param__", "")
            }
    }
}