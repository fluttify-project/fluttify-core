package me.yohom.fluttify.tmpl.objc.common.nsvalue_struct.nsvalue_to_struct

import me.yohom.fluttify.TYPE_NAME
import me.yohom.fluttify.extensions.getResource

//#__struct_type__# _structValue;
//[#__nsvalue_variable_name__# getValue:&_structValue];
private val hTmpl by lazy { getResource("/tmpl/objc/nsvalue_to_struct.stmt.m.tmpl").readText() }

fun NSValueToStructTmpl(structType: TYPE_NAME, nsvalueVar: String): String {
    return hTmpl
        .replace("#__struct_type__#", structType)
        .replace("#__nsvalue_variable_name__#", nsvalueVar)
}