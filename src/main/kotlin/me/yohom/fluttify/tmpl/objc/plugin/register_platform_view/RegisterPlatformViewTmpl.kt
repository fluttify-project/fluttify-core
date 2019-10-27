package me.yohom.fluttify.tmpl.objc.plugin.register_platform_view

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.simpleName
import me.yohom.fluttify.model.Type

//[registrar registerViewFactory: [[#__factory_name__#Factory alloc] init] withId: @"#__view_type__#"];
internal class RegisterPlatformViewTmpl(private val viewType: Type) {
    private val tmpl =
        this::class.java.getResource("/tmpl/objc/register_platform_view.stmt.m.tmpl")
            .readText()

    fun objcRegisterPlatformView(): String {
        val viewType = "${ext.outputOrg}/${viewType.name}"
        val factoryName = this.viewType.name.simpleName()

        return tmpl
            .replace("#__view_type__#", viewType)
            .replace("#__factory_name__#", factoryName)
    }
}