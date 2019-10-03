package me.yohom.fluttify.tmpl.objc.common.callback_method.callback_arg.callback_arg_ref

import me.yohom.fluttify.model.Parameter

//NSNumber* arg#__arg_name__# = @(#__arg__#.hash);
//HEAP[arg#__arg_name__#] = #__arg_name__#;
internal class CallbackArgRefTmpl(private val param: Parameter) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/callback_arg_ref.stmt.m.tmpl").readText()

    fun kotlinCallbackArgRef(): String {
        return tmpl
            .replace("#__arg_name__#", param.variable.name)
            .replace("#__arg__#", param.variable.run {
                // 如果碰到id类型就转型成NSObject
                if (typeName == "id")
                    "((NSObject*) ${name})"
                else
                    name
            })
    }
}