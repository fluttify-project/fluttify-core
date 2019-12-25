package me.yohom.fluttify.tmpl.dart.type.type_interface

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.dart.type.common.getter.GetterTmpl
import me.yohom.fluttify.tmpl.dart.type.common.setter.SetterTmpl
import me.yohom.fluttify.tmpl.dart.type.type_interface.interface_method.InterfaceMethodTmpl

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
class TypeInterfaceTmpl(
    private val type: Type,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/interface_type.dart.tmpl").readText()

    fun dartInterface(): String {
        val currentPackage = ext.projectName
        val className = type.name.toDartType()

        val constants = type.fields.filterConstants()

        val allSuperType = type.interfaces.union(listOf(type.superClass))
            .filter { it.isNotBlank() }
            .filter { it.findType() != Type.UNKNOWN_TYPE }
            .filter { !it.isObfuscated() }
        val superClass = if (allSuperType.isEmpty()) "java_lang_Object" else allSuperType.joinToString()

        val methods = type.methods
            .filterMethod()
            .map { InterfaceMethodTmpl(it).dartInterfaceMethod() }

        val getters = type.fields
            .filterGetters()
            .map { GetterTmpl(it).dartGetter() }

        val setters = type.fields
            .filterSetters()
            .map { SetterTmpl(it).dartSetter() }

        return tmpl
            .replace("#__current_package__#", currentPackage)
            .replace("#__interface_type__#", className)
            .replace("#__super_mixins__#", superClass.toDartType())
            .replaceParagraph("#__constants__#", constants.joinToString("\n") { "static final ${it.variable.typeName.toDartType()} ${it.variable.name} = ${it.value};" })
            .replaceParagraph("#__interface_methods__#", methods.joinToString("\n"))
            .replaceParagraph("#__getters__#", getters.joinToString("\n"))
            .replaceParagraph("#__setters__#", setters.joinToString("\n"))
    }
}