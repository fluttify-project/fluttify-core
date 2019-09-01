package me.yohom.fluttify.common.tmpl.dart.clazz.ref_class

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.extensions.*
import me.yohom.fluttify.common.model.Type
import me.yohom.fluttify.common.tmpl.dart.clazz.sdk_class.GetterTmpl
import me.yohom.fluttify.common.tmpl.dart.clazz.sdk_class.MethodTmpl
import me.yohom.fluttify.common.tmpl.dart.clazz.sdk_class.SetterTmpl

//import 'dart:typed_data';
//
//import 'package:#__current_package__#/#__current_package__#.dart';
//import 'package:flutter/services.dart';
//
//// ignore_for_file: non_constant_identifier_names, camel_case_types
//class Ref {
//  Ref(this.refId);
//
//  final int refId;
//
//  #__type_checks__#
//
//  #__type_casts__#
//}
class RefClassTmpl(
    private val type: Type,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/clazz/ref_class/ref_class.dart.tmpl").readText()

    fun dartClass(): String {
        val currentPackage = ext.outputProjectName
        val className = type.name.toDartType()
        val methodChannel = "${ext.outputOrg}/${ext.outputProjectName}"

        val getters = type.fields
            .filterGetters()
            .map { GetterTmpl(it).dartGetter() }

        val setters = type.fields
            .filterSetters()
            .map { SetterTmpl(it).dartSetter() }

        val methods = type.methods
            .filterMethod(getters.union(setters).toList())
            .map { MethodTmpl(it).dartMethod() }

        return tmpl
            .replace("#__current_package__#", currentPackage)
            .replace("#__class_name__#", className)
            .replace("#__method_channel__#", methodChannel)
            .replaceParagraph("#__getters__#", getters.joinToString("\n"))
            .replaceParagraph("#__setters__#", setters.joinToString("\n"))
            .replaceParagraph("#__methods__#", methods.joinToString("\n"))
    }
}