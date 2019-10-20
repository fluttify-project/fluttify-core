package me.yohom.fluttify.tmpl.kotlin.common.handler.common.invoke.common.callback.callback_method.callback_arg.callback_arg_list

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.underscore2Camel
import me.yohom.fluttify.model.Parameter

//val arg#__arg_name__# = #__arg_name__#.map { it.apply { HEAP_#__plugin_name__#[it.hashCode()] = it }.hashCode() }
internal class CallbackArgListTmpl(private val param: Parameter) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/callback_arg_list.stmt.kt.tmpl").readText()

    fun kotlinCallbackArgList(): String {
        return tmpl
            .replace("#__arg_name__#", param.variable.name)
            .replace("#__plugin_name__#", ext.outputProjectName.underscore2Camel(true))
    }
}