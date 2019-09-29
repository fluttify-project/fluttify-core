package me.yohom.fluttify.tmpl.objc.common.handler.common.result

//// 返回值: 列表
//NSMutableArray* refIdList = [NSMutableArray array];
//for (int i = 0; i < result.count; i++) {
//    id object = [result objectAtIndex:i];
//    [refIdList addObject: object];
//    [HEAP setObject:object forKey:@([object hash])];
//}
//
//methodResult(refIdList);
internal class ResultListTmpl {

    private val tmpl = this::class.java.getResource("/tmpl/objc/result_list.stmt.m.tmpl").readText()

    fun objcResultList() = tmpl

}