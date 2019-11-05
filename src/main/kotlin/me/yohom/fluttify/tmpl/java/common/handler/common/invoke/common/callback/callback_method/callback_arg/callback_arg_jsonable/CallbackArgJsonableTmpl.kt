package me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.callback_method.callback_arg.callback_arg_jsonable

import me.yohom.fluttify.model.Parameter

//#__type_name__# arg#__arg_name__# = #__arg_name__#;
internal class CallbackArgJsonableTmpl(private val param: Parameter) {
    private val tmpl = this::class.java.getResource("/tmpl/java/callback_arg_jsonable.stmt.java.tmpl").readText()

    fun javaCallbackArgJsonable(): String {
        return tmpl
            .replace("#__type_name__#", param.variable.run {
                var result = typeName
                for (i in 0 until genericLevel) {
                    result = "List<$result>"
                }
                result
            })
            .replace("#__arg_name__#", param.variable.name)
    }
}