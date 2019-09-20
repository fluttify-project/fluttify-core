package me.yohom.fluttify.common.tmpl.objc.common.handler.arg

import me.yohom.fluttify.common.model.Variable

//// 枚举参数
//#__type_name__# #__arg_name__# = (#__type_name__#) [args[@"#__arg_name__#"] integerValue];
internal class ArgEnumTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/plugin/handler/arg/arg_enum.stmt.m.tmpl").readText()

    fun objcArgEnum(): String {
        val typeName = variable.typeName
        val name = variable.name
        
        return tmpl
            .replace("#__type_name__#", typeName)
            .replace("#__arg_name__#", name)
    }
}