package me.yohom.fluttify.common.tmpl.objc.common.delegate_method.callback_return

import me.yohom.fluttify.common.model.Method

//NSInteger refId = (NSInteger) result;
//_callbackResult = (NSValue*) REF_MAP[@(refId)];
internal class ReturnStructTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/plugin/delegate_method/callback_return/return_struct.stmt.m.tmpl")
            .readText()

    fun objcReturnStruct(): String {
        return tmpl
    }
}