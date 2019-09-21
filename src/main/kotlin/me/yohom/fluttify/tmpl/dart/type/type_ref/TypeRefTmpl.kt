package me.yohom.fluttify.tmpl.dart.type.type_ref

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.extensions.filterType
import me.yohom.fluttify.extensions.replaceParagraph
import me.yohom.fluttify.model.SDK
import me.yohom.fluttify.tmpl.dart.type.type_ref.type_cast.TypeCastTmpl
import me.yohom.fluttify.tmpl.dart.type.type_ref.type_check.TypeCheckTmpl

//import 'dart:typed_data';
//
//import 'package:#__current_package__#/#__current_package__#.dart';
//import 'package:flutter/services.dart';
//
//// ignore_for_file: non_constant_identifier_names, camel_case_types
//class Ref_#__platform__# {
//  Ref(this.refId);
//
//  final int refId;
//
//  #__type_checks__#
//
//  #__type_casts__#
//}
class TypeRefTmpl(
    private val sdk: SDK,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/ref_type.dart.tmpl").readText()

    fun dartRefClass(): String {
        val currentPackage = ext.outputProjectName
        return tmpl
            .replace("#__current_package__#", currentPackage)
            .replace("#__platform__#", sdk.platform.toString())
            .replaceParagraph(
                "#__type_checks__#",
                sdk.libs
                    .flatMap { it.types }
                    .filterType()
                    .distinctBy { it.name }
                    .filter { !it.isInterface() && !it.isEnum() }
                    .joinToString("\n") { TypeCheckTmpl(it, ext).dartTypeCheck() }
            )
            .replaceParagraph(
                "#__type_casts__#",
                sdk.libs
                    .flatMap { it.types }
                    .filterType()
                    .distinctBy { it.name }
                    .filter { !it.isInterface() && !it.isEnum() }
                    .joinToString("\n") { TypeCastTmpl(it, ext).dartTypeCast() }
            )
    }
}