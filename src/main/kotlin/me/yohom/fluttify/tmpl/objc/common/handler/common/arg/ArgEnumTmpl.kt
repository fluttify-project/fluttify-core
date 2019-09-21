package me.yohom.fluttify.tmpl.objc.common.handler.common.arg

import me.yohom.fluttify.model.Variable

//// 枚举参数
//#__type_name__# #__arg_name__# = (#__type_name__#) [args[@"#__arg_name__#"] integerValue];
internal class ArgEnumTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/arg_enum.stmt.m.tmpl").readText()

    fun objcArgEnum(): String {
        val typeName = variable.typeName
        val name = variable.name
        
        return tmpl
            .replace("#__type_name__#", typeName)
            .replace("#__arg_name__#", name)
    }
}