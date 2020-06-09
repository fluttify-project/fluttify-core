package me.yohom.fluttify.tmpl.objc.plugin.register_handler

import me.yohom.fluttify.extensions.getResource

//[_handlerMap addEntriesFromDictionary: [self getSubHandler#__number__#]];
private val tmpl by lazy { getResource("/tmpl/objc/register_handler.stmt.m.tmpl").readText() }
fun RegisterHandlerTmpl(number: Int): String {
    val numberString = number.toString()

    return tmpl.replace("#__number__#", numberString)
}