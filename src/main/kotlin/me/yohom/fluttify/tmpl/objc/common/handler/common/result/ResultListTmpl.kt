package me.yohom.fluttify.tmpl.objc.common.handler.common.result

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.underscore2Camel

//// 返回值: 列表
//NSMutableArray* refIdList = [NSMutableArray array];
//for (int i = 0; i < result.count; i++) {
//    id object = [result objectAtIndex:i];
//    [refIdList addObject: object];
//    [HEAP_#__plugin_name__# setObject:object forKey:@([object hash])];
//}
//
//methodResult(refIdList);
internal class ResultListTmpl {

    private val tmpl = this::class.java.getResource("/tmpl/objc/result_list.stmt.m.tmpl").readText()

    fun objcResultList() = tmpl.replace("#__plugin_name__#", ext.outputProjectName.underscore2Camel(true))

}