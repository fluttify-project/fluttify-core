package me.yohom.fluttify.tmpl.dart.object_factory

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.extensions.filterConstructable
import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.extensions.toUnderscore
import me.yohom.fluttify.model.Lib
import me.yohom.fluttify.model.Platform

//import 'package:flutter/services.dart';
//
//import 'package:#__current_package__#.dart';
//
//// ignore_for_file: non_constant_identifier_names, camel_case_types
//class ObjectFactory_Android {
//  static final _channel = MethodChannel('#__method_chanel__#');
//
//  static Future<android_app_Application> getandroid_app_Application() async {
//    final refId =
//        await _channel.invokeMethod('ObjectFactory::getandroid_app_Application');
//    return android_app_Application()..refId = refId;
//  }
//
//  static Future<android_app_Activity> getandroid_app_Activity() async {
//    final refId =
//        await _channel.invokeMethod('ObjectFactory::getandroid_app_Activity');
//    return android_app_Activity()..refId = refId;
//  }
//
//  static Future<android_os_Bundle> createandroid_os_Bundle() async {
//    final refId =
//        await _channel.invokeMethod('ObjectFactory::createandroid_os_Bundle');
//    return android_os_Bundle()..refId = refId;
//  }
//
//  static Future<String> release(int refId) async {
//    return await _channel.invokeMethod('ObjectFactory::release', {'refId': refId});
//  }
//
//  static Future<android_app_Activity> clearRefMap() async {
//    return await _channel.invokeMethod('ObjectFactory::clearRefMap');
//  }
//
//  #__create_objects__#
//}
//
//class android_content_Context extends Ref_Android {}
//
//class android_app_Application extends android_content_Context {}
//
//class android_app_Activity extends android_content_Context {}
//
//class android_os_Bundle extends Ref_Android {}
//
//class android_view_View extends Ref_Android {}
//
//class android_widget_FrameLayout extends Ref_Android {}
//
//class android_view_ViewGroup extends Ref_Android {}
//
//class android_graphics_Point extends Ref_Android {}
//
//class android_graphics_PointF extends Ref_Android {}
//
//class android_graphics_Bitmap extends Ref_Android {}
//
//class android_location_Location extends Ref_Android {}
//
//class android_view_MotionEvent extends Ref_Android {}
//
//class android_graphics_drawable_Drawable extends Ref_Android {}
//
////#__interface_refs__#
//
//import 'package:flutter/services.dart';
//
//import 'package:#__current_package__#.dart';
//
//// ignore_for_file: non_constant_identifier_names, camel_case_types
//class ObjectFactory_iOS {
//  static final _channel = MethodChannel('#__method_chanel__#');
//
//  static Future<CLLocationCoordinate2D> createCLLocationCoordinate2D(double latitude, double longitude) async {
//    final int refId = await _channel.invokeMethod('ObjectFactory::createCLLocationCoordinate2D', {'latitude': latitude, 'longitude': longitude});
//    return CLLocationCoordinate2D()..refId = refId;
//  }
//
//  #__create_objects__#
//}
//
//class NSObject extends Ref_iOS {}
//
//// 结构体
//class CLLocationCoordinate2D extends Ref_iOS {}
//
//class CLLocation extends Ref_iOS {}
//
//class CGRect extends Ref_iOS {}
//
//class CGPoint extends Ref_iOS {}
//
//// 类
//class CLLocationManager extends Ref_iOS {}
//
//class NSError extends Ref_iOS {}
//
//class NSCoding extends Ref_iOS {}
//
//class NSCopying extends Ref_iOS {}
//
//class UIView extends Ref_iOS {}
//
//class UIControl extends UIView {}
//
//#__interface_refs__#
/**
 * 对象工厂
 */
class ObjectFactoryTmpl(
    val libs: List<Lib>,
    val ext: FluttifyExtension,
    val platform: Platform
) {
    private val androidTmpl =
        this::class.java.getResource("/tmpl/dart/object_factory_android.dart.tmpl").readText()
    private val iosTmpl =
        this::class.java.getResource("/tmpl/dart/object_factory_ios.dart.tmpl").readText()

    fun dartObjectFactory(): String {
        return when (platform) {
            Platform.General -> TODO()
            Platform.iOS -> iosTmpl
            Platform.Android -> androidTmpl
            Platform.Unknown -> TODO()
        }.replace("#__current_package__#", "${ext.outputProjectName}/${ext.outputProjectName}")
            .replace("#__method_chanel__#", "${ext.outputOrg}/${ext.outputProjectName}")
            .replaceParagraph("#__create_objects__#", libs
                .flatMap { it.types }
                .filterConstructable()
                .distinctBy { it.name }
                .joinToString("\n") { CreateObjectTmpl(it).dartCreateObject().joinToString("\n") })
            .replaceParagraph("#__interface_refs__#", libs
                .flatMap { it.types }
                .filter { it.isInterface() }
                .joinToString("\n") {
                    // todo 目前只展开了两层, 之后用递归实现
                    val interfaces = it
                        .interfaces
                        .union(it.interfaces.flatMap { it.findType().interfaces })
                        .reversed()
                        .union(listOf(it.name))
                        .filter { it != "NSObject" }
                    val rootClass = when (it.platform) {
                        Platform.General -> "Object"
                        Platform.iOS -> "NSObject"
                        Platform.Android -> "java_lang_Object"
                        Platform.Unknown -> "Object"
                    }
                    "class ${it.name.toUnderscore()}_Ref = $rootClass with ${interfaces.joinToString { it.toUnderscore() }};"
                })
    }
}