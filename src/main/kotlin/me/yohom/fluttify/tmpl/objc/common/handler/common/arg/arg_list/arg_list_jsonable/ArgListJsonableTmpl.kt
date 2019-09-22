package me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_list.arg_list_jsonable

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.model.Variable

//// 列表参数
//NSArray* #__arg_name__#RefIdArray = (NSArray*) args[@"__arg_name__"];
//#__type_name__# #__arg_name__#Array[#__arg_name__#RefIdArray.count];
//
//for (int i = 0; i < #__arg_name__#RefIdArray.count; i++) {
//    NSValue* #__arg_name__#Value = (NSValue*) REF_MAP[[#__arg_name__#RefIdArray objectAtIndex:i]];
//    #__type_name__# #__arg_name__#;
//    [#__arg_name__#Value getValue:&__arg_name__];
//    #__arg_name__#Array[i] = #__arg_name__#;
//}
// todo 实现jsonable的列表参数
internal class ArgListJsonableTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/arg_list_jsonable.stmt.m.tmpl").readText()

    fun objcArgList(): String {
        val typeName = variable.typeName.depointer()
        val argName = variable.name.depointer()
        return tmpl
            .replace("#__type_name__#", typeName)
            .replace("#__arg_name__#", argName)
    }
}