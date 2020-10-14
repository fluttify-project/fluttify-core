package me.yohom.fluttify.tmpl.objc.common.handler.common.ref_batch.ref_ref

import me.yohom.fluttify.extensions.enpointer
import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Method

//#__type_name__# ref = (#__type_name__#) args[@"__this__"];
//// 批处理过程中出现nil引用则直接添加nil进结果列表, 然后进行下一次循环
//if ((NSNull *) ref == [NSNull null] || ref == nil) {
//    [resultList addObject: [NSNull null]];
//    continue;
//}
private val tmpl by lazy { getResource("/tmpl/objc/ref_ref_batch.stmt.m.tmpl").readText() }

fun RefRefBatchTmpl(method: Method): String {
    val empty = ""
    val protocol = "id<${method.className}>"
    val `class` = method.className.enpointer()

    return when {
        method.isStatic -> empty
        method.className.findType().isInterface -> tmpl.replace("#__type_name__#", protocol)
        else -> tmpl.replace("#__type_name__#", `class`)
    }
}