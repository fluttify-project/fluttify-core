package me.yohom.fluttify.tmpl.objc.common.callback_method.callback_arg.callback_arg_list

import me.yohom.fluttify.extensions.enpointer
import me.yohom.fluttify.model.Parameter

//// 列表参数
//NSMutableArray<NSNumber*>* arg#__arg_name__# = [NSMutableArray arrayWithCapacity:#__arg_name__#.count];
//for (int i = 0; i < #__arg_name__#.count; i++) {
//    arg#__arg_name__#[i] = @(#__arg_name__#.hash);
//    HEAP[@(#__arg_name__#.hash)] = #__arg_name__#;
//}
internal class CallbackArgListTmpl(private val param: Parameter) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/callback_arg_list.stmt.m.tmpl").readText()

    fun objcCallbackArgList(): String {
        return tmpl
            .replace("#__type_name__#", param.variable.typeName.enpointer())
            .replace("#__arg_name__#", param.variable.name)
    }
}