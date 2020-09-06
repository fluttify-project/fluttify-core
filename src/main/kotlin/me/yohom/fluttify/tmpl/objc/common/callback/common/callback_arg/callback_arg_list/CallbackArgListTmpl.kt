package me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_list

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.enpointer
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//// list callback arg
//NSMutableArray<NSObject*>* arg#__arg_name__# = [NSMutableArray arrayWithCapacity:#__arg_name__#.count];
//for (int __i__ = 0; __i__ < #__arg_name__#.count; __i__++) {
//    NSObject* item = ((NSObject*) [#__arg_name__# objectAtIndex:__i__]);
//    // return to dart side data
//    arg#__arg_name__#[__i__] = item;
//}
private val tmpl by lazy { getResource("/tmpl/objc/callback_arg_list.stmt.m.tmpl").readText() }

fun CallbackArgListTmpl(variable: Variable): String {
    return tmpl
        .replace("#__type_name__#", variable.trueType.enpointer())
        .replace("#__arg_name__#", variable.name.depointer())
}