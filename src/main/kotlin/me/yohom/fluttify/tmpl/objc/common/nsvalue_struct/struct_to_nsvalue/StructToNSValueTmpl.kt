package me.yohom.fluttify.tmpl.objc.common.nsvalue_struct.struct_to_nsvalue

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//[NSValue value:&#__variable_name__# withObjCType:@encode(#__struct_type__#)]
private val hTmpl = getResource("/tmpl/objc/struct_to_nsvalue.stmt.m.tmpl").readText()

fun StructToNSValueTmpl(variable: Variable): String {
    return hTmpl
        .replace("#__variable_name__#", variable.name)
        .replace("#__struct_type__#", variable.typeName)
}