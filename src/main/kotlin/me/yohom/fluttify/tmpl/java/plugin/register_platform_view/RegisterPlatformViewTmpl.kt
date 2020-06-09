package me.yohom.fluttify.tmpl.java.plugin.register_platform_view

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.simpleName
import me.yohom.fluttify.model.Type

//platformViewRegistry.registerViewFactory("#__view_type__#", new #__factory_name__#Factory(messenger));
private val tmpl by lazy { getResource("/tmpl/java/register_platform_view.stmt.java.tmpl").readText() }

fun RegisterPlatformViewTmpl(viewType: Type): String {
    return tmpl
        .replace("#__view_type__#", "${ext.org}/${viewType.name}")
        .replace("#__factory_name__#", viewType.name.simpleName())
}