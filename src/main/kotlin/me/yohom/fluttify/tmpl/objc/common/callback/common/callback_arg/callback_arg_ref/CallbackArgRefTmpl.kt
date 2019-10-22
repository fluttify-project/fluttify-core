package me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_ref

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.underscore2Camel
import me.yohom.fluttify.model.Variable

//NSNumber* arg#__arg_name__# = @(#__arg__#.hash);
//HEAP[arg#__arg_name__#] = #__arg_name__#;
internal class CallbackArgRefTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/callback_arg_ref.stmt.m.tmpl").readText()

    fun objcCallbackArgRef(): String {
        return tmpl
            .replace("#__arg_name__#", variable.name.depointer())
            .replace("#__arg__#", variable.run {
                // 如果碰到id类型就转型成NSObject
                if (typeName == "id")
                    "((NSObject*) ${name})"
                else
                    name
            }.depointer())

    }
}