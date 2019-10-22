package me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_list

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.enpointer
import me.yohom.fluttify.extensions.underscore2Camel
import me.yohom.fluttify.model.Variable

//// 列表回调参数
//NSMutableArray<NSNumber*>* arg#__arg_name__# = [NSMutableArray arrayWithCapacity:#__arg_name__#.count];
//for (int i = 0; i < #__arg_name__#.count; i++) {
//    NSObject* item = ((NSObject*) [#__arg_name__# objectAtIndex:i]);
//    // 返回给dart端的数据
//    arg#__arg_name__#[i] = @(item.hash);
//    // 放到HEAP中的数据
//    HEAP[@(item.hash)] = item;
//}
internal class CallbackArgListTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/callback_arg_list.stmt.m.tmpl").readText()

    fun objcCallbackArgList(): String {
        return tmpl
            .replace("#__type_name__#", variable.typeName.enpointer())
            .replace("#__arg_name__#", variable.name.depointer())

    }
}