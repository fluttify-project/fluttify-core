package me.yohom.fluttify.tmpl.objc.common.callback.common.callback_arg.callback_arg_jsonable

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.enpointer
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.isValueType
import me.yohom.fluttify.model.Variable

//// jsonable callback arg
//#__type_name__# arg#__arg_name__# = #__arg_name__# == nil ? [NSNull null] : #__arg_name__#;
private val tmpl by lazy { getResource("/tmpl/objc/callback_arg_jsonable.stmt.m.tmpl").readText() }

fun CallbackArgJsonableTmpl(variable: Variable): String {
    return tmpl
        .replace("#__type_name__#", variable.trueType.run {
            if (this.isValueType()) this else this.enpointer()
        })
        .replace("#__arg_name__#", variable.name.depointer())
}