package me.yohom.fluttify.tmpl.objc.common.delegate_method.delegate.callback_return

import me.yohom.fluttify.model.Method

//NSInteger refId = (NSInteger) result;
//_callbackResult = (NSValue*) HEAP[@(refId)];
internal class ReturnStructTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/return_struct.stmt.m.tmpl")
            .readText()

    fun objcReturnStruct(): String {
        return tmpl
    }
}