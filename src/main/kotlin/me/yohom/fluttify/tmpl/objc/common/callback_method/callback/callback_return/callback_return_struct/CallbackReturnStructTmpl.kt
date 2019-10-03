package me.yohom.fluttify.tmpl.objc.common.callback_method.callback.callback_return.callback_return_struct

import me.yohom.fluttify.model.Method

//NSInteger refId = (NSInteger) result;
//_callbackResult = (NSValue*) HEAP[@(refId)];
internal class CallbackReturnStructTmpl(private val method: Method) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/return_struct.stmt.m.tmpl").readText()

    fun objcReturnStruct(): String {
        return tmpl
    }
}