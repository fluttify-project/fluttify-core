package me.yohom.fluttify.tmpl.dart.object_factory

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.extensions.filterConstructable
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Lib
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.tmpl.dart.object_factory.create_object.CreateObjectTmpl

//import 'dart:typed_data';
//
//import 'package:flutter/services.dart';
//
//import 'package:#__current_package__#/src/android/android.export.g.dart';
//
//// ignore_for_file: non_constant_identifier_names, camel_case_types, missing_return, unused_import
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
//  static Future<android_graphics_Bitmap> createandroid_graphics_Bitmap(Uint8List bitmapBytes) async {
//    final refId =
//        await _channel.invokeMethod('ObjectFactory::createandroid_graphics_Bitmap', {'bitmapBytes': bitmapBytes});
//    return android_graphics_Bitmap()..refId = refId;
//  }
//
//  static Future<void> release(Ref_Android ref) async {
//    await _channel.invokeMethod('ObjectFactory::release', {'refId': ref.refId});
//  }
//
//  static Future<void> clearHeap() async {
//    await _channel.invokeMethod('ObjectFactory::clearHeap');
//  }
//
//  static Future<void> pushStack(String name, Ref_Android ref) async {
//    await _channel.invokeMethod('ObjectFactory::pushStack', {'name': name, 'refId': ref.refId});
//  }
//
//  static Future<void> clearStack() async {
//    await _channel.invokeMethod('ObjectFactory::clearStack');
//  }
//
//  #__create_objects__#
//}
//
//class java_lang_Object extends Ref_Android {}
//
//class android_content_Context extends java_lang_Object {}
//
//class android_app_Application extends android_content_Context {}
//
//class android_app_Activity extends android_content_Context {}
//
//class android_os_Bundle extends java_lang_Object {}
//
//class android_view_View extends java_lang_Object {}
//
//class android_widget_FrameLayout extends android_view_ViewGroup {}
//
//class android_view_ViewGroup extends android_view_View {}
//
//class android_graphics_Point extends java_lang_Object {}
//
//class android_graphics_PointF extends java_lang_Object {}
//
//class android_graphics_Bitmap extends java_lang_Object {}
//
//class android_location_Location extends java_lang_Object {}
//
//class android_view_MotionEvent extends java_lang_Object {}
//
//class android_graphics_drawable_Drawable extends java_lang_Object {}
//
//class android_widget_ImageView extends android_view_View {}
//
//class android_widget_TextView extends android_view_View {}
//
//class android_widget_LinearLayout extends android_view_ViewGroup {}
//
//class android_widget_RelativeLayout extends android_view_ViewGroup {}
//
//mixin android_os_Parcelable on java_lang_Object {}
//
//
//
//import 'dart:typed_data';
//
//import 'package:flutter/services.dart';
//
//import 'package:#__current_package__#/src/ios/ios.export.g.dart';
//
//// ignore_for_file: non_constant_identifier_names, camel_case_types, missing_return, unused_import
//class ObjectFactory_iOS {
//  static final _channel = MethodChannel('#__method_chanel__#');
//
//  static Future<CLLocationCoordinate2D> createCLLocationCoordinate2D(double latitude, double longitude) async {
//    final int refId = await _channel.invokeMethod('ObjectFactory::createCLLocationCoordinate2D', {'latitude': latitude, 'longitude': longitude});
//    return CLLocationCoordinate2D()..refId = refId;
//  }
//
//  static Future<UIImage> createUIImage(Uint8List bitmapBytes) async {
//    final refId =
//        await _channel.invokeMethod('ObjectFactory::createUIImage', {'bitmapBytes': bitmapBytes});
//    return UIImage()..refId = refId;
//  }
//
//  static Future<void> release(Ref_iOS ref) async {
//    await _channel.invokeMethod('ObjectFactory::release', {'refId': ref.refId});
//  }
//
//  static Future<void> clearHeap() async {
//    await _channel.invokeMethod('ObjectFactory::clearHeap');
//  }
//
//  static Future<void> pushStack(String name, Ref_iOS ref) async {
//    await _channel.invokeMethod('ObjectFactory::pushStack', {'name': name, 'refId': ref.refId});
//  }
//
//  static Future<void> clearStack() async {
//    await _channel.invokeMethod('ObjectFactory::clearStack');
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
//class UIEdgeInsets extends Ref_iOS {}
//
//// 类
//class CLLocationManager extends NSObject {}
//
//class NSError extends NSObject {}
//
//mixin NSCoding on NSObject {}
//
//mixin NSCopying on NSObject {}
//
//class UIView extends NSObject {}
//
//class UIControl extends NSObject {}
//
//class UIImage extends NSObject {}
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
            Platform.General -> ""
            Platform.iOS -> iosTmpl
            Platform.Android -> androidTmpl
            Platform.Unknown -> ""
        }.replace("#__current_package__#", ext.outputProjectName)
            .replace("#__method_chanel__#", "${ext.outputOrg}/${ext.outputProjectName}")
            .replaceParagraph("#__create_objects__#", libs
                .flatMap { it.types }
                .filterConstructable()
                .distinctBy { it.name }
                .joinToString("\n") { CreateObjectTmpl(it).dartCreateObject().joinToString("\n") })
    }
}