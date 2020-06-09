package me.yohom.fluttify.tmpl.objc.common.handler.handler_top_constant

import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.model.Variable

//// top constant
//@"get#__name__#": ^(NSObject <FlutterPluginRegistrar> * registrar, id args, FlutterResult methodResult) {
//    methodResult.success(#__name__#);
//},
private val tmpl by lazy { getResource("/tmpl/objc/handler_top_constant.stmt.m.tmpl").readText() }
fun HandlerTopConstantTmpl(variable: Variable): String {
    return tmpl.replace("#__name__#", variable.name)
}