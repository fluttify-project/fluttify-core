package me.yohom.fluttify.tmpl.objc.common.callback.common.callback_invoke.callback_return.callback_return_struct

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Method

//NSInteger refId = (NSInteger) result;
//_callbackResult = (NSValue*) HEAP[@(refId)];
private val tmpl = getResource("/tmpl/objc/return_struct.stmt.m.tmpl").readText()

fun CallbackReturnStructTmpl(method: Method): String {
    return tmpl
}