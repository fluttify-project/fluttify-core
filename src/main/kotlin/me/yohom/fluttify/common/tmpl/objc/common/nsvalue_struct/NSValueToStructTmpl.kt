package me.yohom.fluttify.common.tmpl.objc.common.nsvalue_struct

import me.yohom.fluttify.common.TYPE_NAME

//#__struct_type__# _structValue;
//[#__nsvalue_variable_name__# getValue:&_structValue];
class NSValueToStructTmpl(private val structType: TYPE_NAME, private val nsvalueVar: String) {
    private val hTmpl = this::class.java.getResource("/tmpl/objc/common/nsvalue_to_struct.stmt.m.tmpl").readText()

    fun objcNSValueToStruct(): String {
        return hTmpl
            .replace("#__struct_type__#", structType)
            .replace("#__nsvalue_variable_name__#", nsvalueVar)
    }
}