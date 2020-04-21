package me.yohom.fluttify.tmpl.dart.type.type_interface

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.dart.type.common.getter.GetterTmpl
import me.yohom.fluttify.tmpl.dart.type.common.setter.SetterTmpl
import me.yohom.fluttify.tmpl.dart.type.type_interface.interface_method.InterfaceMethodTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.method.MethodTmpl

//import 'dart:typed_data';
//
//import 'package:#__current_package__#/src/ios/ios.export.g.dart';
//import 'package:#__current_package__#/src/android/android.export.g.dart';
//import 'package:flutter/foundation.dart';
//import 'package:flutter/services.dart';
//
//// ignore_for_file: non_constant_identifier_names, camel_case_types, missing_return, unused_import
//mixin #__interface_type__# on #__super_mixins__# {
//  #__constants__#
//
//  #__getters__#
//
//  #__setters__#
//
//  #__interface_methods__#
//}
private val tmpl = getResource("/tmpl/dart/interface_type.dart.tmpl").readText()

fun TypeInterfaceTmpl(type: Type): String {
    val currentPackage = ext.projectName
    val typeName = if (type.genericTypes.isNotEmpty()) {
        "${type.name.toDartType()}<${type.genericTypes.joinToString()}>"
    } else {
        type.name.toDartType()
    }

    val constants = type.fields.filterConstants()

    val allSuperType = type.interfaces.union(listOf(type.superClass))
        .filter { it.isNotBlank() }
        .filter { it.findType().platform != Platform.Unknown }
        .filter { !it.isObfuscated() }
    val superClass = if (allSuperType.isEmpty()) type.platform.objectType() else allSuperType.joinToString()

    val methods = type.methods
        .filterMethod()
        .map {
            // 只有回调类不需要调用原生方法
            if (type.isCallback()) {
                InterfaceMethodTmpl(it)
            } else {
                MethodTmpl(it)
            }
        }

    val getters = type.fields
        .filterGetters()
        .map { GetterTmpl(it) }

    val setters = type.fields
        .filterSetters()
        .map { SetterTmpl(it) }

    return tmpl
        .replace("#__current_package__#", currentPackage)
        .replaceParagraph("#__foundation__#", ext.foundationVersion.keys.joinToString("\n") { "import 'package:$it/$it.dart';" })
        .replace("#__interface_type__#", typeName)
        .replace("#__super_mixins__#", superClass.toDartType())
        .replaceParagraph(
            "#__constants__#",
            constants.joinToString("\n") { "static final ${it.variable.trueType.toDartType()} ${it.variable.name} = ${it.value};" })
        .replaceParagraph("#__interface_methods__#", methods.joinToString("\n"))
        .replaceParagraph("#__getters__#", getters.joinToString("\n"))
        .replaceParagraph("#__setters__#", setters.joinToString("\n"))
}