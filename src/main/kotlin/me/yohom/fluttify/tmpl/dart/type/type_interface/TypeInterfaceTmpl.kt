package me.yohom.fluttify.tmpl.dart.type.type_interface

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.extensions.findType
import me.yohom.fluttify.extensions.isObfuscated
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.extensions.toDartType
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.dart.type.type_interface.interface_method.InterfaceMethodTmpl

//import 'dart:typed_data';
//
//import 'package:#__current_package__#/#__current_package__#.dart';
//import 'package:flutter/services.dart';
//
//// ignore_for_file: non_constant_identifier_names, camel_case_types
//mixin #__interface_type__# on #__super_mixins__# {
//  #__interface_methods__#
//}
class TypeInterfaceTmpl(
    private val type: Type,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/interface_type.dart.tmpl").readText()

    fun dartInterface(): String {
        val currentPackage = ext.outputProjectName
        val className = type.name.toDartType()

        val allSuperType = type.interfaces.union(listOf(type.superClass))
            .filter { it.isNotBlank() }
            .filter { it.findType() != Type.UNKNOWN_TYPE }
            .filter { !it.isObfuscated() }
        val superClass = if (allSuperType.isEmpty()) "java_lang_Object" else allSuperType.joinToString()

        val methods = type.methods
            .distinctBy { "${it.name}${it.formalParams}" }
            .map { InterfaceMethodTmpl(it).dartMethod() }

        return tmpl
            .replace("#__current_package__#", currentPackage)
            .replace("#__interface_type__#", className)
            .replace("#__super_mixins__#", superClass.toDartType())
            .replaceParagraph("#__interface_methods__#", methods.joinToString("\n"))
    }
}