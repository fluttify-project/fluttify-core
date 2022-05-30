package me.yohom.fluttify.tmpl.java.common.handler.handler_anonymous

import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Method
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgEnumTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.arg.ArgRefTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.common.callback.CallbackTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.invoke_return.InvokeReturnTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.invoke.invoke_void.InvokeVoidTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.log.LogInstanceTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.log.LogStaticTmpl
import me.yohom.fluttify.tmpl.java.common.handler.common.ref.RefTmpl

//// anonymous class
//put("#__class_name__#::createAnonymous__", (__args__, __methodResult__) -> {
//    // invoke native method
//    #__class_name__# __result__ = #__anonymous_class__#;
//
//    __methodResult__.success(__result__);
//});
private val tmpl by lazy { getResource("/tmpl/java/handler_anonymous.stmt.java.tmpl").readText() }

fun HandlerAnonymousTmpl(type: Type): String {
    return tmpl
        .replace("#__class_name__#", type.name.replace("$", "."))
        .replace("#__anonymous_class__#", CallbackTmpl(type))
}