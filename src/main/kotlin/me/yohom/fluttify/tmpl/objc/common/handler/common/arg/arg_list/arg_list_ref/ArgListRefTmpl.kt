package me.yohom.fluttify.tmpl.objc.common.handler.common.arg.arg_list.arg_list_ref

import me.yohom.fluttify.extensions.depointer
import me.yohom.fluttify.extensions.enpointer
import me.yohom.fluttify.model.Variable

//// 列表参数
//NSArray<NSNumber*>* #__arg_name__#RefArray = (NSArray<NSNumber*> *) args[@"#__arg_name__#"];
//NSMutableArray<#__type_name__#>* #__arg_name__# = [NSMutableArray arrayWithCapacity:#__arg_name__#RefArray.count];
//for (int i = 0; i < #__arg_name__#.count; i++) {
//    #__type_name__# item = (#__type_name__#) HEAP[[#__arg_name__#RefArray objectAtIndex:i]];
//    [#__arg_name__# addObject:item];
//}
internal class ArgListRefTmpl(private val variable: Variable) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/arg_list_ref.stmt.m.tmpl").readText()

    fun objcArgListRef(): String {
        val typeName = variable.typeName.enpointer()
        val argName = variable.name.depointer()
        return tmpl
            .replace("#__type_name__#", typeName)
            .replace("#__arg_name__#", argName)
    }
}