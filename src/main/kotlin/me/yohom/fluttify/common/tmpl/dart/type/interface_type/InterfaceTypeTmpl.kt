package me.yohom.fluttify.common.tmpl.dart.type.interface_type

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.replaceParagraph
import me.yohom.fluttify.common.extensions.toDartType
import me.yohom.fluttify.common.model.Type

//import 'dart:typed_data';
//
//import 'package:#__current_package__#/#__current_package__#.dart';
//import 'package:flutter/services.dart';
//
//// ignore_for_file: non_constant_identifier_names, camel_case_types
//mixin #__interface_type__# on #__super_mixins__# {
//  #__interface_methods__#
//}
class InterfaceTypeTmpl(
    private val type: Type,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/type/interface_type/interface_type.dart.tmpl").readText()

    fun dartInterface(): String {
        val currentPackage = ext.outputProjectName
        val className = type.name.toDartType()

        val allSuperType = type.interfaces.union(listOf(type.superClass)).filter { it.isNotBlank() }
        val superClass = if (allSuperType.isEmpty()) "Object" else allSuperType.joinToString()

        val methods = type.methods
            .map { InterfaceMethodTmpl(it).dartMethod() }

        return tmpl
            .replace("#__current_package__#", currentPackage)
            .replace("#__interface_type__#", className)
            .replace("#__super_mixins__#", superClass)
            .replaceParagraph("#__interface_methods__#", methods.joinToString("\n"))
    }
}