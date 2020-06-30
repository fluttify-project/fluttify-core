package me.yohom.fluttify.tmpl.java.plugin.register_handler

import me.yohom.fluttify.extensions.getResource

//handlerMapList.add(SubHandler#__number__#.getSubHandler());
private val tmpl by lazy { getResource("/tmpl/java/register_handler.stmt.tmpl").readText() }

fun RegisterHandlerTmpl(number: Int): String {
    val numberString = number.toString()

    return tmpl.replace("#__number__#", numberString)
}