package me.yohom.fluttify.common.tmpl.dart.object_factory

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.filterConstructable
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.model.Lib
import me.yohom.fluttify.common.model.Platform

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
//        await _channel.invokeMethod('SystemRef::getandroid_app_Application');
//    return android_app_Application.withRefId(refId);
//  }
//
//  static Future<android_app_Activity> getandroid_app_Activity() async {
//    final refId =
//        await _channel.invokeMethod('SystemRef::getandroid_app_Activity');
//    return android_app_Activity.withRefId(refId);
//  }
//
//  static Future<android_os_Bundle> createandroid_os_Bundle() async {
//    final refId =
//        await _channel.invokeMethod('SystemRef::createandroid_os_Bundle');
//    return android_os_Bundle.withRefId(refId);
//  }
//
//  static Future<String> release(int refId) async {
//    return await _channel.invokeMethod('SystemRef::release', {'refId': refId});
//  }
//
//  static Future<android_app_Activity> clearRefMap() async {
//    return await _channel.invokeMethod('SystemRef::clearRefMap');
//  }
//
//  #__create_objects__#
//}
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
//    final int refId = await _channel.invokeMethod('ObjectFactory::createCLLocationCoordinate2D, {'latitude': latitude, 'longitude': longitude});
//    return CLLocationCoordinate2D.withRefId(refId);
//  }
//
//  #__create_objects__#
//}
/**
 * 对象工厂
 */
class ObjectFactoryTmpl(
    val libs: List<Lib>,
    val ext: FluttifyExtension,
    val platform: Platform
) {
    private val androidTmpl = this::class.java.getResource("/tmpl/dart/object_factory/object_factory_android.dart.tmpl").readText()
    private val iosTmpl = this::class.java.getResource("/tmpl/dart/object_factory/object_factory_ios.dart.tmpl").readText()

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

    }
}