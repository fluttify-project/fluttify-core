package me.yohom.fluttify.tmpl.dart.type.type_ref

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.filterType
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.SDK
import me.yohom.fluttify.tmpl.dart.type.type_ref.type_cast.TypeCastTmpl
import me.yohom.fluttify.tmpl.dart.type.type_ref.type_check.TypeCheckTmpl

//import 'dart:typed_data';
//
//import 'package:#__current_package__#/src/ios/ios.export.g.dart';
//import 'package:#__current_package__#/src/android/android.export.g.dart';
//import 'package:flutter/services.dart';
//
//// ignore_for_file: non_constant_identifier_names, camel_case_types, missing_return, unused_import
//class Ref_#__platform__# extends Ref {
//  Future<void> performSelectorWithObject(String selector, Object object) {
//    return MethodChannel('__method_channel__').invokeMethod('Ref_#__platform__#::performSelectorWithObject', {'refId': refId, 'selector': selector, 'object': object});
//  }
//
//  #__type_checks__#
//
//  #__type_casts__#
//}
class TypeRefTmpl(private val sdk: SDK) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/ref_type.dart.tmpl").readText()

    fun dartRefClass(): String {
        val currentPackage = ext.outputProjectName
        return tmpl
            .replace("#__current_package__#", currentPackage)
            .replace("#__platform__#", sdk.platform.toString())
            .replace("#__method_channel__#", ext.methodChannelName)
            .replaceParagraph(
                "#__type_checks__#",
                sdk.libs
                    .flatMap { it.types }
                    .filterType()
                    .asSequence()
                    .filterNot { it.isLambda() }
                    .filterNot { it.isFunction() }
                    .distinctBy { it.name }
                    .filter { !it.isInterface() && !it.isEnum() }
                    .joinToString("\n") { TypeCheckTmpl(it, ext).dartTypeCheck() }
            )
            .replaceParagraph(
                "#__type_casts__#",
                sdk.libs
                    .flatMap { it.types }
                    .filterType()
                    .asSequence()
                    .filterNot { it.isLambda() }
                    .filterNot { it.isFunction() }
                    .distinctBy { it.name }
                    .filter { !it.isInterface() && !it.isEnum() }
                    .joinToString("\n") { TypeCastTmpl(it, ext).dartTypeCast() }
            )
    }
}