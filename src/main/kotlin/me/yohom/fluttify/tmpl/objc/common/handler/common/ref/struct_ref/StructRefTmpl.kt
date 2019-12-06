package me.yohom.fluttify.tmpl.objc.common.handler.common.ref.struct_ref

import me.yohom.fluttify.model.Method

//NSValue* dataValue = (NSValue*) HEAP[(NSNumber*) args[@"refId"]];
//#__type_name__# ref;
//[dataValue getValue:&ref];
internal class StructRefTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/struct_ref.stmt.m.tmpl").readText()

    fun objcStructRef(): String {
        return tmpl.replace("#__type_name__#", method.className)
    }
}