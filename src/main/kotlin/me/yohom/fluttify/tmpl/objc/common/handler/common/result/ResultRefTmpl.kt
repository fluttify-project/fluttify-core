package me.yohom.fluttify.tmpl.objc.common.handler.common.result

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.getResource

//// return a ref
//HEAP[@((#__cast_nsobject__#result).hash)] = result;
//NSNumber* jsonableResult = @((#__cast_nsobject__#result).hash);
private val tmpl by lazy { getResource("/tmpl/objc/result_ref.stmt.m.tmpl").readText() }

fun ResultRefTmpl(returnType: TYPE_NAME): String {
    // 如果返回的是id类型, 那么一律转为NSObject*
    return tmpl.replace("#__cast_nsobject__#", if (returnType == "id") "(NSObject*) " else "")
}