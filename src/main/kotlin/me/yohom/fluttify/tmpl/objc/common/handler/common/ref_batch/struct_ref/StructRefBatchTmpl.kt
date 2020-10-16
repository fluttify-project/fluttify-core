package me.yohom.fluttify.tmpl.objc.common.handler.common.ref_batch.struct_ref

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Method

//NSValue* dataValue = (NSValue*) ((NSDictionary<NSString*, NSObject*>*) args)[@"__this__"];
//// 批处理过程中出现nil引用则直接添加nil进结果列表, 然后进行下一次循环
//if ((NSNull *) dataValue == [NSNull null] || dataValue == nil) {
//    [resultList addObject: [NSNull null]];
//    continue;
//} else {
//    #__type_name__# value;
//    [dataValue getValue:&value];
//}
private val tmpl by lazy { getResource("/tmpl/objc/struct_ref_batch.stmt.m.tmpl").readText() }

fun StructRefBatchTmpl(method: Method): String {
    return tmpl.replace("#__type_name__#", method.className)
}