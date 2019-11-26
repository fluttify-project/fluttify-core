package me.yohom.fluttify.tmpl.dart.object_factory

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.filterConstructable
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.extensions.underscore2Camel
import me.yohom.fluttify.model.Lib
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.tmpl.dart.object_factory.create_object.CreateObjectFunctionTmpl

//import 'dart:typed_data';
//
//import 'package:flutter/foundation.dart';
//import 'package:flutter/services.dart';
//
//import 'package:#__current_package__#/src/android/android.export.g.dart';
//
//final _channel = MethodChannel('#__method_chanel__#');
//
//#__create_object_functions__#
//
//
//import 'dart:typed_data';
//
//import 'package:flutter/foundation.dart';
//import 'package:flutter/services.dart';
//
//import 'package:#__current_package__#/src/ios/ios.export.g.dart';
//
//final _channel = MethodChannel('#__method_chanel__#');
//
//#__create_object_functions__#
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
            .replaceParagraph("#__create_object_functions__#", libs
                .flatMap { it.types }
                .filterConstructable()
                .distinctBy { it.name }
                .joinToString("\n") { CreateObjectFunctionTmpl(it).dartCreateObjectFunction().joinToString("\n") })
    }
}