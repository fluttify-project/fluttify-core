package me.yohom.fluttify.tmpl.objc.common.nsvalue_struct.struct_to_nsvalue

import me.yohom.fluttify.model.Variable

//[NSValue value:&#__variable_name__# withObjCType:@encode(#__struct_type__#)]
class StructToNSValueTmpl(private val variable: Variable) {
    private val hTmpl = this::class.java.getResource("/tmpl/objc/struct_to_nsvalue.stmt.m.tmpl").readText()

    fun objcStructToNSValue(): String {
        return hTmpl
            .replace("#__variable_name__#", variable.name)
            .replace("#__struct_type__#", variable.typeName)
    }
}