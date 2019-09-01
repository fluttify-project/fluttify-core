package me.yohom.fluttify.common.tmpl.objc.plugin.register_platform_view

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.simpleName
import me.yohom.fluttify.common.model.Type

//[registrar registerViewFactory: [[#__factory_name__#Factory alloc] init] withId: @"#__view_type__#"];
internal class RegisterPlatformViewTmpl(
    private val viewType: Type,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/plugin/register_platform_view/register_platform_view.stmt.m.tmpl").readText()

    fun objcRegisterPlatformView(): String {
        return tmpl
            .replace("#__view_type__#", "${ext.outputOrg}/${viewType.name}")
            .replace("#__factory_name__#", viewType.name.simpleName())
    }
}