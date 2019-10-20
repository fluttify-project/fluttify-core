package me.yohom.fluttify.tmpl.objc.common.callback_method.callback.callback_return.callback_return_ref

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.underscore2Camel
import me.yohom.fluttify.model.Method

//NSInteger refId = (NSInteger) result;
//_callbackResult = (#__ref_type__#) HEAP_#__plugin_name__#[@(refId)];
internal class CallbackReturnRefTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/return_ref.stmt.m.tmpl").readText()

    fun objcReturnRef(): String {
        return tmpl
            .replace("#__ref_type__#", method.returnType)
            .replace("#__plugin_name__#", ext.outputProjectName.underscore2Camel(true))
    }
}