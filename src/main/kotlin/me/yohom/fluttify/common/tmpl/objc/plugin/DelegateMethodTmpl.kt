package me.yohom.fluttify.common.tmpl.objc.plugin

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.simpleName
import me.yohom.fluttify.common.model.Type

//[registrar registerViewFactory: [[#__factory_name__#Factory alloc] init] withId: @"#__view_type__#"];
internal class DelegateMethodTmpl(
    private val viewType: Type,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/objc/register_platform_view.stmt.m.tmpl").readText()

    fun objcRegisterPlatformView(): String {
        return tmpl
            .replace("#__view_type__#", "${ext.outputOrg}/${viewType.name}")
            .replace("#__factory_name__#", viewType.name.simpleName())
    }
}