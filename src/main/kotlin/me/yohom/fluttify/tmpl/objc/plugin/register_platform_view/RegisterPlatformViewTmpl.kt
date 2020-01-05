package me.yohom.fluttify.tmpl.objc.plugin.register_platform_view

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.simpleName
import me.yohom.fluttify.model.Type

//[registrar registerViewFactory: [[#__factory_name__#Factory alloc] init] withId: @"#__view_type__#"];
private val tmpl = getResource("/tmpl/objc/register_platform_view.stmt.m.tmpl").readText()

fun RegisterPlatformViewTmpl(viewType: Type): String {
    val viewTypeName = "${ext.org}/${viewType.name}"
    val factoryName = viewType.name.simpleName()

    return tmpl
        .replace("#__view_type__#", viewTypeName)
        .replace("#__factory_name__#", factoryName)
}