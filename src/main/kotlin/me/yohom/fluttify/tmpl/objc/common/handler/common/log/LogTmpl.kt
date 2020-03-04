package me.yohom.fluttify.tmpl.objc.common.handler.common.log

import me.yohom.fluttify.extensions.joinToStringX
import me.yohom.fluttify.model.Method

fun LogTmpl(method: Method): String {
    val argsPlaceholder = method.formalParams.joinToString { if (it.variable.isValueType()) "%d" else "%@" }
    val args = method.formalParams.joinToStringX(prefix = ", ") { """args[@"${it.variable.name}"]""" }
    return if (method.isStatic) {
        """NSLog(@"fluttify-objc: ${method.className}::${method.name}($argsPlaceholder)"$args);"""
    } else {
        """NSLog(@"fluttify-objc: ${method.className}@%@::${method.name}($argsPlaceholder)", args[@"refId"]$args);"""
    }
}