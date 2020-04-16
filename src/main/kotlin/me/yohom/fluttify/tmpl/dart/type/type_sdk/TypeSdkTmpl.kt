package me.yohom.fluttify.tmpl.dart.type.type_sdk

import me.yohom.fluttify.ext
import me.yohom.fluttify.extensions.*
import me.yohom.fluttify.model.Type
import me.yohom.fluttify.tmpl.dart.type.common.getter.GetterTmpl
import me.yohom.fluttify.tmpl.dart.type.common.getter_batch.GetterBatchTmpl
import me.yohom.fluttify.tmpl.dart.type.common.setter.SetterTmpl
import me.yohom.fluttify.tmpl.dart.type.common.setter_batch.SetterBatchTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.creator.CreatorBatchTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.creator.CreatorTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.method.MethodBatchTmpl
import me.yohom.fluttify.tmpl.dart.type.type_sdk.method.MethodTmpl

//import 'dart:typed_data';
//
//import 'package:#__current_package__#/src/ios/ios.export.g.dart';
//import 'package:#__current_package__#/src/android/android.export.g.dart';
//import 'package:flutter/foundation.dart';
//import 'package:flutter/services.dart';
//
//import 'package:foundation_fluttify/foundation_fluttify.dart';
//
//class #__class_name__# extends #__super_class__# #__mixins__# {
//  //region constants
//  static const String name = '#__origin_class_name__#';
//
//  #__constants__#
//  //endregion
//
//  //region creators
//  #__creators__#
//  //endregion
//
//  //region getters
//  #__getters__#
//  //endregion
//
//  //region setters
//  #__setters__#
//  //endregion
//
//  //region methods
//  #__methods__#
//  //endregion
//}
//
//extension #__class_name__#_Batch on List<#__class_name__#> {
//  //region getters
//  #__getters_batch__#
//  //endregion
//
//  //region setters
//  #__setters_batch__#
//  //endregion
//
//  //region methods
//  #__methods_batch__#
//  //endregion
//}
private val tmpl = getResource("/tmpl/dart/sdk_type.dart.tmpl").readText()

fun TypeSdkTmpl(type: Type): String {
    val currentPackage = ext.projectName
    val className = if (type.genericTypes.isNotEmpty()) {
        "${type.name.toDartType()}<${type.genericTypes.joinToString()}>"
    } else {
        type.name.toDartType()
    }
    val originClassName = type.name.replace("$", ".")
    // 如果父类是混淆类, 那么直接继承Object类
    val superClass = if (type.superClass.run { isEmpty() || isObfuscated() })
        type.platform.objectType()
    else
        type.superClass.toDartType()

    // 如果含有非混淆类的接口, 再以mixin的方式集成
    val mixins = if (type.ancestorInterfaces(false).isNotEmpty()) {
        "with ${type.ancestorInterfaces(false).reversed().joinToString { it.toDartType() }}"
    } else {
        ""
    }

    // 常量
    val constants = type.fields
        .filterConstants()
        .joinToString("\n") { "static final ${it.variable.trueType.toDartType()} ${it.variable.name} = ${it.value.removeNumberSuffix()};" }

    // 构造器
    val creators = if (type.constructable()) {
        CreatorTmpl(type).union(CreatorBatchTmpl(type)).toList()
    } else {
        listOf()
    }

    val getters = type.fields
        .filterGetters()
        .map { GetterTmpl(it) }

    val setters = type.fields
        .filterSetters()
        .map { SetterTmpl(it) }

    val methods = type.methods
        .filterMethod()
        .map { MethodTmpl(it) }

    val gettersBatch = type.fields
        .filterGetters()
        .map { GetterBatchTmpl(it) }

    val settersBatch = type.fields
        .filterSetters(true)
        .map { SetterBatchTmpl(it) }

    val methodsBatch = type.methods
        .filterMethod(true)
        .map { MethodBatchTmpl(it) }

    return tmpl
        .replace("#__current_package__#", currentPackage)
        .replace("#__class_name__#", className)
        .replace("#__origin_class_name__#", originClassName)
        .replace("#__super_class__#", superClass)
        .replace("#__mixins__#", mixins)
        .replaceParagraph("#__constants__#", constants)
        .replaceParagraph("#__creators__#", creators.joinToString("\n"))
        .replaceParagraph("#__getters__#", getters.joinToString("\n"))
        .replaceParagraph("#__setters__#", setters.joinToString("\n"))
        .replaceParagraph("#__methods__#", methods.joinToString("\n"))
        .replaceParagraph("#__getters_batch__#", gettersBatch.joinToString("\n"))
        .replaceParagraph("#__setters_batch__#", settersBatch.joinToString("\n"))
        .replaceParagraph("#__methods_batch__#", methodsBatch.joinToString("\n"))
}