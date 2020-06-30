package me.yohom.fluttify.tmpl.objc.common.callback.common.callback_invoke.callback_return.callback_return_ref

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Method

//NSInteger refId = (NSInteger) result;
//_callbackResult = (#__ref_type__#) HEAP[@(refId)];
private val tmpl by lazy { getResource("/tmpl/objc/return_ref.stmt.m.tmpl").readText() }

fun CallbackReturnRefTmpl(method: Method): String {
    return tmpl
        .replace("#__ref_type__#", method.returnType)
}