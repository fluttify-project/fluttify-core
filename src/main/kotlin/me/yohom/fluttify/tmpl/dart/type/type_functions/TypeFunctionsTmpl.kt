package me.yohom.fluttify.tmpl.dart.type.type_functions

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.getResource
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.dart.type.type_functions.function.TypeFunctionTmpl

//import 'dart:typed_data';
//
//import 'package:#__current_package__#/src/ios/ios.export.g.dart';
//import 'package:#__current_package__#/src/android/android.export.g.dart';
//import 'package:flutter/foundation.dart';
//import 'package:flutter/services.dart';
//
//// ignore_for_file: non_constant_identifier_names, camel_case_types, missing_return, unused_import
//#__functions__#
private val tmpl = getResource("/tmpl/dart/functions.dart.tmpl").readText()

fun TypeFunctionsTmpl(functions: List<Type>): String {
    return tmpl
        .replace("#__current_package__#", ext.projectName)
        .replaceParagraph("#__functions__#", functions.joinToString("\n") { TypeFunctionTmpl(it) })
}