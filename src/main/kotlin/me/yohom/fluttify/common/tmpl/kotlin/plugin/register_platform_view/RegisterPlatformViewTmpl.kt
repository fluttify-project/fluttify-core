package me.yohom.fluttify.common.tmpl.kotlin.plugin.register_platform_view

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.simpleName
import me.yohom.fluttify.common.model.Type

//registrar
//        .platformViewRegistry()
//        .registerViewFactory("#__view_type__#", #__factory_name__#Factory(registrar))
internal class RegisterPlatformViewTmpl(
    private val viewType: Type,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/kotlin/plugin/register_platform_view/register_platform_view.stmt.kt.tmpl").readText()

    fun kotlinRegisterPlatformView(): String {
        return tmpl
            .replace("#__view_type__#", "${ext.outputOrg}/${viewType.name}")
            .replace("#__factory_name__#", viewType.name.simpleName())
    }
}