package me.yohom.fluttify.common.tmpl.objc.plugin.handler

import me.yohom.fluttify.common.model.Variable

//// 结构体参数
//NSValue* #__arg_name__#Value = (NSValue*) REF_MAP[@([args[@"#__arg_name__#"] integerValue])];
//#__type_name__# #__arg_name__#;
//[#__arg_name__#Value getValue:&#__arg_name__#];
internal class ArgStructTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/arg_struct.stmt.m.tmpl").readText()

    fun objcArgStruct(): String {
        return tmpl
            .replace("#__type_name__#", if (variable.isList) "List<${variable.typeName}>" else variable.typeName)
            .replace("#__arg_name__#", variable.name)
    }
}