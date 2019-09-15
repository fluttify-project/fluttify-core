package me.yohom.fluttify.common.tmpl.objc.common.delegate_method.callback_return

import me.yohom.fluttify.common.model.Method

//_callbackResult = (#__jsonable_type__#) result;
internal class ReturnJsonableTmpl(private val method: Method) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/plugin/delegate_method/callback_return/return_jsonable.stmt.m.tmpl").readText()

    fun objcReturnJsonable(): String {
        return tmpl
            .replace("#__jsonable_type__#", method.returnType)
    }
}