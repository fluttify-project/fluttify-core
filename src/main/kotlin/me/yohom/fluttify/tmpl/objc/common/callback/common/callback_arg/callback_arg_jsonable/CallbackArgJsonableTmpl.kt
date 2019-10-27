package me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_jsonable

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.model.Variable

//// jsonable回调参数
//#__type_name__# arg#__arg_name__# = #__arg_name__#;
@Deprecated("没有用处 jsonable这个概念对于objc来说感觉很尴尬, 一方面原生类型不需要指针, 而NSString之类的却有需要指针")
internal class CallbackArgJsonableTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/callback_arg_jsonable.stmt.m.tmpl").readText()

    fun objcCallbackArgJsonable(): String {
        return tmpl
            .replace("#__type_name__#", variable.typeName)
            .replace("#__arg_name__#", variable.name.depointer())
    }
}