package me.yohom.fluttify.common.tmpl.dart.type.sdk_type

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.common.SYSTEM_TYPE
import me.yohom.fluttify.common.extensions.*
import me.yohom.fluttify.common.model.Type

//import 'dart:typed_data';
//
//import 'package:#__current_package__#/#__current_package__#.dart';
//import 'package:flutter/services.dart';
//
//// ignore_for_file: non_constant_identifier_names, camel_case_types
//class #__class_name__# extends #__super_class__# {
//  #__class_name__#.withRefId(int refId): super(refId);
//
//  static final _channel = MethodChannel('#__method_channel__#');
//
//  // 生成getters
//  #__getters__#
//
//  // 生成setters
//  #__setters__#
//
//  // 生成方法们
//  #__methods__#
//}
/**
 * 生成普通类的dart接口
 */
class SdkTypeTmpl(
    private val type: Type,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/type/sdk_type/sdk_type.dart.tmpl").readText()

    fun dartClass(): String {
        val currentPackage = ext.outputProjectName
        val className = type.name.toDartType()
        val superClass = if (type.superClass.run { isEmpty() || this in SYSTEM_TYPE.map { it.name } })
            "Ref_${type.platform}"
        else
            type.superClass.toDartType()
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
            .replace("#__super_class__#", superClass)
            .replace("#__method_channel__#", methodChannel)
            .replaceParagraph("#__getters__#", getters.joinToString("\n"))
            .replaceParagraph("#__setters__#", setters.joinToString("\n"))
            .replaceParagraph("#__methods__#", methods.joinToString("\n"))
    }
}