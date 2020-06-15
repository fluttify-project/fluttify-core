package me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_ref

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.isPrimitivePointerType
import me.yohom.fluttify.model.Variable

//// ref callback arg
//NSNumber* arg#__arg_name__# = nil;
//if (#__arg__# != nil) {
//    arg#__arg_name__# = @(#__arg__#.hash);
//    HEAP[arg#__arg_name__#] = #__arg__#;
//}
private val tmpl by lazy { getResource("/tmpl/objc/callback_arg_ref.stmt.m.tmpl").readText() }

fun CallbackArgRefTmpl(variable: Variable): String {
    return tmpl
        .replace("#__arg_name__#", variable.name.depointer())
        .replace("#__arg__#", variable.run {
            // 如果碰到id类型就转型成NSObject
            when (trueType) {
                "id" -> "((NSObject*) $name)"
                else -> when {
                    trueType.isPrimitivePointerType() -> "[NSValue valueWithPointer:$name]"
                    else -> name
                }
            }
        }.depointer())
}