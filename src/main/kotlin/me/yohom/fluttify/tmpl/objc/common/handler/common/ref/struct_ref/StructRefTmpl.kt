package me.yohom.fluttify.tmpl.objc.common.handler.common.ref.struct_ref

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Method

//NSValue* dataValue = (NSValue*) HEAP[(NSNumber*) ((NSDictionary<NSString*, NSObject*>*) args)[@"refId"]];
//#__type_name__# ref;
//[dataValue getValue:&ref];
private val tmpl = getResource("/tmpl/objc/struct_ref.stmt.m.tmpl").readText()

fun StructRefTmpl(method: Method): String {
    return tmpl.replace("#__type_name__#", method.className)
}