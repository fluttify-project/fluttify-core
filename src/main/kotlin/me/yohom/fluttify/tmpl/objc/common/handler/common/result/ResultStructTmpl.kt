package me.yohom.fluttify.tmpl.objc.common.handler.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.getResource

//// 返回值: 结构体
//NSValue* resultValue = [NSValue value:&result withObjCType:@encode(#__result_type__#)];
//HEAP[@(resultValue.hash)] = resultValue;
//NSNumber* jsonableResult = @(resultValue.hash);
private val tmpl = getResource("/tmpl/objc/result_struct.stmt.m.tmpl").readText()

fun ResultStructTmpl(returnType: TYPE_NAME): String {
    return tmpl
        .replace("#__result_type__#", returnType)
}