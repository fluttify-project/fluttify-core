package me.yohom.fluttify.tmpl.objc.common.callback_method.callback_arg.callback_arg_struct

import me.yohom.fluttify.model.Variable

//// 结构体回调参数
//NSValue* #__arg_name__#Value = [NSValue value:&#__arg_name__# withObjCType:@encode(#__type_name__#)];
//NSNumber* arg#__arg_name__# = @(#__arg_name__#Value.hash);
//HEAP[arg#__arg_name__#] = #__arg_name__#Value;
internal class CallbackArgStructTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/callback_arg_struct.stmt.m.tmpl").readText()

    fun objcCallbackArgStruct(): String {
        return tmpl
            .replace("#__arg_name__#", variable.name)
            .replace("#__type_name__#", variable.typeName)
    }
}