package me.yohom.fluttify.tmpl.objc.common.handler.common.result

import me.yohom.fluttify.extensions.getResource

//// 返回值: 列表
//NSMutableArray* refIdList = [NSMutableArray array];
//for (int i = 0; i < result.count; i++) {
//    id object = [result objectAtIndex:i];
//    [refIdList addObject: object];
//    [HEAP setObject:object forKey:@([object hash])];
//}
//
//methodResult(refIdList);
private val tmpl = getResource("/tmpl/objc/result_list.stmt.m.tmpl").readText()

fun ResultListTmpl(): String {
    return tmpl
}