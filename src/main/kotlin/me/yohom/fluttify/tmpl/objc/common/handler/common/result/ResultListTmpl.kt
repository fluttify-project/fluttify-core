package me.yohom.fluttify.tmpl.objc.common.handler.common.result

import me.yohom.fluttify.extensions.getResource

//// 返回值: 列表
//NSMutableArray* jsonableResult = [NSMutableArray array];
//for (int i = 0; i < result.count; i++) {
//    NSObject* object = [result objectAtIndex:i];
//    [jsonableResult addObject: @(object.hash)];
//    HEAP[@([object hash])] = object;
//}
private val tmpl by lazy { getResource("/tmpl/objc/result_list.stmt.m.tmpl").readText() }
fun ResultListTmpl(): String {
    return tmpl
}