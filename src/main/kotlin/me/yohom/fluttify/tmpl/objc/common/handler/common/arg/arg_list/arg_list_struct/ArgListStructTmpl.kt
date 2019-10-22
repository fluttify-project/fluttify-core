package me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_list.arg_list_struct

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.underscore2Camel
import me.yohom.fluttify.model.Variable

//// 列表参数
//NSArray* #__arg_name__#RefIdArray = (NSArray*) args[@"#__arg_name__#"];
//#__type_name__# #__arg_name__#[#__arg_name__#RefIdArray.count];
//
//for (int i = 0; i < #__arg_name__#RefIdArray.count; i++) {
//    NSValue* #__arg_name__#Value = (NSValue*) HEAP[[#__arg_name__#RefIdArray objectAtIndex:i]];
//    #__type_name__# #__arg_name__#Item;
//    [#__arg_name__#Value getValue:&#__arg_name__#Item];
//    #__arg_name__#[i] = #__arg_name__#Item;
//}
internal class ArgListStructTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/arg_list_struct.stmt.m.tmpl").readText()

    fun objcArgListStruct(): String {
        val typeName = variable.typeName.depointer()
        val argName = variable.name.depointer()
        return tmpl
            .replace("#__type_name__#", typeName)
            .replace("#__arg_name__#", argName)
            .replace(
                "#__plugin_name__#",
                if (variable.isPlatformType()) "Platform" else ext.outputProjectName.underscore2Camel()
            )
    }
}