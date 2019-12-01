package me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_jsonable

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.enpointer
import me.yohom.fluttify.extensions.isValueType
import me.yohom.fluttify.model.Variable

//// jsonable回调参数
//#__type_name__# arg#__arg_name__# = #__arg_name__#;
internal class CallbackArgJsonableTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/callback_arg_jsonable.stmt.m.tmpl").readText()

    fun objcCallbackArgJsonable(): String {
        return tmpl
            .replace("#__type_name__#", variable.typeName.run {
                if (this.isValueType()) this else this.enpointer()
            })
            .replace("#__arg_name__#", variable.name.depointer())
    }
}