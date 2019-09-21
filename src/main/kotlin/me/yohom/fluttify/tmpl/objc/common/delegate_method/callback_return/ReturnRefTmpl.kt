package me.yohom.fluttify.tmpl.objc.common.delegate_method.callback_return

import me.yohom.fluttify.model.Method

//NSInteger refId = (NSInteger) result;
//_callbackResult = (#__ref_type__#) REF_MAP[@(refId)];
internal class ReturnRefTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/return_ref.stmt.m.tmpl").readText()

    fun objcReturnRef(): String {
        return tmpl
            .replace("#__ref_type__#", method.returnType)
    }
}