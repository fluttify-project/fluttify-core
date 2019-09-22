package me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_struct

import me.yohom.fluttify.model.Variable

//// 结构体参数
//NSValue* #__arg_name__#Value = (NSValue*) REF_MAP[@([args[@"#__arg_name__#"] integerValue])];
//#__type_name__# #__arg_name__#;
//[#__arg_name__#Value getValue:&#__arg_name__#];
internal class ArgStructTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/arg_struct.stmt.m.tmpl").readText()

    fun objcArgStruct(): String {
        val typeName = if (variable.isList) "NSArray<${variable.typeName}>" else variable.typeName
        val argName = variable.name
        return tmpl
            .replace("#__type_name__#", typeName)
            .replace("#__arg_name__#", argName)
    }
}