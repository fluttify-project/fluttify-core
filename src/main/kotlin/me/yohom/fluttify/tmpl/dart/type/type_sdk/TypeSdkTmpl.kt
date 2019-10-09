package me.yohom.fluttify.tmpl.dart.type.type_sdk

import me.yohom.fluttify.FluttifyExtension
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Platform
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.dart.type.type_sdk.getter.GetterTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.method.MethodTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.setter.SetterTmpl

//import 'dart:typed_data';
//
//import 'package:#__current_package__#/#__current_package__#.dart';
//import 'package:flutter/services.dart';
//
//// ignore_for_file: non_constant_identifier_names, camel_case_types
//class #__class_name__# extends #__super_class__# #__mixins__# {
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
class TypeSdkTmpl(
    private val type: Type,
    private val ext: FluttifyExtension
) {
    private val tmpl = this::class.java.getResource("/tmpl/dart/sdk_type.dart.tmpl").readText()

    fun dartClass(): String {
        val currentPackage = ext.outputProjectName
        val className = type.name.toDartType()
        val superClass = if (type.superClass.isEmpty())
            when (type.platform) {
                Platform.Android -> "java_lang_Object"
                Platform.iOS -> "NSObject"
                else -> "Object"
            }
        else
            type.superClass.toDartType()

        val mixins = if (type.interfaces.isNotEmpty() && type.interfaces.none { it.findType() == Type.UNKNOWN_TYPE }) {
            // todo 使用递归处理完全, 现在只是写死了只处理了两层
            "with ${type.interfaces.union(type.interfaces.flatMap { it.findType().interfaces }).filter {
                it.findType().isInterface()
            }.reversed().joinToString { it.toDartType() }}"
        } else {
            ""
        }

        val methodChannel = if (type.isView())
            "${ext.outputOrg}/${ext.outputProjectName}/${type.name.toUnderscore()}"
        else
            "${ext.outputOrg}/${ext.outputProjectName}"

        val getters = type.fields
            .filterGetters()
            .map { GetterTmpl(it).dartGetter() }

        val setters = type.fields
            .filterSetters()
            .map { SetterTmpl(it).dartSetter() }

        val methods = type.methods
            .filterMethod()
            .map { MethodTmpl(it).dartMethod() }

        return tmpl
            .replace("#__current_package__#", currentPackage)
            .replace("#__class_name__#", className)
            .replace("#__super_class__#", superClass)
            .replace("#__mixins__#", mixins)
            .replace("#__method_channel__#", methodChannel)
            .replaceParagraph("#__getters__#", getters.joinToString("\n"))
            .replaceParagraph("#__setters__#", setters.joinToString("\n"))
            .replaceParagraph("#__methods__#", methods.joinToString("\n"))
    }
}