package me.yohom.fluttify.tmpl.dart.object_factory

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.filterConstructable
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.extensions.underscore2Camel
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
//class #__name__#FactoryAndroid {
//  static final _channel = MethodChannel('#__method_chanel__#');
//
//  #__create_objects__#
//}
//
//
//import 'dart:typed_data';
//
//import 'package:flutter/services.dart';
//
//import 'package:#__current_package__#/src/ios/ios.export.g.dart';
//
//// ignore_for_file: non_constant_identifier_names, camel_case_types, missing_return, unused_import
//class #__name__#FactoryIOS {
//  static final _channel = MethodChannel('#__method_chanel__#');
//
//  #__create_objects__#
//}
class ObjectFactoryTmpl(val libs: List<Lib>, val platform: Platform) {
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
            .replace("#__name__#", ext.outputProjectName.underscore2Camel())
            .replace("#__method_chanel__#", "${ext.outputOrg}/${ext.outputProjectName}")
            .replaceParagraph("#__create_objects__#", libs
                .flatMap { it.types }
                .filterConstructable()
                .distinctBy { it.name }
                .joinToString("\n") { CreateObjectTmpl(it).dartCreateObject().joinToString("\n") })
    }
}