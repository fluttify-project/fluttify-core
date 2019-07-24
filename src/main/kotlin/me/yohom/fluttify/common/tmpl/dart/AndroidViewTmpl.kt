package me.yohom.fluttify.common.tmpl.dart

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.simpleName
import me.yohom.fluttify.common.extensions.toDartType
import me.yohom.fluttify.common.model.Type

/**
 * 一个Android的View类, 需要生成两个类
 *
 * 1: 控制器类, 即这个View类的dart接口
 * 2: AndroidView类
 */
class AndroidViewTmpl(
    private val viewClass: Type,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/android_view.dart.tmpl").readText()

    fun dartAndroidView(): String {
        val currentPackage = ext.outputProjectName
        val viewSimpleName = viewClass.name.simpleName()
        val view = viewClass.name
        val org = ext.outputOrg
        val viewType = viewClass.name

        return tmpl
            .replace("#__current_package__#", currentPackage)
            .replace("#__view_simple_name__#", viewSimpleName)
            .replace("#__view__#", view.toDartType())
            .replace("#__org__#", org)
            .replace("#__view_type__#", viewType)
    }
}