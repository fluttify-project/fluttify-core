package me.yohom.fluttify.tmpl.objc.common.callback.common.callback_invoke.callback_return.callback_return_ref

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.underscore2Camel
import me.yohom.fluttify.model.Method

//NSInteger refId = (NSInteger) result;
//_callbackResult = (#__ref_type__#) HEAP[@(refId)];
internal class CallbackReturnRefTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/return_ref.stmt.m.tmpl").readText()

    fun objcReturnRef(): String {
        return tmpl
            .replace("#__ref_type__#", method.returnType)

    }
}