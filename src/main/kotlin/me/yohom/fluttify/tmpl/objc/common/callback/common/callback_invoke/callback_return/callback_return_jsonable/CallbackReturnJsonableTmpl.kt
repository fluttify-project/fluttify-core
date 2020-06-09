package me.yohom.fluttify.tmpl.objc.common.callback.common.callback_invoke.callback_return.callback_return_jsonable

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Method

//_callbackResult = (#__jsonable_type__#) result;
private val tmpl by lazy { getResource("/tmpl/objc/return_jsonable.stmt.m.tmpl").readText() }

fun CallbackReturnJsonableTmpl(method: Method): String {
    return tmpl
        .replace("#__jsonable_type__#", method.returnType)
}