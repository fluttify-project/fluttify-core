package me.yohom.fluttify.tmpl.java.common.handler.handler_type_check

import me.yohom.fluttify.extensions.containerType
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.extensions.toUnderscore
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Type

//put("RefClass::isKindOf#__underscore_type_name__#", (__args__, __methodResult__) -> {
//    // 引用对象
//    int refId = (int) ((Map<String, Object>) __args__).get("refId");
//    Object ref = getHEAP().get(refId);
//
//    __methodResult__.success(ref instanceof #__type_name__#);
//});
private val tmpl by lazy { getResource("/tmpl/java/handler_type_check.stmt.java.tmpl").readText() }

fun HandlerTypeCheckTmpl(type: Type): String {
    return tmpl
        .replace("#__underscore_type_name__#", type.name.containerType().toDartType())
        .replace("#__type_name__#", type.name.containerType())
}